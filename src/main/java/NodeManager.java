import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by xiaom on 2017/8/6.
 */
public class NodeManager {
    private Vector<NodeInfo> nodes;
    public NodeManager(HashMap<String,String> nodesinfo){
        nodes=new Vector<NodeInfo>();
        for(String key:nodesinfo.keySet()){
            nodes.addElement(new NodeInfo(key,nodesinfo.get(key)));
        }
    }

    public Vector<NodeInfo> getNodes() {
        return nodes;
    }
}
