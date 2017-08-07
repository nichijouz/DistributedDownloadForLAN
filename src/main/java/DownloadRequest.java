/**
 * Created by xiaom on 2017/8/5.
 */
public class DownloadRequest {//封装下载请求
    public String urlLocation;//下载地址
    public long start;//range起始
    public long end;//range结束
    public String fileName;//保存的文件名称

    public String remotePort;//服务器端口
    public String remoteUrl;//服务器ip
//    public String remoteServiceName;//远程服务名

    public DownloadRequest(String urlLocation,long start,long end,String fileName,String remotePort,String remoteUrl){
        this.urlLocation=urlLocation;
        this.start=start;
        this.end=end;
        this.fileName=fileName;
        this.remotePort=remotePort;
        this.remoteUrl=remoteUrl;
//        this.remoteServiceName=remoteServiceName;
    }

    @Override
    public String toString() {
        return urlLocation+" "+fileName;
    }
}
