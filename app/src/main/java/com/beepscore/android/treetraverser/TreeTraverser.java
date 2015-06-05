package com.beepscore.android.treetraverser;

import android.util.Log;

/**
 * Created by stevebaker on 6/4/15.
 */
public class TreeTraverser {

    /** Search a binary tree for a node with name.
     * Search is depth first, recursive.
     * Search is "pre-order"- checks node before subtrees.
     * Search checks node, then left subtree, then right subtree.
     * Usually in a tree each node has a property that is unique, e.g. node.value
     * However a tree could allow nodes with duplicate properties such as node.name.
     * @param name
     * @param node starting node of binary tree
     * @return true if any node has name
     */
    public boolean isNameInTree(String name, Node node) {

        if (node == null) {
            return false;
        }

        Log.d("isNameInTree", node.toString());

        // "pre-order" check node before subtrees
        // both null and String may be compared using ==
        if (node.name == name) {
            return true;
        }
        // recurse
        return isNameInTree(name, node.left)
                || isNameInTree(name, node.right);
    }

    /** Search a binary tree for a node with value.
     * Search is depth first, recursive.
     * Search is "pre-order"- checks node before subtrees.
     * Search checks node, then left subtree, then right subtree.
     * @param value may be null.
     * @param node starting node of binary tree
     * @return first node found with value. Else return null.
     */
    public Node nodeWithValueInTree(Integer value, Node node) {

        if (node == null) {
            return null;
        }

        // "pre-order" check node before subtrees
        Log.d("pre-order", node.toString());

        if ((value == null) && (node.value == null)) {
            return node;
        }

        if ((value != null) && (node.value != null)
                && (node.value.equals(value))) {
            // First two conditionals check both values are non null.
            // They are objects and so are safe to compare via third conditional equals()
            return node;
        }

        // check subtrees recursively

        Node leftBranchResult = nodeWithValueInTree(value, node.left);
        if (leftBranchResult != null) {
            return leftBranchResult;
        }

        Node rightBranchResult = nodeWithValueInTree(value, node.right);
        if (rightBranchResult != null) {
            return rightBranchResult;
        }

        return null;
    }

    /** Search a binary tree for a node with value.
     * Search is depth first, recursive.
     * Search is "in-order".
     * Search checks left subtree, then node, then right subtree.
     * @param value may be null.
     * @param node starting node of binary tree
     * @return first node found with value. Else return null.
     */
    public Node nodeWithValueInTreeInOrder(Integer value, Node node) {

        if (node == null) {
            return null;
        }

        // check left branch
        Node leftBranchResult = nodeWithValueInTreeInOrder(value, node.left);
        if (leftBranchResult != null) {
            return leftBranchResult;
        }

        // "in-order" check node
        Log.d("in-order", node.toString());

        if ((value == null) && (node.value == null)) {
            return node;
        }

        if ((value != null) && (node.value != null)
                && (node.value.equals(value))) {
            // First two conditionals check both values are non null.
            // They are objects and so are safe to compare via third conditional equals()
            return node;
        }

        // check right branch
        Node rightBranchResult = nodeWithValueInTreeInOrder(value, node.right);
        if (rightBranchResult != null) {
            return rightBranchResult;
        }

        return null;
    }

}
