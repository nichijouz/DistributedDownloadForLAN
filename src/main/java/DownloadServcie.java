import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 * Created by xiaom on 2017/8/5.
 */
public interface DownloadServcie extends Remote{//RMI类必须实现一个继承自Remote的接口
//    public boolean Download(String urlLocation,long start,long end,String fileName) throws RemoteException;
    public boolean Download(String urlLocation, long start, long end, String fileName, Vector<String[]> properties)throws RemoteException;
}
