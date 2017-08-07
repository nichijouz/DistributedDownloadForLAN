import java.util.Vector;

/**
 * Created by xiaom on 2017/8/6.
 */
public class InitialJobQueue {//初始化任务队列

    public static JobQueue initialJob(String urlLocation,int jobNum,String jobName,Vector<String[]> properties){
        Vector<String[]> unhandled=new Vector<String[]>();//初始化未处理任务列表
        int jobCount=0;
        try{
            long fileLength=DownloadHelper.getContentLength(urlLocation,properties);
            Vector<long[]> ranges=DownloadJobSplit.lengthSplit(fileLength,jobNum);
            for(long[] range:ranges){
                String[] job=new String[]{urlLocation,Long.toString(range[0]),Long.toString(range[1]),jobName+Integer.toString(jobCount)};
                unhandled.addElement(job);
                jobCount+=1;
            }
            JobQueue jobQueue=new JobQueue(unhandled);
            return jobQueue;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
