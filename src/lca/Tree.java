package lca;

import java.util.ArrayList;

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
        
        if (!isUniqueNode(val)) return false;
        
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
        Node newNode = new Node(val, parentNode);
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
            System.out.println("Node " + node.getValue() + ((node.getParent() == null) ? " is the head":" has parent " + 
                    node.getParent().getValue() ));
        }
    }
    
    public int getSize() {
        return this.size;
    }
    
    public Node getHead() {
        return this.head;
    }

}
