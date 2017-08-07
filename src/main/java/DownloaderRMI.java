import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

/**
 * Created by xiaom on 2017/8/5.
 */
public class DownloaderRMI extends UnicastRemoteObject implements DownloadServcie{//接受RMI下载调用，RMI类必须实现继承自Remote的接口，并且继承自UnicatsRemoteObject
    public DownloaderRMI()throws RemoteException{

    }

//    public boolean Download(String urlLocation,long start,long end,String fileName) throws RemoteException{//具体的下载函数调用
//        boolean DOWNLOADSUCCESS=true;
//        boolean DOWNLOADFAILED=false;//这些flag应当集中放到一个static类中
//        boolean flag;
//        Downloader downloader=new Downloader(urlLocation,start,end,fileName);
//
//        try{
//            flag=downloader.Download();
//        }catch (Exception e){
//            flag=false;
//            e.printStackTrace();
//        }
//
//        if(flag==DOWNLOADSUCCESS){
//            return true;
//        }else{
//            return false;
//        }
//    }
public boolean Download(String urlLocation, long start, long end, String fileName, Vector<String[]> properties) throws RemoteException{//具体的下载函数调用
    boolean DOWNLOADSUCCESS=true;
    boolean DOWNLOADFAILED=false;//这些flag应当集中放到一个static类中
    boolean flag;
//    Downloader downloader=new Downloader(urlLocation,start,end,fileName);
    DownloaderNew downloader=new DownloaderNew(urlLocation,start,end,fileName,properties);
    try{
        flag=downloader.Download();
    }catch (Exception e){
        flag=false;
        e.printStackTrace();
    }

    if(flag==DOWNLOADSUCCESS){
        return true;
    }else{
        return false;
    }
}

}
