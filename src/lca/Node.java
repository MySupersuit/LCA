
package lca;

public class Node {
    
    private int val;
    private Node parent;
    
    public Node(int val, Node parent) {
        this.val = val;
        this.parent = parent;
    }
    
    public Node(int val) {
        this.val = val;
        this.parent = null;
    }
 
    public boolean isHead(Node node) {
        return node.parent == null;
    }
    
    public int getValue() {
        return this.val;
    }
    
    public Node getParent() {
        return this.parent;
    }
    
    

}
