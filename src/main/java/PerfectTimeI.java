import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by xiaom on 2017/8/3.
 */
public interface PerfectTimeI extends Remote{
    long getPerfectTime() throws RemoteException;
}
