import java.io.*;
import java.util.Vector;

/**
 * Created by xiaom on 2017/8/5.
 */
public class FileTransfer {
//    public File file;
//    public FileTransfer(String fileName){
//        this.file=new File(fileName);
//    }
//
//    RandomAccessFile readFile(File file){
//        try{
//            RandomAccessFile in=new RandomAccessFile(file,"r");
//            return in;
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }
    //randomAccessFile不可序列化，导致RMI出错
    //尝试使用InputStream,仍然不行
//   public FileInputStream readFile(String fileName){
//        try{
//            FileInputStream inFile=new FileInputStream(fileName);
//            return inFile;
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }

//    public File readFile(String fileName){
//        File inFile=new File(fileName);
//        return inFile;
//    }
    ///rmi是不支持文件流的序列化的
    //那么暂且使用字节数组进行传送，这种方式的内存开销很大
    public Vector<byte[]> readFile(String fileName){
        Vector<byte[]> vector=new Vector<byte[]>();
        File inFile=new File(fileName);
        long fileLength=inFile.length();//文件长度
        byte[] bytes=new byte[1024];
        long leftLength=fileLength;
        try{
            RandomAccessFile in=new RandomAccessFile(inFile,"r");
            int len=0;
            while(leftLength>=1024 && (len=in.read(bytes))!=-1){//如果剩余长度大于1024
                vector.addElement(bytes.clone());//注意加入到vector当中的必须是实际的拷贝，否则每次都会被改变
                leftLength-=1024;
            }
            if(leftLength>0){//若有剩余
                byte[] last=new byte[(int)leftLength];
                vector.addElement(last);
            }
            return vector;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }





}
