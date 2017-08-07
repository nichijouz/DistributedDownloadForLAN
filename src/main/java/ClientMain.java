import javax.xml.soap.Node;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by xiaom on 2017/8/5.
 */
public class ClientMain {//客户端

    public static void main(String[] args) {
        String urlLocation = "http://dldir1.qq.com/qqfile/qq/QQ8.9.4/21584/QQ8.9.4.exe";
        HashMap<String,String> nodes=new HashMap<String, String>();
        nodes.put("192.168.10.1","9090");
        nodes.put("192.168.10.2","9090");
        nodes.put("192.168.10.3","9090");
        nodes.put("192.168.10.4","9090");
        nodes.put("192.168.10.5","9090");
//        nodes.put("192.168.3.2","8089");
//        nodes.put("127.0.0.1","8989");

        NodeManager nodeManager=new NodeManager(nodes);

        Vector<String[]> properties=new Vector<String[]>();
//        properties.addElement(new String[]{"Host","xt.win10plus.com:5101"});
//        properties.addElement(new String[]{"Connection","keep-alive"});
//        properties.addElement(new String[]{"Upgrade-Insecure-Requests","1"});
//        properties.addElement(new String[]{"User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36"});
//        properties.addElement(new String[]{"Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8"});
//        properties.addElement(new String[]{"Referer","http://www.ghost580.com/windows10/win10/21086.html"});
//        properties.addElement(new String[]{"Accept-Language","zh-CN,zh;q=0.8"});
//        properties.addElement(new String[]{"Accept-Encoding","gzip, deflate, sdch"});


        try{
            long destlen=DownloadHelper.getContentLength(urlLocation,properties);
            System.out.println(destlen);
            if(destlen<=500){
                System.exit(-1);
            }
//            System.exit(-1);
        }catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }
        JobSubmitter.submitJob(urlLocation,nodeManager,"qqfuck3.exe" ,"qqfuck3",8,properties);



    }
}
