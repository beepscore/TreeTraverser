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

        nodeA.value = null;
        nodeB.value = -3;
        nodeC.value = 0;
        nodeD.value = 17;
        nodeE.value = 20;
        nodeF.value = -13;
        nodeG.value = 99;
        nodeH.value = -1;
        nodeI.value = 8;

        start = nodeF;
    }

    public void testIsNameInTreeTrue() {
        TreeTraverser traverser = new TreeTraverser();
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

    public void testIsNameInTreeFalse() {
        TreeTraverser traverser = new TreeTraverser();
        assertFalse(traverser.isNameInTree("foo", start));
    }

    public void testIsNameInTreeNameNull() {
        TreeTraverser traverser = new TreeTraverser();
        assertFalse(traverser.isNameInTree(null, start));
    }

    public void testIsNameInTreeTreeNull() {
        TreeTraverser traverser = new TreeTraverser();
        assertFalse(traverser.isNameInTree("A", null));
    }

    // ************************************************************************

    public void testNodeWithValueInTreeValueNull() {
        TreeTraverser traverser = new TreeTraverser();

        Node actual = traverser.nodeWithValueInTree(null, start);
        assertEquals(null, actual.value);
        assertEquals("A", actual.name);
    }

    public void testNodeWithValueInTreeValue() {
        TreeTraverser traverser = new TreeTraverser();

        Integer value = 8;
        Node actual = traverser.nodeWithValueInTree(value, start);
        assertEquals(value, actual.value);
        assertEquals("I", actual.name);
    }

    public void testNodeWithValueInTreeTreeNull() {
        TreeTraverser traverser = new TreeTraverser();
        Integer value = 8;
        assertNull(traverser.nodeWithValueInTree(value, null));
    }

    // ************************************************************************

    public void testNodeWithValueInTreeInOrderValueNull() {
        TreeTraverser traverser = new TreeTraverser();

        Node actual = traverser.nodeWithValueInTreeInOrder(null, start);
        assertEquals(null, actual.value);
        assertEquals("A", actual.name);
    }

    public void testNodeWithValueInTreeInOrderValue() {
        TreeTraverser traverser = new TreeTraverser();

        Integer value = 8;
        Node actual = traverser.nodeWithValueInTreeInOrder(value, start);
        assertEquals(value, actual.value);
        assertEquals("I", actual.name);
    }

    public void testNodeWithValueInTreeInOrderTreeNull() {
        TreeTraverser traverser = new TreeTraverser();
        Integer value = 8;
        assertNull(traverser.nodeWithValueInTreeInOrder(value, null));
    }

}
