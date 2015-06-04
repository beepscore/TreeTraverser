package com.beepscore.android.treetraverser;

/**
 * Created by stevebaker on 6/4/15.
 */
public class TreeTraverser {

    public boolean isNameInTree(String name, Node node) {
        if (node == null) {
            return false;
        }
        // "pre-order" check node before subtrees
        if (node.name == name) {
            return true;
        }
        // recurse
        return isNameInTree(name, node.left)
                || isNameInTree(name, node.right);
    }

}
