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
        if (node.name == name) {
            return true;
        }
        // recurse
        return isNameInTree(name, node.left)
                || isNameInTree(name, node.right);
    }

    /** Search a binary tree for a node with value.
     * @param value may be null.
     * @param node starting node of binary tree
     * @return first node found with value. Else return null.
     */
    public Node nodeWithValueInTree(Integer value, Node node) {

        if (node == null) {
            return null;
        }

        Log.d("nodeWithValueInTree", node.toString());

        // "pre-order" check node before subtrees

        if ((value == null) && (node.value == null)) {
            return node;
        }

        if ((value != null) && (node.value != null)
                && (node.value.equals(value))) {
            return node;
        }

        // recurse
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

}
