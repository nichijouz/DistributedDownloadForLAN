import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Vector;

/**
 * Created by xiaom on 2017/8/4.
 */
public class DownloadHelper {//获取要下载的文件信息
    private String urlLocation;
    public DownloadHelper(String urlLocation){
        this.urlLocation=urlLocation;
    }

    public static long getContentLength(String urlLocation, Vector<String[]> properties)throws Exception{//返回要下载的文件长度
        URL url=null;
        if(urlLocation!=null){
            url=new URL(urlLocation);
        }



        HttpURLConnection conn=(HttpURLConnection)url.openConnection();
        //设置额外属性
        for(String[] property:properties){
            conn.setRequestProperty(property[0],property[1]);
        }
        conn.setReadTimeout(5000);
        conn.setRequestMethod("GET");
//        Thread.sleep(1000);
        long len=conn.getContentLengthLong();
        return len;
    }


}
