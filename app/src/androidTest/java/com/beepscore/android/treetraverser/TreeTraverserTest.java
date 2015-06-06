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

    // ************************************************************************

    public void testNodeInTreeWithNameTreeNull() {
        TreeTraverser traverser = new TreeTraverser();
        assertNull(traverser.nodeInTreeWithName(null, "A"));
    }

    public void testNodeInTreeWithNameNameNull() {
        TreeTraverser traverser = new TreeTraverser();
        assertNull(traverser.nodeInTreeWithName(start, null));
    }

    public void testNodeInTreeWithName() {
        TreeTraverser traverser = new TreeTraverser();

        assertEquals("A", traverser.nodeInTreeWithName(start, "A").name);
        assertEquals("B", traverser.nodeInTreeWithName(start, "B").name);
        assertEquals("C", traverser.nodeInTreeWithName(start, "C").name);
        assertEquals("D", traverser.nodeInTreeWithName(start, "D").name);
        assertEquals("E", traverser.nodeInTreeWithName(start, "E").name);
        assertEquals("F", traverser.nodeInTreeWithName(start, "F").name);
        assertEquals("G", traverser.nodeInTreeWithName(start, "G").name);
        assertEquals("H", traverser.nodeInTreeWithName(start, "H").name);
        assertEquals("I", traverser.nodeInTreeWithName(start, "I").name);
    }

    public void testIsNameInTreeFalse() {
        TreeTraverser traverser = new TreeTraverser();
        assertNull(traverser.nodeInTreeWithName(start, "foo"));
    }

    // ************************************************************************

    public void testNodeInTreeWithValueTreeNull() {
        TreeTraverser traverser = new TreeTraverser();
        Integer value = 8;
        assertNull(traverser.nodeInTreeWithValue(null, value));
    }

    public void testNodeInTreeWithValueValueNull() {
        TreeTraverser traverser = new TreeTraverser();

        Node actual = traverser.nodeInTreeWithValue(start, null);
        assertEquals(null, actual.value);
        assertEquals("A", actual.name);
    }

    public void testNodeInTreeWithValue() {
        TreeTraverser traverser = new TreeTraverser();

        Integer value = 8;
        Node actual = traverser.nodeInTreeWithValue(start, value);
        assertEquals(value, actual.value);
        assertEquals("I", actual.name);
    }

    // ************************************************************************

    public void testNodeInTreeWithValueInOrderValueTreeNull() {
        TreeTraverser traverser = new TreeTraverser();

        Integer value = 8;
        assertNull(traverser.nodeInTreeWithValueInOrder(null, value));
    }

    public void testNodeInTreeWithValueInOrderValueNull() {
        TreeTraverser traverser = new TreeTraverser();

        Node actual = traverser.nodeInTreeWithValueInOrder(start, null);
        assertEquals(null, actual.value);
        assertEquals("A", actual.name);
    }

    public void testNodeInTreeWithValueInOrder() {
        TreeTraverser traverser = new TreeTraverser();

        Integer value = 8;
        Node actual = traverser.nodeInTreeWithValueInOrder(start, value);
        assertEquals(value, actual.value);
        assertEquals("I", actual.name);
    }

    // ************************************************************************

    public void testNodeInTreeWithValueBreadthFirstValueTreeNull() {
        TreeTraverser traverser = new TreeTraverser();
        Integer value = 8;
        assertNull(traverser.nodeInTreeWithValueBreadthFirst(null, value));
    }

    public void testNodeInTreeWithValueBreadthFirstValueNull() {
        TreeTraverser traverser = new TreeTraverser();

        Node actual = traverser.nodeInTreeWithValueBreadthFirst(start, null);
        assertEquals(null, actual.value);
        assertEquals("A", actual.name);
    }

    public void testNodeInTreeWithValueBreadthFirst() {
        TreeTraverser traverser = new TreeTraverser();

        Integer value = 8;
        Node actual = traverser.nodeInTreeWithValueBreadthFirst(start, value);
        assertEquals(value, actual.value);
        assertEquals("I", actual.name);
    }

}
