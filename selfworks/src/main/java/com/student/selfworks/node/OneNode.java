package com.student.selfworks.node;

public class OneNode {

    private double value;
    private OneNode nextNode;

    public OneNode() {
    }

    public OneNode(double value, OneNode nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public OneNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(OneNode nextNode) {
        this.nextNode = nextNode;
    }

}
