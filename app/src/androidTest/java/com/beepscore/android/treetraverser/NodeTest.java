package com.beepscore.android.treetraverser;

import junit.framework.TestCase;

/**
 * Created by stevebaker on 6/4/15.
 */
public class NodeTest extends TestCase {

    public void testNodePropertiesNull() {
        Node node = new Node();
        assertNotNull(node);

        assertNull(node.name);
        assertNull(node.value);
        assertNull(node.left);
        assertNull(node.right);
    }

    public void testNodeToStringPropertiesNull() {
        Node node = new Node();
        String expected = "null, value: null, left: null, right: null";
        assertEquals(expected, node.toString());
    }

    public void testNodeProperties() {
        Node joe = new Node();

        String testName = "Joe";
        joe.name = testName;
        Integer testValue = new Integer(5);
        joe.value = testValue;
        assertEquals(testName, joe.name);
        assertEquals(testValue, joe.value);

        String expectedDescription = "Joe, value: 5, left: null, right: null";
        assertEquals(expectedDescription, joe.toString());

        Node larry = new Node();
        joe.left = larry;
        larry.name = "Larry";
        assertEquals(larry, joe.left);

        expectedDescription = "Joe, value: 5, left.name: Larry, right: null";
        assertEquals(expectedDescription, joe.toString());

        Node rick = new Node();
        joe.right = rick;
        assertEquals(rick, joe.right);

        expectedDescription = "Joe, value: 5, left.name: Larry, right.name: null";
        assertEquals(expectedDescription, joe.toString());

        rick.name = "Rick";
        expectedDescription = "Joe, value: 5, left.name: Larry, right.name: Rick";
        assertEquals(expectedDescription, joe.toString());
    }

    public void testConstructor() {
        String name = "Joe";
        Integer value = new Integer(5);
        Node larry = new Node();
        Node rick = new Node();
        Node joe = new Node(name, value, larry, rick);

        assertNotNull(joe);
        assertEquals(name, joe.name);
        assertEquals(value, joe.value);
        assertEquals(larry, joe.left);
        assertEquals(rick, joe.right);
    }
}
