
package lca;

import java.util.Set;
import java.util.TreeSet;

public class main {

    public static void main(String[] args) {
        
        Tree tree1 = new Tree();
        tree1.addNode(0, -1);
        tree1.addNode(1, 0);
        tree1.addNode(2, 1);
        tree1.addNode(3, 1);
        tree1.addNode(6, 1);
        tree1.addNode(7, 0);
        tree1.addNode(8, 7);
        tree1.addNode(9, 7);
        
        tree1.printNodes();
        
        LCA lca = new LCA();
        Set<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        System.out.println(lca.getLCA(tree1, set).getValue());
        
        
        
//        LCA lca = new LCA();
//        Set<Integer> set = new TreeSet<>();
//        set.add(0);
//        set.add(1);
//        set.add(2);
//        System.out.println(lca.getLCA(tree2, set).getValue());
    }
}
