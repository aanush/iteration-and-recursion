package com.student.selfworks.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class LeftViewAndRightViewInBinaryTree {

    private LeftViewAndRightViewInBinaryTree() {
    }

    public static void main(String[] args) {
        LeftViewAndRightViewInBinaryTree application = new LeftViewAndRightViewInBinaryTree();
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
        //expected left view top first : 8,2,1,3,6,5,14,15
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
        Map<Integer, TwoNode> verticalValueToNodeMap = new HashMap<Integer, TwoNode>();

        mapPreorderLeft(root, verticalValueToNodeMap, 0); // left view
        //mapPreorderRight(root, verticalValueToNodeMap, 0); // right view

        int verticalValueOfTop = 0;
        int verticalValueOfBottom = -(verticalValueToNodeMap.keySet().size() - 1);

        System.out.println("printing top first");
        for (int verticalValue = verticalValueOfTop; verticalValue >= verticalValueOfBottom; verticalValue--) {
            System.out.println(verticalValueToNodeMap.get(verticalValue).getValue());
        }

        System.out.println("printing bottom first");
        for (int verticalValue = verticalValueOfBottom; verticalValue <= verticalValueOfTop; verticalValue++) {
            System.out.println(verticalValueToNodeMap.get(verticalValue).getValue());
        }
    }

    public void mapPreorderLeft(TwoNode root, Map<Integer, TwoNode> verticalValueToNodeMap, int verticalValue) {
        if (root == null) {
            return;
        }
        if (verticalValueToNodeMap.get(verticalValue) == null) {
            verticalValueToNodeMap.put(verticalValue, root);
        }
        mapPreorderLeft(root.getLeftNode(), verticalValueToNodeMap, verticalValue - 1);
        mapPreorderLeft(root.getRightNode(), verticalValueToNodeMap, verticalValue - 1);
    }

    public void mapPreorderRight(TwoNode root, Map<Integer, TwoNode> verticalValueToNodeMap, int verticalValue) {
        if (root == null) {
            return;
        }
        if (verticalValueToNodeMap.get(verticalValue) == null) {
            verticalValueToNodeMap.put(verticalValue, root);
        }
        mapPreorderRight(root.getRightNode(), verticalValueToNodeMap, verticalValue - 1);
        mapPreorderRight(root.getLeftNode(), verticalValueToNodeMap, verticalValue - 1);
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
