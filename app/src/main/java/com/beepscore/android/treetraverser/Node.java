package com.beepscore.android.treetraverser;

/**
 * Created by stevebaker on 6/4/15.
 */
public class Node {

    String name = null;
    Integer value = null;
    Node left = null;
    Node right = null;

    @Override
    public String toString() {
        String description =  nameDescription(name) + ", "
                + valueDescription(value) + ", "
                + leftDescription(left) + ", "
                + rightDescription(right);
        return description;
    }

    protected String nameDescription(String aName) {
        String description = "name: ";
        if (aName == null) {
            description = description.concat("null");
        } else {
            description = description.concat(aName);
        }
        return description;
    }

    protected String valueDescription(Integer aValue) {
        String description = "value: ";
        if (aValue == null) {
            description = description.concat("null");
        } else {
            description = description.concat(aValue.toString());
        }
        return description;
    }

    protected String rightDescription(Node child) {
        return childDescription("right", child);
    }

    protected String leftDescription(Node child) {
        return childDescription("left", child);
    }

    /**
     *
     * @param childPosition e.g. "left", "right", "child0"
     * @param child
     * @return
     */
    // TODO: Consider convert childPosition into an enum or similar
    protected String childDescription(String childPosition, Node child) {
        String description = childPosition;
        if (child == null) {
            description = description.concat(": null");
        } else {
            description = description.concat(".name: ");
            if (child.name == null) {
                description = description.concat("null");
            } else {
                description = description.concat(child.name);
            }
        }
        return description;
    }
}
