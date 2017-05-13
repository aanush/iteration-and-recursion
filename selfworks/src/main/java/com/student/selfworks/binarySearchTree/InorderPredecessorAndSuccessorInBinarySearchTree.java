package com.student.selfworks.binarySearchTree;

public class InorderPredecessorAndSuccessorInBinarySearchTree {

    private InorderPredecessorAndSuccessorInBinarySearchTree() {

    }

    public static void main(String[] args) {
        InorderPredecessorAndSuccessorInBinarySearchTree application = new InorderPredecessorAndSuccessorInBinarySearchTree();
        TwoNode root = application.getRoot();
        PredecessorAndSuccessor result = application.inorderPredecessorAndSuccessor(root, 9);
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

    public PredecessorAndSuccessor inorderPredecessorAndSuccessor(TwoNode root, double valueToRefer) {
        return inorderPredecessorAndSuccessorRecursive(root, valueToRefer, new PredecessorAndSuccessor(null, null));
    }

    public PredecessorAndSuccessor inorderPredecessorAndSuccessorRecursive(TwoNode root, double valueToRefer, PredecessorAndSuccessor result) {
        if (root == null) {
            return result;
        }
        if (root.getValue() == valueToRefer) {
            if (root.getLeftNode() != null) {
                TwoNode inorderPredecessor = root.getLeftNode();
                while (inorderPredecessor.getRightNode() != null) {
                    inorderPredecessor = inorderPredecessor.getRightNode();
                }
                result.setInorderPredecessor(inorderPredecessor.getValue());
            }
            if (root.getRightNode() != null) {
                TwoNode inorderSuccessor = root.getRightNode();
                while (inorderSuccessor.getLeftNode() != null) {
                    inorderSuccessor = inorderSuccessor.getLeftNode();
                }
                result.setInorderSuccessor(inorderSuccessor.getValue());
            }
            return result;
        }
        if (root.getValue() > valueToRefer) {
            result.setInorderSuccessor(root.getValue());
            result = inorderPredecessorAndSuccessorRecursive(root.getLeftNode(), valueToRefer, result);
            return result;
        }
        if (root.getValue() < valueToRefer) {
            result.setInorderPredecessor(root.getValue());
            result = inorderPredecessorAndSuccessorRecursive(root.getRightNode(), valueToRefer, result);
            return result;
        }
        throw new RuntimeException("current line will never be executed");
    }

    private class PredecessorAndSuccessor {
        private Double inorderPredecessor;
        private Double inorderSuccessor;

        public PredecessorAndSuccessor(Double inorderPredecessor, Double inorderSuccessor) {
            this.inorderPredecessor = inorderPredecessor;
            this.inorderSuccessor = inorderSuccessor;
        }

        public Double getInorderPredecessor() {
            return inorderPredecessor;
        }

        public void setInorderPredecessor(Double inorderPredecessor) {
            this.inorderPredecessor = inorderPredecessor;
        }

        public Double getInorderSuccessor() {
            return inorderSuccessor;
        }

        public void setInorderSuccessor(Double inorderSuccessor) {
            this.inorderSuccessor = inorderSuccessor;
        }
    }

    public class TwoNode {

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
