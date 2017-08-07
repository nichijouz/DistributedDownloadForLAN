import java.util.Vector;

/**
 * Created by xiaom on 2017/8/4.
 */
public class Main {
    public static void main(String[] args) throws Exception{
//        boolean DOWNLOADSUCCESS=true;
//        boolean DOWNLOADFAILED=false;
//        boolean DOWNLOADFLAG;
//        String urlLocation=" ";
//        Downloader downloader=new Downloader(urlLocation,0,1000,"test");
//        DOWNLOADFLAG=downloader.Download();
//        if(DOWNLOADFLAG==DOWNLOADSUCCESS){
//            System.out.println("ok!");
//        }else{
//            System.out.println("oops!");
//        }
//        System.out.println(DownloadHelper.getContentLength(urlLocation));
//        int nodeNum=4;
//
//        Vector<long[]> vector=lengthSplit(64735136L,4);
//        for(long[] arr:vector){
//            System.out.println(arr[0]+"-"+arr[1]);
//        }


//        for (int i = 0; i <nodeNum ; i++) {//测试分段下载
//            long[] range=vector.elementAt(i);
//            Downloader downloader=new Downloader(urlLocation,range[0],range[1],"test"+i);
//            downloader.Download();
//        }
//        String[] fileNames=new String[]{"test0","test1","test2","test3"};
//        boolean flag=DownloadFileCombiner.combine(fileNames,"QQ.exe");
//        System.out.println(flag);





    }

    public static Vector<long[]> lengthSplit(long contentLength,int n){//将给定的长度分成指定的段数
        long eachLength=contentLength/n;
        Vector<long[]> vector=new Vector<long[]>();
        long initialLength=0;
        for (int i = 0; i <n-1; i++) {//处理前n-1个范围，对于最后一个范围特别处理，不知道需不需要
            long[] tmp=new long[]{initialLength,initialLength+eachLength};
            vector.addElement(tmp);//将范围加入到vector中
            initialLength+=eachLength+1;
        }
        vector.addElement(new long[]{initialLength,contentLength});//最后分组的长度
        return vector;
    }
}
