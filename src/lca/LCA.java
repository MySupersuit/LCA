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
                node = node.getParent();
                paths.get(i).add(node.getValue());
            }
        }
        ArrayList<Integer> dups = new ArrayList<>();
        for (int i = 1; i < paths.size(); i++) {
            for (int j = 0; j < paths.get(i - 1).size(); j++) {
                if (paths.get(i - 1).contains(paths.get(i).get(j))) {
                    dups.add(paths.get(i).get(j));
                    for (int pathVal : dups) {
                        if (Collections.frequency(dups, pathVal) == paths.size()-1) {
                            return tree.getNode(pathVal);
                        }
                    }
                }
            }
        }
        // First node val to be added paths-1 times is LCA


        return null;
    }

}
