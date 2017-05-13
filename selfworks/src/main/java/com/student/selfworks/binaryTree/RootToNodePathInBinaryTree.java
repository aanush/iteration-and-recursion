package com.student.selfworks.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePathInBinaryTree {

    private RootToNodePathInBinaryTree() {
    }

    public static void main(String[] args) {
        RootToNodePathInBinaryTree application = new RootToNodePathInBinaryTree();
        double value = 0.0;
        TwoNode node01 = application.createNode(++value);
        TwoNode node02 = application.createNode(++value);
        TwoNode node03 = application.createNode(++value);
        TwoNode node04 = application.createNode(++value);
        TwoNode node05 = application.createNode(++value);
        TwoNode node06 = application.createNode(++value);
        TwoNode node07 = application.createNode(++value);
        TwoNode node08 = application.createNode(++value);
        TwoNode node09 = application.createNode(++value);
        TwoNode node10 = application.createNode(++value);
        TwoNode node11 = application.createNode(++value);
        TwoNode node12 = application.createNode(++value);
        TwoNode node13 = application.createNode(++value);
        TwoNode node14 = application.createNode(++value);
        TwoNode node15 = application.createNode(++value);
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
//        List<TwoNode> path = application.getRootToNodePathGivenNode(node08, node07);
//        for (TwoNode doubleNode : path) {
//            System.out.print(doubleNode.getValue());
//            System.out.print(" + ");
//        }
//        System.out.println();
        TwoNode lcaNode = application.lowestCommonAncestorFromRootToNodePath(node08, node09, application.createNode(19));
    }

    private TwoNode createNode(double value) {
        return new TwoNode(value);
    }

    public TwoNode lowestCommonAncestorFromRootToNodePath(TwoNode root, TwoNode nodeOne, TwoNode nodeTwo) {
        List<TwoNode> pathOne = getRootToNodePathGivenNode(root, nodeOne);
        List<TwoNode> pathTwo = getRootToNodePathGivenNode(root, nodeTwo);
        if (pathOne == null || pathTwo == null) {
            return null;
        }
        int size = pathOne.size() < pathTwo.size() ? pathOne.size() : pathTwo.size();
        TwoNode node = null;
        int count = 0;
        while (count < size) {
            if (pathOne.get(count) != pathTwo.get(count)) {
                break;
            }
            node = pathOne.get(count);
            count = count + 1;
        }
        return node;
    }

//    public List<TwoNode> getRootToNodePathGivenNode(TwoNode root, TwoNode node) {
//        System.out.println("..........");
//        if (root == null) {
//            return null;
//        }
//        if (root == node) {
//            List<TwoNode> path = new ArrayList<TwoNode>();
//            path.add(root);
//            return path;
//        }
//        if (root.getLeftNode() != null) {
//            List<TwoNode> path = getRootToNodePathGivenNode(root.getLeftNode(), node);
//            if (path != null) {
//                path.add(0, root); // root.setNextNode(listFirstNode); listFirstNode = root;
//                return path;
//            }
//        }
//        if (root.getRightNode() != null) {
//            List<TwoNode> path = getRootToNodePathGivenNode(root.getRightNode(), node);
//            if (path != null) {
//                path.add(0, root);  // root.setNextNode(listFirstNode); listFirstNode = root;
//                return path;
//            }
//        }
//        return null;
//    }

    public List<TwoNode> getRootToNodePathGivenNode(TwoNode root, TwoNode node) {
        System.out.println("..........");
        if (root == null) {
            return null;
        }
        if (root == node) {
            List<TwoNode> path = new ArrayList<TwoNode>();
            path.add(root);
            return path;
        }
        List<TwoNode> path = null;
        path = getRootToNodePathGivenNode(root.getLeftNode(), node);
        if (path != null) {
            path.add(0, root); // root.setNextNode(listFirstNode); listFirstNode = root;
            return path;
        }
        path = getRootToNodePathGivenNode(root.getRightNode(), node);
        if (path != null) {
            path.add(0, root);  // root.setNextNode(listFirstNode); listFirstNode = root;
            return path;
        }
        return null;
    }

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

}
