package com.student.selfworks.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class CloneRandomPointerInBinaryTree {

    private CloneRandomPointerInBinaryTree() {
    }

    public static void main(String[] args) {
        CloneRandomPointerInBinaryTree application = new CloneRandomPointerInBinaryTree();
        ThreeNode root = application.getRoot();
        //ThreeNode copyRoot = application.copyWithMap(root);
        ThreeNode copyRoot = application.correctCopy(root);
        boolean isClone = application.isCloneButNotSame(root, copyRoot);
        System.out.println(isClone);
    }

    private ThreeNode getRoot() {
        double value = 0.0;
        ThreeNode node01 = new ThreeNode(++value);
        ThreeNode node02 = new ThreeNode(++value);
        ThreeNode node03 = new ThreeNode(++value);
        ThreeNode node04 = new ThreeNode(++value);
        ThreeNode node05 = new ThreeNode(++value);
        ThreeNode node06 = new ThreeNode(++value);
        ThreeNode node07 = new ThreeNode(++value);
        ThreeNode node08 = new ThreeNode(++value);
        ThreeNode node09 = new ThreeNode(++value);
        ThreeNode node10 = new ThreeNode(++value);
        ThreeNode node11 = new ThreeNode(++value);
        ThreeNode node12 = new ThreeNode(++value);
        ThreeNode node13 = new ThreeNode(++value);
        ThreeNode node14 = new ThreeNode(++value);
        ThreeNode node15 = new ThreeNode(++value);

        node08.setLeftNode(node04);
        node08.setRightNode(node12);
        node04.setLeftNode(node02);
        node04.setRightNode(node06);
        node12.setLeftNode(node10);
        node12.setRightNode(node14);
        node02.setLeftNode(node01);
        node02.setRightNode(node03);
        node06.setLeftNode(node05);
        node06.setRightNode(node07);
        node10.setLeftNode(node09);
        node10.setRightNode(node11);
        node14.setLeftNode(node13);
        node14.setRightNode(node15);

        node12.setRandomNode(node08);
        node08.setRandomNode(node12);
        node04.setRandomNode(node08);
        node02.setRandomNode(node13);
        node13.setRandomNode(node02);
        node01.setRandomNode(node03);
        node15.setRandomNode(node13);
        return node08;
    }

    public ThreeNode copyWithMap(ThreeNode root) {
        if (root == null) {
            return null;
        }
        Map<ThreeNode, ThreeNode> rootMap = new HashMap<ThreeNode, ThreeNode>();
        copyWithMap(root, rootMap);
        for (ThreeNode node : rootMap.keySet()) {
            ThreeNode copyNode = rootMap.get(node);
            ThreeNode copyRandomNode = rootMap.get(node.getRandomNode());
            copyNode.setRandomNode(copyRandomNode);
        }
        return rootMap.get(root);
    }

    public void copyWithMap(ThreeNode root, Map<ThreeNode, ThreeNode> rootMap) {
        ThreeNode copyRoot = new ThreeNode(false, root.getValue(), null, null, null);
        if (root.getLeftNode() != null) {
            copyWithMap(root.getLeftNode(), rootMap);
            copyRoot.setLeftNode(rootMap.get(root.getLeftNode()));
        }
        if (root.getRightNode() != null) {
            copyWithMap(root.getRightNode(), rootMap);
            copyRoot.setRightNode(rootMap.get(root.getRightNode()));
        }
        rootMap.put(root, copyRoot);
    }

    public ThreeNode correctCopy(ThreeNode root) {
        ThreeNode copyRoot = incorrectCopy(root);
        correctRandom(copyRoot);
        correctRight(root);
        return copyRoot;
    }

    public ThreeNode incorrectCopy(ThreeNode root) {
        if (root == null) {
            return null;
        }

        ThreeNode copyRoot = new ThreeNode(false, root.value, null, null, null);
        if (root.getLeftNode() == null && root.getRightNode() == null) {
            root.setRightNode(copyRoot);
            copyRoot.setRandomNode(root);
            return copyRoot;
        }

        ThreeNode copyLeft = incorrectCopy(root.getLeftNode());
        ThreeNode copyRight = incorrectCopy(root.getRightNode());
        copyRoot.setLeftNode(copyLeft);
        copyRoot.setRightNode(root.getRightNode());
        if (root.getRightNode() != null) {
            root.getRightNode().setRightNode(copyRight);
        }
        root.setRightNode(copyRoot);
        copyRoot.setRandomNode(root);

        return copyRoot;
    }

    public void correctRandom(ThreeNode copyRoot) {
        if (copyRoot == null) {
            return;
        }

        ThreeNode root = copyRoot.getRandomNode();
        if (root.getRandomNode() == null) {
            copyRoot.setRandomNode(null);
        }
        if (root.getRandomNode() != null) {
            copyRoot.setRandomNode(root.getRandomNode().getRightNode());
        }
        if (copyRoot.getLeftNode() != null) {
            correctRandom(copyRoot.getLeftNode());
        }
        if (copyRoot.getRightNode() != null) {
            correctRandom(copyRoot.getRightNode().getRightNode());
        }
    }

    public void correctRight(ThreeNode root) {
        if (root == null) {
            return;
        }

        ThreeNode copyRoot = root.getRightNode();
        root.setRightNode(copyRoot.getRightNode());
        if (root.getRightNode() == null) {
            copyRoot.setRightNode(null);
        }
        if (root.getRightNode() != null) {
            copyRoot.setRightNode(root.getRightNode().getRightNode());
        }
        correctRight(root.getLeftNode());
        correctRight(root.getRightNode());
    }

    public boolean isCloneButNotSame(ThreeNode root, ThreeNode copyRoot) {
        if (root == null && copyRoot == null) {
            return true;
        }
        if (root == copyRoot) {
            return false;
        }

        if (root == null && copyRoot != null) {
            return false;
        }
        if (root != null && copyRoot == null) {
            return false;
        }

        if (root.getValue() != copyRoot.getValue()) {
            return false;
        }
        if (!isCloneButNotSame(root.getLeftNode(), copyRoot.getLeftNode())) {
            return false;
        }
        if (!isCloneButNotSame(root.getRightNode(), copyRoot.getRightNode())) {
            return false;
        }

        if (root.getRandomNode() == null && copyRoot.getRandomNode() == null) {
            return true;
        }
        if (root.getRandomNode() == null && copyRoot.getRandomNode() != null) {
            return false;
        }
        if (root.getRandomNode() != null && copyRoot.getRandomNode() == null) {
            return false;
        }
        if (root.getRandomNode().getValue() != copyRoot.getRandomNode().getValue()) {
            return false;
        }

        return true;
    }

    private class ThreeNode {
        private boolean original;
        private double value;
        private ThreeNode leftNode;
        private ThreeNode rightNode;
        private ThreeNode randomNode;

        public ThreeNode(boolean original, double value, ThreeNode leftNode, ThreeNode rightNode, ThreeNode randomNode) {
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.randomNode = randomNode;
            this.original = original;
        }

        public ThreeNode(double value) {
            this.original = true;
            this.value = value;
            this.leftNode = null;
            this.rightNode = null;
            this.randomNode = null;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public ThreeNode getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(ThreeNode leftNode) {
            this.leftNode = leftNode;
        }

        public ThreeNode getRightNode() {
            return rightNode;
        }

        public void setRightNode(ThreeNode rightNode) {
            this.rightNode = rightNode;
        }

        public ThreeNode getRandomNode() {
            return randomNode;
        }

        public void setRandomNode(ThreeNode randomNode) {
            this.randomNode = randomNode;
        }
    }

}
