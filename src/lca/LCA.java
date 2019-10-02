package lca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

/**
 *
 * @author Tom Moran
 */
public class LCA {

    private ArrayList<ArrayList<Integer>> paths;

    public LCA() {
        paths = new ArrayList<>();
    }

    public Node getLCA(Tree tree, Set<Integer> nodes) {

        if (tree.getSize() == nodes.size()) { // all nodes in set
            return tree.getHead();            // return head of tree
        }

        for (int i = 0; i < nodes.size(); i++) {
            paths.add(new ArrayList<>());
        }
        Object[] nodeVals = nodes.toArray();

        for (int i = 0; i < nodes.size(); i++) {
            int nodeVal = (int) nodeVals[i];
            if (nodes.size() == 1) {
                return tree.getNode(nodeVal);
            }
            
            Node node = tree.getNode(nodeVal);
            paths.get(i).add(nodeVal);
            while (!node.isHead()) {
                for (Node n : node.getParents()) {
                    node = n;
                    if (!paths.get(i).contains(n.getValue())) {
                        paths.get(i).add(node.getValue());
                    }
                }
                
            }
        }
//        for (int i = 0; i < paths.size(); i++) {
//            for (int j = 0; j < paths.get(i).size(); j++) {
//                System.out.println(paths.get(i).get(j));
//            }
//            System.out.println();
//        }
        ArrayList<Integer> dups = new ArrayList<>();
        for (int i = 0; i < paths.size(); i++) {
            //System.out.println(i + " of "+ paths.size());
            for (int j = 0; j < paths.get(i).size(); j++) {
                //System.out.println(j + " of " + paths.get(i).size());
                if (paths.get(i).contains(paths.get(i).get(j))) {
                    dups.add(paths.get(i).get(j));
                    for (int pathVal : dups) {
                        
                        if (Collections.frequency(dups, pathVal) == paths.size()) {
                            return tree.getNode(pathVal);
                        }
                    }
                }
            }
        }
        
        // First node val to be added paths.size() times is LCA
        
        return null;
    }

}
