import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * Created by xiaom on 2017/8/4.
 */
public class DownloadFileCombiner {//合并文件
    private String[] fileNames;//需要合并的文件数组
    private String finalFileName;//指定最终需要的文件名称
    public DownloadFileCombiner(String[] fileNames,String finalFileName){
        this.fileNames=fileNames;
        this.finalFileName=finalFileName;
    }

    public static boolean combine(String[] fileNames,String finalFileName){
        Arrays.sort(fileNames);
        File file=new File(finalFileName);//合并的文件
        long initialLength=0;
        try{
            RandomAccessFile out=new RandomAccessFile(file,"rwd");//创建随机文件
            for (int i = 0; i <fileNames.length ; i++) {
                File tmp=new File(fileNames[i]);
                long fileLength=tmp.length();//文件长度
                initialLength+=fileLength;
                RandomAccessFile inFile=new RandomAccessFile(tmp,"r");//以只读方式打开源文件
                byte[] b=new byte[1024];//每次读取1024字节
                int len=0;
                while((len=inFile.read(b))!=-1){
                    out.write(b,0,len);//写入文件
                }
                out.seek(initialLength);
                inFile.close();
            }
            out.close();
        }catch (IOException e){
            e.getMessage();
            return false;
        }
        System.out.print("The file length is: "+initialLength);
        return true;

    }
}
