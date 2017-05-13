package com.student.selfworks.binaryTree;

public class LargestBinarySearchTreeInBinaryTree {

    private LargestBinarySearchTreeInBinaryTree() {
    }

    public static void main(String[] args) {
        LargestBinarySearchTreeInBinaryTree application = new LargestBinarySearchTreeInBinaryTree();
        TwoNode node08 = application.getRoot();
        TwoNode bstNode = application.largestBinarySearchTree(node08);
    }

    private TwoNode getRoot() {
        double value = 0.0;
        TwoNode node01 = new TwoNode(++value);
        TwoNode node02 = new TwoNode(++value);
        TwoNode node03 = new TwoNode(++value);
        TwoNode node04 = new TwoNode(++value);
        TwoNode node05 = new TwoNode(++value);
        TwoNode node06 = new TwoNode(++value);
        TwoNode node07 = new TwoNode(++value);
        TwoNode node08 = new TwoNode(++value);
        TwoNode node09 = new TwoNode(++value);
        TwoNode node10 = new TwoNode(++value);
        TwoNode node11 = new TwoNode(++value);
        TwoNode node12 = new TwoNode(++value);
        TwoNode node13 = new TwoNode(++value);
        TwoNode node14 = new TwoNode(++value);
        TwoNode node15 = new TwoNode(++value);
        node02.setLeftNode(node01);
        node02.setRightNode(node03);
        node06.setLeftNode(node05);
        node06.setRightNode(node07);
        node04.setLeftNode(node02);
        node04.setRightNode(node06);
        node10.setLeftNode(node09);
        node10.setRightNode(node11);
        node14.setLeftNode(node13);
        node14.setRightNode(node15);
        node12.setLeftNode(node10);
        node12.setRightNode(node14);
        node08.setLeftNode(node04);
        node08.setRightNode(node12);

        //will modify the bst as root node08
        node06.setRightNode(new TwoNode(16));
        return node08;
    }

    public TwoNode largestBinarySearchTree(TwoNode root) {
        if (root == null) {
            return null;
        }
        BSTDetails bstDetails = largestBST(root);
        return bstDetails.bstNode;
    }

    public BSTDetails largestBST(TwoNode root) {
        if (root == null) {
            throw new RuntimeException("current method will never be invoked for a null argument");
            // will invoke method after a null check
        }
        if (root.getLeftNode() == null && root.getRightNode() == null) {
            return new BSTDetails(root, 1, root.getValue(), root.getValue());
            // leaf is the largest bst
        }
        if (root.getLeftNode() != null && root.getRightNode() == null) {
            BSTDetails leftDetails = largestBST(root.getLeftNode());
            if (root.getLeftNode() == leftDetails.bstNode && root.getValue() > leftDetails.maxValue) {
                return new BSTDetails(root, leftDetails.bstSize + 1, leftDetails.minValue, root.getValue());
                // root is the largest bst
            }
            return leftDetails;
            // root is not a bst // return the largest bst
        }
        if (root.getLeftNode() == null && root.getRightNode() != null) {
            BSTDetails rightDetails = largestBST(root.getRightNode());
            if (root.getRightNode() == rightDetails.bstNode && root.getValue() < rightDetails.minValue) {
                return new BSTDetails(root, rightDetails.bstSize + 1, root.getValue(), rightDetails.maxValue);
                // root is the largest bst
            }
            return rightDetails;
            // root is not a bst // return the largest bst
        }
        if (root.getLeftNode() != null && root.getRightNode() != null) {
            BSTDetails leftDetails = largestBST(root.getLeftNode());
            BSTDetails rightDetails = largestBST(root.getRightNode());
            if (root.getLeftNode() == leftDetails.bstNode && root.getValue() > leftDetails.maxValue && root.getRightNode() == rightDetails.bstNode && root.getValue() < rightDetails.minValue) {
                return new BSTDetails(root, leftDetails.bstSize + rightDetails.bstSize + 1, leftDetails.minValue, rightDetails.maxValue);
                // root is the largest bst
            }
            if (leftDetails.bstSize > rightDetails.bstSize) {
                return leftDetails;
                // root is not a bst // return the largest bst
            }
            if (leftDetails.bstSize < rightDetails.bstSize) {
                return rightDetails;
                // root is not a bst // return the largest bst
            }
            if (leftDetails.bstSize == rightDetails.bstSize) {
                return leftDetails; //return rightDetails;
                // root is not a bst // return the largest bst
            }
            throw new RuntimeException("current statement will never be executed");
        }
        throw new RuntimeException("current statement will never be executed");
    }

    private class BSTDetails {

        private TwoNode bstNode;
        private int bstSize;
        private double minValue;
        private double maxValue;

        public BSTDetails(TwoNode bstNode, int bstSize, double minValue, double maxValue) {
            this.bstNode = bstNode;
            this.bstSize = bstSize;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

    }

    private class TwoNode {

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

}
