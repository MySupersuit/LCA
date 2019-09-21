
package lca;

import java.util.Set;
import java.util.TreeSet;

public class main {

    public static void main(String[] args) {
        
        Tree tree = new Tree();
        tree.addNode(0, -1);
        tree.addNode(1, 0);
        tree.addNode(2, 1);
        tree.addNode(3, 1);
        tree.addNode(6, 1);
        tree.addNode(7, 0);
        tree.addNode(8, 7);
        tree.addNode(9, 7);
        
        
        LCA lca = new LCA();
        Set<Integer> set = new TreeSet<>();
        set.add(6);
        set.add(7);
        System.out.println(lca.getLCA(tree, set).getValue());
    }
}
