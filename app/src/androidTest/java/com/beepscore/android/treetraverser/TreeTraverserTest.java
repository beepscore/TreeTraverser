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

        start = nodeF;
    }

    public void testIsNameInTree() {
        TreeTraverser traverser = new TreeTraverser();
        assertFalse(traverser.isNameInTree("foo", start));
    }

}
