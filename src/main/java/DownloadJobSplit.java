import java.util.Vector;

/**
 * Created by xiaom on 2017/8/5.
 */
public class DownloadJobSplit {
    public static Vector<long[]> lengthSplit(long contentLength, int n){//将给定的长度分成指定的段数
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
