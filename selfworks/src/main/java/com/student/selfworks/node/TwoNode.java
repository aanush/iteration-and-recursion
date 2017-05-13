package com.student.selfworks.node;

public class TwoNode {

    private double value;
    private TwoNode leftNode;
    private TwoNode rightNode;

    public TwoNode() {
    }

    public TwoNode(double value) {
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }

    public TwoNode(double value, TwoNode leftNode, TwoNode rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public TwoNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TwoNode leftNode) {
        this.leftNode = leftNode;
    }

    public TwoNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TwoNode rightNode) {
        this.rightNode = rightNode;
    }

}
