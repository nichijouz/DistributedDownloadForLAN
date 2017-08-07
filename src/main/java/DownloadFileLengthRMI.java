import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by xiaom on 2017/8/6.
 */
public class DownloadFileLengthRMI extends UnicastRemoteObject implements FileInfoService {
    DownloadFileLengthRMI()throws RemoteException{
    }
    public long fileLengthTest(String fileName) throws RemoteException {
        return DownloadFileLengthTest.fileLengthTest(fileName);
    }
}
