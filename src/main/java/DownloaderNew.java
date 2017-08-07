import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Vector;

/**
 * Created by xiaom on 2017/8/6.
 */
public class DownloaderNew {
    //http://dldir1.qq.com/qqfile/qq/QQ8.9.4/21584/QQ8.9.4.exe
    private String urlLocation;//下载地址
    private long start;//下载的分段起始偏移
    private long end;//下载的分段结束偏移
    private String fileName;//下载保存的文件名称
    private Vector<String[]> properties;//保存一些附加的额外设置

    RandomAccessFile out;
    InputStream in;

    public DownloaderNew(String urlLocation,long start,long end,String fileName,Vector<String[]> properties){//构造函数
        this.urlLocation=urlLocation;
        this.start=start;
        this.end=end;
        this.fileName=fileName;
        this.properties=properties;
    }

    public boolean Download() throws Exception{
        try{
            HttpURLConnection conn=getHttp();
            conn.setRequestProperty("Range","bytes="+start+"-"+end);//设置要获取的文件分段
            for(String[] property:properties){
                conn.setRequestProperty(property[0],property[1]);
            }




            File file=new File(fileName);
//            RandomAccessFile out=null;
            if(file!=null){//如果文件创建成功
                out=new RandomAccessFile(file,"rwd");//rwd方式表示对于文件的更新要同步写入到文件之中
            }
//            InputStream in=conn.getInputStream();//获取文件输入流
            in=conn.getInputStream();
            byte[] b=new byte[1024];
            int len=0;
            while((len=in.read(b))!=-1){//每次从输入流中读取1024字节至字节数组b中，直到文件尾
                out.write(b,0,len);//向文件中写数据
            }
            in.close();
            out.close();//关闭输入输出
        }catch(Exception e) {
            if(in!=null){
                in.close();
            }
            if(out!=null){
                out.close();
            }
            e.printStackTrace();
            return false;
        }

        return true;



    }

    public  HttpURLConnection getHttp() throws IOException {//获取http连接
        URL url=null;
        if(urlLocation!=null){
            url=new URL(urlLocation);
        }
        HttpURLConnection conn=(HttpURLConnection)url.openConnection();//建立http连接
        conn.setReadTimeout(5000);
        conn.setRequestMethod("GET");
        return conn;
    }
}
