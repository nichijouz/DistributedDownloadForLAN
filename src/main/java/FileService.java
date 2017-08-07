import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 * Created by xiaom on 2017/8/5.
 */
public interface FileService extends Remote {//远程文件传输接口
    public Vector<byte[]> readFile(String fileName)throws RemoteException;
}
