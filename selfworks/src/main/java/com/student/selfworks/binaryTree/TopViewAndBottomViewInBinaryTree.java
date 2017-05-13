package com.student.selfworks.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopViewAndBottomViewInBinaryTree {

    private TopViewAndBottomViewInBinaryTree() {
    }

    public static void main(String[] args) {
        TopViewAndBottomViewInBinaryTree application = new TopViewAndBottomViewInBinaryTree();
        application.printView(application.getRoot());
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

        //binary tree : 1,2,4..3,4,7..6,7,null..5,6,null..2,8,9..null,9,10..null,10,11..null,11,12..null,12,13..null,13,14..15,14,null
        //expected top view left first : 1,2,8,9,10,11,12,13,14
        //expected bottom view left first : 1,5,6,7,10,11,12,15,14
        node02.setLeftNode(node01);
        node02.setRightNode(node04);
        node04.setLeftNode(node03);
        node04.setRightNode(node07);
        node06.setLeftNode(node05);
        node07.setLeftNode(node06);
        node08.setLeftNode(node02);
        node08.setRightNode(node09);
        node09.setRightNode(node10);
        node10.setRightNode(node11);
        node11.setRightNode(node12);
        node12.setRightNode(node13);
        node13.setRightNode(node14);
        node14.setLeftNode(node15);

        return node08;
    }

    public void printView(TwoNode root) {
        Map<Integer, TwoNode> horizontalValueToNodeMap = new HashMap<Integer, TwoNode>();
        Queue<HorizontalTwoNode> queue = new LinkedList<HorizontalTwoNode>();
        queue.add(new HorizontalTwoNode(root, 0));
        int leftMostHorizontalValue = 0;
        int rightMostHorizontalValue = 0;

        while (!queue.isEmpty()) {
            HorizontalTwoNode currentNode = queue.poll();
//          top view : topNode must not be replaced with bottomNode
//          bottom view : topNode must be replaced with bottomNode
            boolean bottomView = false;
            if (bottomView || horizontalValueToNodeMap.get(currentNode.getHorizontalValue()) == null) {
                horizontalValueToNodeMap.put(currentNode.getHorizontalValue(), currentNode.getNode());
            }
            if (currentNode.getNode().getLeftNode() != null) {
                queue.add(new HorizontalTwoNode(currentNode.getNode().getLeftNode(), currentNode.getHorizontalValue() - 1));
                if (currentNode.getHorizontalValue() - 1 < leftMostHorizontalValue) {
                    leftMostHorizontalValue = currentNode.getHorizontalValue() - 1;
                }
            }
            if (currentNode.getNode().getRightNode() != null) {
                queue.add(new HorizontalTwoNode(currentNode.getNode().getRightNode(), currentNode.getHorizontalValue() + 1));
                if (currentNode.getHorizontalValue() + 1 > rightMostHorizontalValue) {
                    rightMostHorizontalValue = currentNode.getHorizontalValue() + 1;
                }
            }
        }

        System.out.println("printing left first");
        for (int horizontalValue = leftMostHorizontalValue; horizontalValue <= rightMostHorizontalValue; horizontalValue++) {
            System.out.println(horizontalValueToNodeMap.get(horizontalValue).getValue());
        }
        System.out.println("printing right first");
        for (int horizontalValue = rightMostHorizontalValue; horizontalValue >= leftMostHorizontalValue; horizontalValue--) {
            System.out.println(horizontalValueToNodeMap.get(horizontalValue).getValue());
        }

    }

    private class HorizontalTwoNode {

        private TwoNode node;
        private int horizontalValue;

        public HorizontalTwoNode(TwoNode node, int horizontalValue) {
            this.node = node;
            this.horizontalValue = horizontalValue;
        }

        public TwoNode getNode() {
            return node;
        }

        public void setNode(TwoNode node) {
            this.node = node;
        }

        public int getHorizontalValue() {
            return horizontalValue;
        }

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
