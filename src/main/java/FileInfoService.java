import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by xiaom on 2017/8/6.
 */
public interface FileInfoService extends Remote {
    public  long fileLengthTest(String fileName)throws RemoteException;
}
