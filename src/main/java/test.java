import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by xiaom on 2017/8/3.
 */
public class test {
    public static void main(String[] args) {
        String[] s=new String[]{"test1","test0"};
        Arrays.sort(s);
        for(String c:s){
            System.out.println(c);
        }
    }
}
