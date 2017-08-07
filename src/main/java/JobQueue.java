import java.util.ArrayList;
import java.util.Queue;
import java.util.Vector;

/**
 * Created by xiaom on 2017/8/6.
 */
public class JobQueue {//任务队列
    private ArrayList<String[]> jobQueue;
    public JobQueue(Vector<String[]> jobs){//用vector来初始化队列
        jobQueue=new ArrayList<String[]>();
        for(String[] job:jobs){
            jobQueue.add(job);
        }
    }

    public JobQueue(){
        jobQueue=new ArrayList<String[]>();
    }

    public ArrayList<String[]> getJobQueue() {
        return jobQueue;
    }
}
