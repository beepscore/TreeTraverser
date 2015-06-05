package com.beepscore.android.treetraverser;

import junit.framework.TestCase;

/**
 * Created by stevebaker on 6/4/15.
 */
public class TreeTraverserTest extends TestCase {

    Node start = null;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        // reference tree graph
        // https://en.wikipedia.org/wiki/Tree_traversal
        Node nodeC = new Node("C", null, null, null);
        Node nodeE = new Node("E", null, null, null);
        Node nodeD = new Node("D", null, nodeC, nodeE);

        Node nodeA = new Node("A", null, null, null);
        Node nodeB = new Node("B", null, nodeA, nodeD);

        Node nodeH = new Node("H", null, null, null);
        Node nodeI = new Node("I", null, nodeH, null);
        Node nodeG = new Node("G", null, null, nodeI);

        Node nodeF = new Node("F", null, nodeB, nodeG);

        nodeA.value = new Integer(3);
        nodeB.value = new Integer(-3);
        nodeC.value = new Integer(0);
        nodeD.value = new Integer(17);
        nodeE.value = new Integer(20);
        nodeF.value = new Integer(-13);
        nodeG.value = new Integer(99);
        nodeH.value = new Integer(-1);
        nodeI.value = new Integer(8);

        start = nodeF;
    }

    public void testIsNameInTree() {
        TreeTraverser traverser = new TreeTraverser();
        assertFalse(traverser.isNameInTree(null, start));
        assertFalse(traverser.isNameInTree("foo", start));

        assertTrue(traverser.isNameInTree("A", start));
        assertTrue(traverser.isNameInTree("B", start));
        assertTrue(traverser.isNameInTree("C", start));
        assertTrue(traverser.isNameInTree("D", start));
        assertTrue(traverser.isNameInTree("E", start));
        assertTrue(traverser.isNameInTree("F", start));
        assertTrue(traverser.isNameInTree("G", start));
        assertTrue(traverser.isNameInTree("H", start));
        assertTrue(traverser.isNameInTree("I", start));
    }

    public void testIsNameInTreeNull() {
        TreeTraverser traverser = new TreeTraverser();
        assertFalse(traverser.isNameInTree("A", null));
    }

    public void testNodeWithValueInTree() {
        TreeTraverser traverser = new TreeTraverser();
        assertNull(traverser.nodeWithValueInTree(null, start));

        Node actual = traverser.nodeWithValueInTree(new Integer(8), start);
        assertEquals(new Integer(8), actual.value);
    }

    public void testNodeWithValueInTreeNull() {
        TreeTraverser traverser = new TreeTraverser();
        assertNull(traverser.nodeWithValueInTree(new Integer(8), null));
    }
}
