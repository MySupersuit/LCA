
package lca;

import java.util.Set;
import java.util.TreeSet;

public class main {

    public static void main(String[] args) {
        
        Tree tree1 = new Tree();
        tree1.addNode(7, -1);
        tree1.addNode(4, 7);
        tree1.addNode(6, 7);
        tree1.addNode(3, 4);
        tree1.addNode(2, 3);
        tree1.addNode(1, 2);
        tree1.addNode(5, 6);
        tree1.addNode(2, 5);
        
        Tree tree3 = new Tree();
        tree3.addNode(0,-1);
        tree3.addNode(1, 0);
        tree3.addNode(2, 0);
        tree3.addNode(5, 2);
        tree3.addNode(5, 1);
        tree3.addNode(3, 2);
        tree3.addNode(4, 3);
        tree3.addNode(4, 1);
        
        tree3.printNodes();

        //tree1.printNodes();
        
        LCA lca = new LCA();
        Set<Integer> set = new TreeSet<>();
        set.add(4);
        set.add(5);
        System.out.println(lca.getLCA(tree3, set).getValue());
        //System.out.println(lca.getLCA(tree1, set).getValue());
        
        
    }
}
