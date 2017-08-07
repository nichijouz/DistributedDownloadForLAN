import java.util.Vector;

/**
 * Created by xiaom on 2017/8/6.
 */
public class DownloadSpeedTest {//计算下载速度
    public static long totalFileLength=0;//初始文件长度
    public static long countDownloadSpeed(Vector<DownloadRequest> requests)throws Exception{
        long len=0;
        for(DownloadRequest downloadRequest:requests){
            len+=GetDownloadFileInfo.getFileLength(downloadRequest.fileName,downloadRequest.remoteUrl,downloadRequest.remotePort);
        }
        long addlength=(len-totalFileLength)/1024;
        totalFileLength=len;//更新总文件长度
        return addlength;//返回文件增量值，单位是kb
    }
}
