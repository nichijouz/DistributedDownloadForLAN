import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.rmi.Naming;
import java.util.Vector;

/**
 * Created by xiaom on 2017/8/5.
 */
public class FileReceiver {//从服务端接收文件
    public void receiveFile(DownloadRequest downloadRequest){
        try{
            FileService fileTransferRMI=(FileService) Naming.lookup("//" + downloadRequest.remoteUrl + ":" + downloadRequest.remotePort + "/FileTransferRMI");
            System.out.println("Receive Job "+downloadRequest.toString()+" starting...");
            Vector<byte[]> vector=fileTransferRMI.readFile(downloadRequest.fileName);
            if(vector==null){
                System.out.println("The file is empty!");
                System.out.println("Receive Job "+downloadRequest.toString()+"Failed");
                System.exit(-1);
            }

            File file=new File(downloadRequest.fileName);
            RandomAccessFile out=new RandomAccessFile(file,"rwd");

            for(byte[] bytes:vector){
                out.write(bytes);
            }
            System.out.println("Receive Job "+downloadRequest.toString()+"Finished!");
            out.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Receive Job "+downloadRequest.toString()+"Failed");
            System.exit(-1);
        }
    }
}
