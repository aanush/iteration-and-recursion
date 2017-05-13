package com.student.selfworks.linkedListSingle;

public class CloneRandomPointerInLinkedListSingle {

    private CloneRandomPointerInLinkedListSingle() {
    }

    public static void main(String[] args) {
        CloneRandomPointerInLinkedListSingle application = new CloneRandomPointerInLinkedListSingle();

        TwoNode firstNode = application.getFirstNode();
        TwoNode sameFirstNode = firstNode;
        TwoNode copyFirstNode = application.correctCopy(sameFirstNode);
        boolean isSame = application.isSame(firstNode, sameFirstNode);
        boolean isCopy = application.isCopy(firstNode, copyFirstNode);
        if (isSame && isCopy) {
            System.out.println(true);
        }
    }

    private boolean isSame(TwoNode nodeOne, TwoNode nodeTwo) {
        return nodeOne == nodeTwo;
    }

    private boolean isCopy(TwoNode nodeOne, TwoNode nodeTwo) {
        if (nodeOne == null && nodeTwo == null) {
            return true;
        }
        if (nodeOne == nodeTwo) {
            return false;
        }

        if (nodeOne == null && nodeTwo != null) {
            return false;
        }
        if (nodeOne != null && nodeTwo == null) {
            return false;
        }

        if (nodeOne.getValue() != nodeTwo.getValue()) {
            return false;
        }
        if (!isCopy(nodeOne.getNextNode(), nodeTwo.getNextNode())) {
            return false;
        }

        if (nodeOne.getRandomNode() == null && nodeTwo.getRandomNode() == null) {
            return true;
        }
        if (nodeOne.getRandomNode() == null && nodeTwo.getRandomNode() != null) {
            return false;
        }
        if (nodeOne.getRandomNode() != null && nodeTwo.getRandomNode() == null) {
            return false;
        }
        if (nodeOne.getRandomNode().getValue() != nodeTwo.getRandomNode().getValue()) {
            return false;
        }
        return true;
    }

    private TwoNode getFirstNode() {
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
        node01.setNextNode(node02);
        node02.setNextNode(node03);
        node03.setNextNode(node04);
        node04.setNextNode(node05);
        node05.setNextNode(node06);
        node06.setNextNode(node07);
        node07.setNextNode(node08);
        node08.setNextNode(node09);

        node01.setRandomNode(node09);
        node02.setRandomNode(node01);
        node03.setRandomNode(node01);
        node04.setRandomNode(node01);
        node05.setRandomNode(node01);
        node06.setRandomNode(node06);
        node07.setRandomNode(node06);
        node08.setRandomNode(null);
        return node01;
    }

    public TwoNode correctCopy(TwoNode firstNode) {
        TwoNode currentNode = firstNode;
        while (currentNode != null) {
            TwoNode copyCurrentNode = new TwoNode(false, currentNode.getValue(), null, null);
            copyCurrentNode.setNextNode(currentNode.getNextNode());
            currentNode.setNextNode(copyCurrentNode);
            currentNode = copyCurrentNode.getNextNode();
        }

        currentNode = firstNode;
        while (currentNode != null) {
            TwoNode copyCurrentNode = currentNode.getNextNode();
            if (currentNode.getRandomNode() != null) {
                copyCurrentNode.setRandomNode(currentNode.getRandomNode().getNextNode());
            }
            currentNode = copyCurrentNode.getNextNode();
        }

        TwoNode copyFirstNode = firstNode.getNextNode();
        currentNode = firstNode;
        while (currentNode != null) {
            TwoNode copyCurrentNode = currentNode.getNextNode();
            currentNode.setNextNode(copyCurrentNode.getNextNode());
            if (copyCurrentNode.getNextNode() != null) {
                copyCurrentNode.setNextNode(copyCurrentNode.getNextNode().getNextNode());
            }
            currentNode = currentNode.getNextNode();
        }

        return copyFirstNode;
    }

    private class TwoNode {

        private boolean original;
        private double value;
        private TwoNode nextNode;
        private TwoNode randomNode;

        public TwoNode(double value) {
            this.original = true;
            this.value = value;
            this.nextNode = null;
            this.randomNode = null;
        }

        public TwoNode(boolean original, double value, TwoNode nextNode, TwoNode randomNode) {
            this.original = original;
            this.value = value;
            this.nextNode = nextNode;
            this.randomNode = randomNode;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public TwoNode getNextNode() {
            return nextNode;
        }

        public void setNextNode(TwoNode nextNode) {
            this.nextNode = nextNode;
        }

        public TwoNode getRandomNode() {
            return randomNode;
        }

        public void setRandomNode(TwoNode randomNode) {
            this.randomNode = randomNode;
        }

    }

}
