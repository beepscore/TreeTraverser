package com.beepscore.android.treetraverser;

import junit.framework.TestCase;

import java.util.ArrayList;

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
        Node nodeC = new Node("C", 0, null, null);
        Node nodeE = new Node("E", 20, null, null);
        Node nodeD = new Node("D", 17, nodeC, nodeE);

        Node nodeA = new Node("A", null, null, null);
        Node nodeB = new Node("B", -3, nodeA, nodeD);

        Node nodeH = new Node("H", -1, null, null);
        Node nodeI = new Node("I", 8, nodeH, null);
        Node nodeG = new Node("G", 99, null, nodeI);

        Node nodeF = new Node("F", -13, nodeB, nodeG);

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

    public void testNodeInTreeWithNameNotInTree() {
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

        ArrayList<String> expected = new ArrayList<>();
        expected.add("F");
        expected.add("B");
        expected.add("A");
        expected.add("D");
        expected.add("C");
        expected.add("E");
        expected.add("G");
        expected.add("I");
        assertEquals(expected, traverser.nodesSearched);
    }

    public void testNodeInTreeWithValueNotInTree() {
        TreeTraverser traverser = new TreeTraverser();

        Integer value = 666;
        Node actual = traverser.nodeInTreeWithValue(start, value);
        assertNull(actual);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("F");
        expected.add("B");
        expected.add("A");
        expected.add("D");
        expected.add("C");
        expected.add("E");
        expected.add("G");
        expected.add("I");
        expected.add("H");
        assertEquals(expected, traverser.nodesSearched);
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

    public void testNodeInTreeWithValueInOrderValueNotInTree() {
        TreeTraverser traverser = new TreeTraverser();

        Integer value = 666;
        Node actual = traverser.nodeInTreeWithValueInOrder(start, value);
        assertNull(actual);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("A");
        expected.add("B");
        expected.add("C");
        expected.add("D");
        expected.add("E");
        expected.add("F");
        expected.add("G");
        expected.add("H");
        expected.add("I");
        assertEquals(expected, traverser.nodesSearched);
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
