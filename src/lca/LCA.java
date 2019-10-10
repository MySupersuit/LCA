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
        
        paths = new ArrayList<>();

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
            if (tree.getNode((int) nodeVals[i]) != null) {

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

            ArrayList<Integer> dups = new ArrayList<>();
            for (int j = 0; j < paths.size(); j++) {
                for (int k = 0; k < paths.get(j).size(); k++) {
                    if (paths.get(j).contains(paths.get(j).get(k))) {
                        dups.add(paths.get(j).get(k));
                        for (int pathVal : dups) {

                            if (Collections.frequency(dups, pathVal) == paths.size()) {
                                return tree.getNode(pathVal);
                            }
                        }
                    }
                }
            }

            // First node val to be added paths.size() times is LCA
        }
        return null;
    }

}
