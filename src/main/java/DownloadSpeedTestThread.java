import java.util.Vector;

/**
 * Created by xiaom on 2017/8/6.
 */
public class DownloadSpeedTestThread extends Thread implements Runnable{
    private Vector<DownloadRequest> requests;
    public DownloadSpeedTestThread(Vector<DownloadRequest> requests){
        this.requests=requests;
    }

    @Override
    public void run() {
        try{
            while(true){
                long speed=DownloadSpeedTest.countDownloadSpeed(requests);
                System.out.println("now download speed is "+speed+ "kb/s");
                sleep(1000);//休眠一秒
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
