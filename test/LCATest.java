
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
    private static Tree tree1, tree2, tree3;

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
    }

//    private void setup() {
//        tree1 = new Tree();
//
//    }
    @Test
    public void testOneNode() {
        //setup();

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

        assertEquals("lca with all nodes in set", expectedResult, lca.getLCA(tree2, set));
    }

    @Test
    public void testMultipleParents() {

    }
}
