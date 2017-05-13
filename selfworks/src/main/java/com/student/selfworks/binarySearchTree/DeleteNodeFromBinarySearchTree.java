package com.student.selfworks.binarySearchTree;

public class DeleteNodeFromBinarySearchTree {

    private DeleteNodeFromBinarySearchTree() {
    }

    public static void main(String[] args) {
        DeleteNodeFromBinarySearchTree application = new DeleteNodeFromBinarySearchTree();
        TwoNode root = application.getRoot();
        TwoNode modifiedRoot1 = application.deleteNode(root, 8);
        TwoNode modifiedRoot2 = application.deleteNode(modifiedRoot1, 7);
        System.out.println();
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
        return node08;
    }

    public TwoNode deleteNode(TwoNode root, double valueToDelete) {
        if (root == null) {
            return null;
        }
        if (root.getValue() == valueToDelete) {
            if (root.getLeftNode() == null && root.getRightNode() == null) {
                root = null;
                return root;
            }
            if (root.getLeftNode() == null && root.getRightNode() != null) {
                root = root.getRightNode();
                return root;
            }
            if (root.getRightNode() == null && root.getLeftNode() != null) {
                root = root.getLeftNode();
                return root;
            }
            if (root.getLeftNode() != null && root.getRightNode() != null) {
                TwoNode parentOfImmediateLessThanRootNode = root;
                TwoNode immediateLessThanRootNode = root.getLeftNode();
                while (immediateLessThanRootNode.getRightNode() != null) {
                    parentOfImmediateLessThanRootNode = immediateLessThanRootNode;
                    immediateLessThanRootNode = immediateLessThanRootNode.getRightNode();
                }
                root.setValue(immediateLessThanRootNode.getValue());
                immediateLessThanRootNode = deleteNode(immediateLessThanRootNode, immediateLessThanRootNode.getValue());
                parentOfImmediateLessThanRootNode.setRightNode(immediateLessThanRootNode);
                return root;
            }
        }
        if (root.getValue() > valueToDelete) {
            TwoNode modifiedLeftNode = deleteNode(root.getLeftNode(), valueToDelete);
            root.setLeftNode(modifiedLeftNode);
            return root;
        }
        if (root.getValue() < valueToDelete) {
            TwoNode modifiedRightNode = deleteNode(root.getRightNode(), valueToDelete);
            root.setRightNode(modifiedRightNode);
            return root;
        }
        throw new RuntimeException("current line will never be executed");
    }

    private class TwoNode {

        private double value;
        private TwoNode leftNode;
        private TwoNode rightNode;

        public TwoNode(double value) {
            this.value = value;
            this.leftNode = null;
            this.rightNode = null;
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
