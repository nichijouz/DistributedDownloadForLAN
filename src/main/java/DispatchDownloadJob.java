import java.rmi.Naming;
import java.util.Vector;

/**
 * Created by xiaom on 2017/8/5.
 */
public class DispatchDownloadJob {
//    public boolean sendDownloadJob(DownloadRequest downloadRequest){//发送具体的下载任务
//        boolean downloadFlag=false;
//        try {
//            DownloadServcie downloaderRMI = (DownloadServcie) Naming.lookup("//" + downloadRequest.remoteUrl + ":" + downloadRequest.remotePort + "/DownloaderRMI");//而且返回类必须转换为接口
//            System.out.println(downloadRequest.toString()+" starting...");
//            downloadFlag=downloaderRMI.Download(downloadRequest.urlLocation, downloadRequest.start, downloadRequest.end, downloadRequest.fileName);
//            if(downloadFlag){
//                System.out.println("Download Job "+downloadRequest.toString()+" SUCCESS");
//            }else{
//                System.out.println("Download Job "+downloadRequest.toString()+" Failed");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Download Job "+downloadRequest.toString()+" Failed");
//        }
//        return downloadFlag;
//    }
public boolean sendDownloadJob(DownloadRequest downloadRequest, Vector<String[]> properties){//发送具体的下载任务
    boolean downloadFlag=false;
    try {
        DownloadServcie downloaderRMI = (DownloadServcie) Naming.lookup("//" + downloadRequest.remoteUrl + ":" + downloadRequest.remotePort + "/DownloaderRMI");//而且返回类必须转换为接口
        System.out.println(downloadRequest.toString()+" starting...");
        downloadFlag=downloaderRMI.Download(downloadRequest.urlLocation, downloadRequest.start, downloadRequest.end, downloadRequest.fileName,properties);
        if(downloadFlag){
            System.out.println("Download Job "+downloadRequest.toString()+" SUCCESS");
        }else{
            System.out.println("Download Job "+downloadRequest.toString()+" Failed");
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Download Job "+downloadRequest.toString()+" Failed");
    }
    return downloadFlag;
}
}
