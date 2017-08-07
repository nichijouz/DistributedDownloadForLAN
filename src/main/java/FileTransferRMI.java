import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

/**
 * Created by xiaom on 2017/8/5.
 */
public class FileTransferRMI extends UnicastRemoteObject implements FileService {//文件传输的RMI,接口应该只负责调用，不要涉及过多的内部参数
    public FileTransferRMI() throws RemoteException{
    }

//    public RandomAccessFile readFile(String fileName)throws RemoteException{
//       FileTransfer fileTransfer=new FileTransfer(fileName);
//       RandomAccessFile inFile=fileTransfer.readFile(fileTransfer.file);
//       return inFile;
//    }
//    public FileInputStream readFile(String fileName) throws RemoteException{
//        FileTransfer fileTransfer=new FileTransfer();
//        FileInputStream fileInputStream=fileTransfer.readFile(fileName);
//        return fileInputStream;
//    }
    public Vector<byte[]> readFile(String fileName)throws RemoteException{
        FileTransfer fileTransfer=new FileTransfer();
        return fileTransfer.readFile(fileName);
    }

}
