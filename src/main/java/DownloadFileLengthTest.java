import java.io.File;

/**
 * Created by xiaom on 2017/8/6.
 */
public class DownloadFileLengthTest {//服务器端检测文件的长度，以计算下载速度
    public static long fileLengthTest(String fileName){
        File file=new File(fileName);
        return file.length();
    }
}
