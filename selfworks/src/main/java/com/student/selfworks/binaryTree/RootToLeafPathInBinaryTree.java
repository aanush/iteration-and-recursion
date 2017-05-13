package com.student.selfworks.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPathInBinaryTree {

    private RootToLeafPathInBinaryTree() {
    }

    public static void main(String[] args) {
        RootToLeafPathInBinaryTree application = new RootToLeafPathInBinaryTree();
        TwoNode root = application.getRoot();
        //application.printRootToLeafAllPath(root);
        //application.printRootToLeafGivenSumAllPath(root, 25);
        //application.printRootToLeafGivenSumOnePath(root, 25);
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

    public void printRootToLeafAllPath(TwoNode root) {
        allPath(root, new ArrayList<TwoNode>());
    }

    public void printRootToLeafGivenSumAllPath(TwoNode root, double sum) {
        givenSumAllPath(root, new ArrayList<TwoNode>(), sum);
    }

    public void printRootToLeafGivenSumOnePath(TwoNode root, double sum) {
        givenSumOnePath(root, new ArrayList<TwoNode>(), sum);
    }

//    public void allPath(TwoNode root, List<TwoNode> path) {
//        System.out.println("..........");
//        if (root == null) {
//            return;
//        }
//        //path.add(root); // not correctRandom
//        List<TwoNode> copyPath = new ArrayList<TwoNode>(path);// correctRandom
//        copyPath.add(root);// correctRandom
//        if (root.getLeftNode() == null && root.getRightNode() == null) {
//            for (TwoNode doubleNode : copyPath) {
//                System.out.print(doubleNode.getValue());
//                System.out.print(" + ");
//            }
//            System.out.println();
//            return;
//        }
//        if (root.getLeftNode() != null) {
//            allPath(root.getLeftNode(), copyPath);
//        }
//        if (root.getRightNode() != null) {
//            allPath(root.getRightNode(), copyPath);
//        }
//    }

//    public void givenSumAllPath(TwoNode root, List<TwoNode> path, double sum) {
//        System.out.println("..........");
//        if (root == null) {
//            return;
//        }
//        //path.add(root); //not correctRandom
//        List<TwoNode> copyPath = new ArrayList<TwoNode>(path); //correctRandom
//        copyPath.add(root); //correctRandom
//        sum = sum - root.getValue();
//        if (root.getLeftNode() == null && root.getRightNode() == null && sum == 0) {
//            for (TwoNode doubleNode : copyPath) {
//                System.out.print(doubleNode.getValue());
//                System.out.print(" + ");
//            }
//            System.out.println();
//            return;
//        }
//        if (root.getLeftNode() != null) {
//            givenSumAllPath(root.getLeftNode(), copyPath, sum);
//        }
//        if (root.getRightNode() != null) {
//            givenSumAllPath(root.getRightNode(), copyPath, sum);
//        }
//    }

//    public boolean givenSumOnePath(TwoNode root, List<TwoNode> path, double sum) {
//        System.out.println("..........");
//        if (root == null) {
//            return false;
//        }
//        //path.add(root); //not correctRandom
//        List<TwoNode> copyPath = new ArrayList<TwoNode>(path); //correctRandom
//        copyPath.add(root); //correctRandom
//        sum = sum - root.getValue();
//        if (root.getLeftNode() == null && root.getRightNode() == null && sum == 0) {
//            for (TwoNode doubleNode : copyPath) {
//                System.out.print(doubleNode.getValue());
//                System.out.print(" + ");
//            }
//            System.out.println();
//            return true;
//        }
//        if (root.getLeftNode() != null) {
//            boolean printed = givenSumOnePath(root.getLeftNode(), copyPath, sum);
//            if (printed) {
//                return true;
//            }
//        }
//        if (root.getRightNode() != null) {
//            boolean printed = givenSumOnePath(root.getRightNode(), copyPath, sum);
//            if (printed) {
//                return true;
//            }
//        }
//        return false;
//    }

    public void allPath(TwoNode root, List<TwoNode> path) {
        System.out.println("..........");
        if (root == null) {
            return;
        }
        path.add(root);
        if (root.getLeftNode() == null && root.getRightNode() == null) {
            printCurrentPath(path);
            path.remove(path.size() - 1);
            return;
        }
        allPath(root.getLeftNode(), path);
        allPath(root.getRightNode(), path);
        path.remove(path.size() - 1);
    }

    public void givenSumAllPath(TwoNode root, List<TwoNode> path, double sum) {
        System.out.println("..........");
        if (root == null) {
            return;
        }
        path.add(root);
        sum = sum - root.getValue();
        if (root.getLeftNode() == null && root.getRightNode() == null && sum == 0) {
            printCurrentPath(path);
            path.remove(path.size() - 1);
            return;
        }
        givenSumAllPath(root.getLeftNode(), path, sum);
        givenSumAllPath(root.getRightNode(), path, sum);
        path.remove(path.size() - 1);
    }

    public boolean givenSumOnePath(TwoNode root, List<TwoNode> path, double sum) {
        System.out.println("..........");
        if (root == null) {
            return false;
        }
        path.add(root);
        sum = sum - root.getValue();
        if (root.getLeftNode() == null && root.getRightNode() == null && sum == 0) {
            printCurrentPath(path);
            path.remove(path.size() - 1);
            return true;
        }
        boolean printed = false;
        printed = givenSumOnePath(root.getLeftNode(), path, sum);
        if (printed) {
            return true;
        }
        printed = givenSumOnePath(root.getRightNode(), path, sum);
        if (printed) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    private void printCurrentPath(List<TwoNode> path) {
        for (TwoNode twoNode : path) {
            System.out.print(twoNode.getValue() + " + ");
        }
        System.out.println();
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
