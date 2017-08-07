import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by xiaom on 2017/8/6.
 */
public class DownloadThread extends Thread implements Runnable {
    ArrayList<String[]> jobs;
    Vector<DownloadRequest> handled;
    DownloadRequest downloadRequest;
    String[] job;
    Vector<String[]> properties;
    public DownloadThread(ArrayList<String[]> jobs,Vector<DownloadRequest> handled,DownloadRequest downloadRequest,String[] job,Vector<String[]> properties){
        this.jobs=jobs;
        this.handled=handled;
        this.downloadRequest=downloadRequest;
        this.job=job;
        this.properties=properties;//额外属性
    }

    @Override
    public void run() {
        boolean flag=false;
        DispatchDownloadJob dispatchDownloadJob=new DispatchDownloadJob();
        flag=dispatchDownloadJob.sendDownloadJob(downloadRequest,properties);
        if(flag){
            handled.addElement(downloadRequest);
            jobs.remove(job);
        }
    }
}
