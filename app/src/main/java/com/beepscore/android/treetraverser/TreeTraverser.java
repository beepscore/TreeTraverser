package com.beepscore.android.treetraverser;

import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by stevebaker on 6/4/15.
 */
public class TreeTraverser {

    /** Use more general interface List instead of restricting to type ArrayList
     * http://stackoverflow.com/questions/2279030/type-list-vs-type-arraylist-in-java#2279059
     */
    public List<String> nodesSearched = new ArrayList<String>();

    /** Search a binary tree for a node with name.
     * Search is depth first, recursive.
     * Search is "pre-order"- checks node before subtrees.
     * Search checks node, then left subtree, then right subtree.
     * Usually in a tree each node has a property that is unique, e.g. node.value
     * However a tree could allow nodes with duplicate properties such as node.name.
     * @param node starting node of binary tree
     * @param name
     * @return first node found with name. return null if not found or node is null.
     */
    public Node nodeInTreeWithName(Node node, String name) {

        if (node == null) {
            return null;
        }

        Log.d("nodeInTreeWithName", node.toString());

        // "pre-order" check node before subtrees
        // both null and String may be compared using ==
        if (node.name == name) {
            return node;
        }

        // check subtrees recursively

        Node leftBranchResult = nodeInTreeWithName(node.left, name);
        if (leftBranchResult != null) {
            return leftBranchResult;
        }

        Node rightBranchResult = nodeInTreeWithName(node.right, name);
        if (rightBranchResult != null) {
            return rightBranchResult;
        }

        return null;
    }

    /** Search a binary tree for a node with value.
     * Search is depth first, recursive.
     * Search is "pre-order"- checks node before subtrees.
     * Search checks node, then left subtree, then right subtree.
     * @param node starting node of binary tree
     * @param value may be null.
     * @return first node found with value. return null if not found or node is null.
     */
    public Node nodeInTreeWithValue(Node node, Integer value) {

        if (node == null) {
            return null;
        }

        // "pre-order" check node before subtrees
        // Log.d("pre-order", node.toString());
        this.nodesSearched.add(node.name);

        if (isNodeValueEqualToValue(node, value)) {
            return node;
        }

        // check subtrees recursively

        Node leftBranchResult = nodeInTreeWithValue(node.left, value);
        if (leftBranchResult != null) {
            return leftBranchResult;
        }

        Node rightBranchResult = nodeInTreeWithValue(node.right, value);
        if (rightBranchResult != null) {
            return rightBranchResult;
        }

        return null;
    }

    private boolean isNodeValueEqualToValue(Node node, Integer value) {
        if ((value == null) && (node.value == null)) {
            return true;
        }

        if ((value != null) && (node.value != null)
                && (node.value.equals(value))) {
            // First two conditionals check both values are non null.
            // They are objects and so are safe to compare via third conditional equals()
            return true;
        }
        return false;
    }

    /** Search a binary tree for a node with value.
     * Search is depth first, recursive.
     * Search is "in-order".
     * Search checks left subtree, then node, then right subtree.
     * @param node starting node of binary tree
     * @param value may be null.
     * @return first node found with value. Else return null.
     */
    public Node nodeInTreeWithValueInOrder(Node node, Integer value) {

        if (node == null) {
            return null;
        }

        // check left branch
        Node leftBranchResult = nodeInTreeWithValueInOrder(node.left, value);
        if (leftBranchResult != null) {
            return leftBranchResult;
        }

        // "in-order" check node
        // Log.d("in-order", node.toString());
        this.nodesSearched.add(node.name);

        if (isNodeValueEqualToValue(node, value)) {
            return node;
        }

        // check right branch
        Node rightBranchResult = nodeInTreeWithValueInOrder(node.right, value);
        if (rightBranchResult != null) {
            return rightBranchResult;
        }

        return null;
    }

    /** Search a binary tree for a node with value.
     * Tree nodes are non-null.
     * Search is breadth first.
     * @param root starting node of binary tree.
     * @param value may be null.
     * @return first node found with value. return null if not found or if root is null.
     */
    public Node nodeInTreeWithValueBreadthFirst(Node root, Integer value) {

        if (root == null) {
            return null;
        }

        // LinkedList implements Queue, Dequeue
        // http://stackoverflow.com/questions/12179887/android-queue-vs-stack
        Queue<Node> queue = new LinkedList<Node>();

        queue.add(root);

        while (!queue.isEmpty()) {

            Node node = queue.remove();
            //Log.d("breadth-first", node.toString());
            this.nodesSearched.add(node.name);

            if (isNodeValueEqualToValue(node, value)) {
                return node;
            }

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
        // didn't find a match
        return null;
    }
}
