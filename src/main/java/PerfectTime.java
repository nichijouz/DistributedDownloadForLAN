import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by xiaom on 2017/8/3.
 */
public class PerfectTime extends UnicastRemoteObject implements PerfectTimeI{
    public long getPerfectTime() throws RemoteException {
        return System.currentTimeMillis();
    }

    public PerfectTime() throws RemoteException{

    }

    public static void main(String[] args) {
//          System.setSecurityManager(new RMISecurityManager());//创建安全管理器
        try{
            LocateRegistry.createRegistry(2005);
            PerfectTime pt=new PerfectTime();//创建远程对象实例
            Naming.bind("//127.0.0.1:2005/PerfectTime",pt);//注册远程对象,可以自定义地址和服务名，PerfectTime就是服务名
            System.out.println("Ready to do time");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
