import java.io.File;

/**
 * Created by xiaom on 2017/8/6.
 */
public class FileReceiverThread extends Thread implements Runnable {
    private DownloadRequest downloadRequest;
    public FileReceiverThread(DownloadRequest downloadRequest){
        this.downloadRequest=downloadRequest;
        FileReceiver fileReceiver=new FileReceiver();
        fileReceiver.receiveFile(downloadRequest);
    }
}
