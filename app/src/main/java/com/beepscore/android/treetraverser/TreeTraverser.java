package com.beepscore.android.treetraverser;

import android.util.Log;

/**
 * Created by stevebaker on 6/4/15.
 */
public class TreeTraverser {

    /** Search a binary tree for a node with name.
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

}
