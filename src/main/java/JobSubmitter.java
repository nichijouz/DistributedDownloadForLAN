import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by xiaom on 2017/8/6.
 */
public class JobSubmitter {//任务提交
    public static void submitJob(String urlLocation, NodeManager nodeManager,String finalName,String jobName,int jobNum,Vector<String[]> properties){
        Vector<NodeInfo> nodesInfo=nodeManager.getNodes();//节点信息

        JobQueue jobQueue=InitialJobQueue.initialJob(urlLocation,jobNum,jobName,properties);//初始化任务队列
//        System.out.println("Ok");
        ArrayList<String[]> jobs=jobQueue.getJobQueue();//获取初始任务队列,其中的每个任务都是字符串数组

        DownloadSpeedTestThread downloadSpeedTestThread=null;


        int count=0;//使用count循环选择节点
        Vector<DownloadRequest> handled=new Vector<DownloadRequest>();//已处理的任务

        while(jobs.size()!=0){
            System.out.println("There are "+jobs.size()+" job(s) remained,please wait");
            Vector<DownloadThread> downloadThreads=new Vector<DownloadThread>();

            //增加一个Vector以计算下载速度
            Vector<DownloadRequest> requests=new Vector<DownloadRequest>();



            for(String[] job:jobs){

                NodeInfo nodeInfo=nodesInfo.elementAt(count);
                DownloadRequest downloadRequest=new DownloadRequest(job[0],Long.parseLong(job[1]),Long.parseLong(job[2]),job[3],nodeInfo.remotePort,nodeInfo.remoteUrl);
                count+=1;
                count%=nodesInfo.size();//循环
//                System.out.println("count is:"+count);
                DownloadThread t=new DownloadThread(jobs,handled,downloadRequest,job,properties);

                //将下载请求加入到vector
                requests.addElement(downloadRequest);


                t.start();
                downloadThreads.addElement(t);//将线程加入到
            }

            //启动下载速度检测线程
            downloadSpeedTestThread=new DownloadSpeedTestThread(requests);
            downloadSpeedTestThread.start();//开始计算下载速度

            for(DownloadThread t:downloadThreads){
                try{
                    t.join();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        Vector<FileReceiverThread> receivers=new Vector<FileReceiverThread>();

        downloadSpeedTestThread.interrupt();


        System.out.println("=====now receiving file=====");
        for(DownloadRequest downloadRequest:handled){
            FileReceiverThread fileReceiverThread=new FileReceiverThread(downloadRequest);
            fileReceiverThread.start();
            receivers.addElement(fileReceiverThread);
        }

        for(FileReceiverThread t:receivers){
            try{
                t.join();
            }catch (Exception e){
                e.printStackTrace();
            }

        }


        System.out.println("=====now combine files=====");

        String[] files=new String[handled.size()];
        int i=0;
        for(DownloadRequest request:handled){
            files[i]=request.fileName;
            i+=1;
        }


        DownloadFileCombiner.combine(files,finalName);

        System.out.println();

        System.out.println("=====All done=====");

    }

}
