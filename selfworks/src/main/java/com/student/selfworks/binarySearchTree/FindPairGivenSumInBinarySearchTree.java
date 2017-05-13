package com.student.selfworks.binarySearchTree;

import java.util.Stack;

public class FindPairGivenSumInBinarySearchTree {

    private FindPairGivenSumInBinarySearchTree() {
    }

    public static void main(String[] args) {
        FindPairGivenSumInBinarySearchTree application = new FindPairGivenSumInBinarySearchTree();
        TwoNode root = application.getRoot();
        double sum = 0;
        while (sum < 32) {
            System.out.println();
            System.out.println();
            System.out.println(".. .. .. .. .. .. .. .. .. .." + " given sum is " + sum + " " + ".. .. .. .. .. .. .. .. .. ..");
            application.allPairGivenSum(root, sum);
            //application.onePairGivenSum(root, sum);
            sum = sum + 1;
        }
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

    public void allPairGivenSum(TwoNode root, double sum) {
        if (root == null) {
            return;
        }
        if (root.getLeftNode() == null && root.getRightNode() == null) {
            return;
        }

        Stack<TwoNode> increasingStack = new Stack<TwoNode>();
        addLeftViewStepToStack(root, increasingStack);
        TwoNode smallNode = increasingStack.pop();

        Stack<TwoNode> decreasingStack = new Stack<TwoNode>();
        addRightViewStepToStack(root, decreasingStack);
        TwoNode largeNode = decreasingStack.pop();

        while (smallNode != null && largeNode != null && smallNode.getValue() < largeNode.getValue()) {
            double currentSum = smallNode.getValue() + largeNode.getValue();
            if (sum == currentSum) {
                printCurrentSum(smallNode, largeNode, currentSum);
            }
            if (sum >= currentSum) {
                addLeftViewStepToStack(smallNode.getRightNode(), increasingStack);
                smallNode = increasingStack.pop();
            }
            if (sum <= currentSum) {
                addRightViewStepToStack(largeNode.getLeftNode(), decreasingStack);
                largeNode = decreasingStack.pop();
            }
        }

    }

    public void onePairGivenSum(TwoNode root, double sum) {
        if (root == null) {
            return;
        }
        if (root.getLeftNode() == null && root.getRightNode() == null) {
            return;
        }

        Stack<TwoNode> increasingStack = new Stack<TwoNode>();
        addLeftViewStepToStack(root, increasingStack);
        TwoNode smallNode = increasingStack.pop();

        Stack<TwoNode> decreasingStack = new Stack<TwoNode>();
        addRightViewStepToStack(root, decreasingStack);
        TwoNode largeNode = decreasingStack.pop();

        while (smallNode != null && largeNode != null && smallNode.getValue() < largeNode.getValue()) {
            double currentSum = smallNode.getValue() + largeNode.getValue();
            if (sum == currentSum) {
                printCurrentSum(smallNode, largeNode, currentSum);
                break;
            }
            if (sum >= currentSum) {
                addLeftViewStepToStack(smallNode.getRightNode(), increasingStack);
                smallNode = increasingStack.pop();
            }
            if (sum <= currentSum) {
                addRightViewStepToStack(largeNode.getLeftNode(), decreasingStack);
                largeNode = decreasingStack.pop();
            }
        }

    }

    private void addLeftViewStepToStack(TwoNode root, Stack<TwoNode> increasingStack) {
        TwoNode currentNode = root;
        while (currentNode != null) {
            increasingStack.add(currentNode);
            currentNode = currentNode.getLeftNode();
        }
    }

    private void addRightViewStepToStack(TwoNode root, Stack<TwoNode> decreasingStack) {
        TwoNode currentNode = root;
        while (currentNode != null) {
            decreasingStack.add(currentNode);
            currentNode = currentNode.getRightNode();
        }
    }

    private void printCurrentSum(TwoNode smallNode, TwoNode largeNode, double currentSum) {
        System.out.println(smallNode.getValue() + " + " + largeNode.getValue() + " = " + currentSum);
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
