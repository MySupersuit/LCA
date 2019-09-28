
package lca;

import java.util.Set;

public class Node implements Comparable<Node>{
    
    private int val;
    private Set<Node> parents;
    
    public Node(int val, Set<Node> parent) {
        this.val = val;
        this.parents = parent;
    }
    
    public Node(int val) {
        this.val = val;
        this.parents = null;
    }
 
    public boolean isHead() {
        return parents == null;
    }
    
    public int getValue() {
        return this.val;
    }
    
    public Set<Node> getParents() {
        return this.parents;
    }

    @Override
    public int compareTo(Node t) {
        return this.val - t.val;
    }
    
    

}
