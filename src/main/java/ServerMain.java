import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by xiaom on 2017/8/5.
 */
public class ServerMain {//服务器端
    public static String bindPort;//端口
    public static String bindUrl;//ip
//    public static String bindServiceName;//服务名称//简化设置，服务名称固定

    public ServerMain(String bindUrl,String bindPort){
        this.bindPort=bindPort;
        this.bindUrl=bindUrl;
//        this.bindServiceName=bindServiceName;
    }

    public static void main(String[] args) {
        ServerMain serverMain=new ServerMain(args[0],args[1]);//从命令行获取参数

        System.out.println("bindPort:"+bindPort);
        System.out.println("bindUrl:"+bindUrl);
//        System.out.println("bindServiceName:"+bindServiceName);
        //绑定下载服务至指定端口
        try{
            LocateRegistry.createRegistry(Integer.parseInt(bindPort));
            DownloaderRMI downloaderRMI=new DownloaderRMI();//创建远程对象实例
            FileTransferRMI fileTransferRMI=new FileTransferRMI();
            DownloadFileLengthRMI fileLengthRMI=new DownloadFileLengthRMI();
            Naming.bind("//"+bindUrl+":"+bindPort+"/DownloaderRMI",downloaderRMI);//注册远程对象,可以自定义地址和服务名，PerfectTime就是服务名
            System.out.println("DownloaderRMI started!");
            Naming.bind("//"+bindUrl+":"+bindPort+"/FileTransferRMI",fileTransferRMI);
            System.out.println("FileTransferRMI started!");
            Naming.bind("//"+bindUrl+":"+bindPort+"/FileLengthInfoRMI",fileLengthRMI);//文件信息服务
            System.out.println("FileLengthInfoRMI started!");

            System.out.println("Ready to do time");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
