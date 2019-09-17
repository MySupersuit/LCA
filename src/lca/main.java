
package lca;

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
        
        tree.printNodes();
        
        LCA lca = new LCA();
        lca.getLCA(tree, nodes);
    }
}
