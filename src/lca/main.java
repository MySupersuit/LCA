
package lca;

import java.util.Set;
import java.util.TreeSet;

public class main {

    public static void main(String[] args) {
        
        Tree tree2 = new Tree();
        tree2.addNode(0, -1);
        tree2.addNode(1, 0);
        tree2.addNode(2, 0);
        
        
        LCA lca = new LCA();
        Set<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(1);
        set.add(2);
        System.out.println(lca.getLCA(tree2, set).getValue());
    }
}
