
import java.util.Set;
import java.util.TreeSet;
import lca.LCA;
import lca.Node;
import lca.Tree;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LCATest {

    private final LCA lca = new LCA();
    private static Tree tree1, tree2, tree3, treeLarge, treeEmpty;

    // Setup of tree for tests
    static {
        tree1 = new Tree();
        tree1.addNode(0, -1);
        tree1.addNode(1, 0);
        tree1.addNode(2, 1);
        tree1.addNode(3, 1);
        tree1.addNode(6, 1);
        tree1.addNode(7, 0);
        tree1.addNode(8, 7);
        tree1.addNode(9, 7);

        tree2 = new Tree();
        tree2.addNode(0, -1);
        tree2.addNode(1, 0);
        tree2.addNode(2, 0);

        tree3 = new Tree();
        tree3.addNode(0, -1);
        tree3.addNode(1, 0);
        tree3.addNode(2, 0);
        tree3.addNode(5, 2);
        tree3.addNode(5, 1);
        tree3.addNode(3, 2);
        tree3.addNode(4, 3);
        tree3.addNode(4, 1);
        
        treeLarge = new Tree();
        treeLarge.addNode(0, -1);
        treeLarge.addNode(1, 0);
        treeLarge.addNode(2, 0);
        treeLarge.addNode(9, 0);
        treeLarge.addNode(9, 1);
        treeLarge.addNode(3, 1);
        treeLarge.addNode(2, 1);
        treeLarge.addNode(3, 2);
        treeLarge.addNode(6, 2);
        treeLarge.addNode(10, 3);
        treeLarge.addNode(5, 3);
        treeLarge.addNode(4, 3);
        treeLarge.addNode(8, 3);
        treeLarge.addNode(8, 4);
        treeLarge.addNode(10, 5);
        treeLarge.addNode(12, 5);
        treeLarge.addNode(7, 6);
        treeLarge.addNode(14, 6);
        treeLarge.addNode(4, 6);
        treeLarge.addNode(13, 7);
        treeLarge.addNode(14, 7);
        
        treeEmpty = new Tree();
        
    }

    @Test
    public void testOneNode() {

        // One node set test
        Node expectedResult = tree1.getNode(3);
        Set<Integer> set = new TreeSet<>();
        set.add(3);

        assertEquals("lca of one node, should return itself", expectedResult, lca.getLCA(tree1, set));
    }

    @Test
    public void testTwoNodes() {

        Node expectedResult = tree1.getNode(7);
        Set<Integer> set = new TreeSet<>();
        set.add(8);
        set.add(9);

        assertEquals("lca of two nodes", expectedResult, lca.getLCA(tree1, set));

    }

    @Test
    public void testZeroNodes() {

        Set<Integer> set = new TreeSet<>();
        assertEquals("lca with no nodes", null, lca.getLCA(tree1, set));
    }

    @Test
    public void testAllNodes() {
        Node expectedResult = tree2.getNode(0);
        Set<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(1);
        set.add(2);

        assertEquals("lca with all nodes in set", expectedResult,
                lca.getLCA(tree2, set));
    }

    @Test
    public void testMultipleParents() {
        Node expectedResult = tree3.getNode(2);
        Set<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(3);
        assertEquals("lca on dag where multiple parents are involved",
                expectedResult, lca.getLCA(tree3, set));

    }

    @Test
    public void testMultipleAnswers() {
        Node expectedResult = tree3.getNode(1);
        Set<Integer> set2 = new TreeSet<>();
        set2.add(5);
        set2.add(4);
        assertEquals("when multiple answers expect lowest - ie first reached", expectedResult,
                lca.getLCA(tree3, set2));
    }
    
    @Test
    public void testLarge1() {
        Node expectedResult = treeLarge.getNode(2);
        Set<Integer> set = new TreeSet<>();
        set.add(12);
        set.add(13);
        set.add(3);
        assertEquals("large tree LCA", expectedResult, lca.getLCA(treeLarge, set));
    }
    @Test
    public void testLarge2() {
        Node expectedResult = treeLarge.getNode(0);
        Set<Integer> set = new TreeSet<>();
        set.add(9);
        set.add(10);
        set.add(14);
        assertEquals("large tree spread values", expectedResult, lca.getLCA(treeLarge, set));
    }
    
    @Test
    public void testInvalidNode() {
        Node expectedResult = null;
        Set<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(8);
        set.add(100);
        assertEquals("node not in tree in set", expectedResult, lca.getLCA(treeLarge, set));
    }
    
    @Test
    public void testEmptySet() {
        Node expectedResult = null;
        Set<Integer> set = new TreeSet<>();
        assertEquals("empty set", expectedResult, lca.getLCA(tree1, set));
    }
    
    @Test
    public void testEmptyTree() {
        Node expectedResult = null;
        Set<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(5);
        assertEquals("empty tree", expectedResult, lca.getLCA(treeEmpty, set));
    }
    
    @Test public void testEmptyEverything() {
        Node expectedResult = null;
        Set<Integer> set = new TreeSet<>();
        assertEquals("empty everything", expectedResult, lca.getLCA(treeEmpty, set));
        
    }

}
