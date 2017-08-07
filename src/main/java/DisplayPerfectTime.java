import java.rmi.Naming;
import java.rmi.RMISecurityManager;

/**
 * Created by xiaom on 2017/8/3.
 */
public class DisplayPerfectTime {
    public static void main(String[] args) {
//        System.setSecurityManager(new RMISecurityManager());
        try{
            PerfectTimeI t=(PerfectTimeI) Naming.lookup("//localhost:2005/PerfectTime");//获得服务接口
            for (int i = 0; i <10 ; i++) {
                System.out.println("Perfect time="+t.getPerfectTime());//进行调用
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
