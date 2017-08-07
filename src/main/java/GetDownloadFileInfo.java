import java.rmi.Naming;

/**
 * Created by xiaom on 2017/8/6.
 */
public class GetDownloadFileInfo {//获取远程文件信息
    public static long getFileLength(String fileName,String remoteUrl,String remotePort)throws Exception{//获取远程文件的长度
        FileInfoService downloadFileLengthRMI=(FileInfoService) Naming.lookup("//"+remoteUrl+":"+remotePort+"/FileLengthInfoRMI");
        return downloadFileLengthRMI.fileLengthTest(fileName);
    }
}
