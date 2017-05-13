package com.student.selfworks.binaryTree;

public class LowestCommonAncestorInBinaryTree {

    private LowestCommonAncestorInBinaryTree() {
    }

    public static void main(String[] args) {
        LowestCommonAncestorInBinaryTree application = new LowestCommonAncestorInBinaryTree();
        TwoNode root = application.getRoot();
        TwoNode commonNode = application.lowestCommonAncestor(root, 6, 7);
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

    public TwoNode lowestCommonAncestor(TwoNode root, double valueOne, double valueTwo) {
        LowestCommonAncestor lca = lowestCommonAncestorRecursive(root, valueOne, valueTwo);
        return lca.getCommonNode();
    }

    public LowestCommonAncestor lowestCommonAncestorRecursive(TwoNode root, double valueOne, double valueTwo) {

        if (root == null) {
            LowestCommonAncestor lca = new LowestCommonAncestor();
            //lca.setOne(false);
            //lca.setTwo(false);
            //lca.setCommonNode(null);
            return lca;
        }
        LowestCommonAncestor lcaLeft = lowestCommonAncestorRecursive(root.getLeftNode(), valueOne, valueTwo);
        if (lcaLeft.getCommonNode() != null) {
            return lcaLeft;
        }
        LowestCommonAncestor lcaRight = lowestCommonAncestorRecursive(root.getRightNode(), valueOne, valueTwo);
        if (lcaRight.getCommonNode() != null) {
            return lcaRight;
        }
        boolean isOne = lcaLeft.isOne() || lcaRight.isOne() || root.getValue() == valueOne;
        boolean isTwo = lcaLeft.isTwo() || lcaRight.isTwo() || root.getValue() == valueTwo;
        if (isOne && isTwo) {
            LowestCommonAncestor lca = new LowestCommonAncestor();
            lca.setOne(true);
            lca.setTwo(true);
            lca.setCommonNode(root);
            return lca;
        }
        if (isOne && !isTwo) {
            LowestCommonAncestor lca = new LowestCommonAncestor();
            lca.setOne(true);
            //lca.setTwo(false);
            //lca.setCommonNode(null);
            return lca;
        }
        if (!isOne && isTwo) {
            LowestCommonAncestor lca = new LowestCommonAncestor();
            //lca.setOne(false);
            lca.setTwo(true);
            //lca.setCommonNode(null);
            return lca;
        }
        LowestCommonAncestor lca = new LowestCommonAncestor();
        //lca.setOne(false);
        //lca.setTwo(false);
        //lca.setCommonNode(null);
        return lca;
    }

    private class LowestCommonAncestor {

        private boolean isOne;
        private boolean isTwo;
        private TwoNode commonNode;

        public LowestCommonAncestor() {
            this.isOne = false;
            this.isTwo = false;
            this.commonNode = null;
        }

        public boolean isOne() {
            return isOne;
        }

        public void setOne(boolean one) {
            isOne = one;
        }

        public boolean isTwo() {
            return isTwo;
        }

        public void setTwo(boolean two) {
            isTwo = two;
        }

        public TwoNode getCommonNode() {
            return commonNode;
        }

        public void setCommonNode(TwoNode commonNode) {
            this.commonNode = commonNode;
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
