package lca;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Tree {

    private ArrayList<Node> nodes;
    private int size;
    private Node head;
    
    public Tree() {
        nodes = new ArrayList<>();
        size = 0;
    }

    // Creates a new node with value 'val' and 
    // makes it a child of node with value 'parent'
    public boolean addNode(int val, int parent) {
        
        if (!isUniqueNode(val)) {
            // then add parent to nodes set of parents
            getNode(val).getParents().add(getNode(parent));
        }
        
        if (parent == -1) {     // head
            Node newNode = new Node(val);
            nodes.add(newNode);
            head = newNode;
            size++;
            return true;
        }
        Node parentNode = getNode(parent);
        if (parentNode == null) {
            return false;
        }
        Set<Node> newParents = new TreeSet<>();
        newParents.add(getNode(parent));
        Node newNode = new Node(val, newParents);
        nodes.add(newNode);
        size++;
        return true;
    }
    
    private boolean isUniqueNode(int val) {
        for (Node node : nodes) {
            if (node.getValue() == val) return false;
        }
        return true;
    }

    public Node getNode(int val) {
        for (Node node : nodes) {
            if (node.getValue() == val) {
                return node;
            }
        }
        return null;
    }
    
    public void printNodes() {
        for (Node node : nodes) {
            System.out.print("Node " + node.getValue() + ((node.getParents() == null) ? " is the head\n":" has parent(s) "));
            if (node.getParents() != null) {
                for (Node n : node.getParents()) {
                    System.out.print(n.getValue() + " ");
                }
                System.out.println("");
            }
            
            
                    
        }
    }
    
    public int getSize() {
        return this.size;
    }
    
    public Node getHead() {
        return this.head;
    }

}
