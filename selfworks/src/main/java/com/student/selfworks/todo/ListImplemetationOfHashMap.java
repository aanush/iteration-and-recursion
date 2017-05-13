package com.student.selfworks.todo;

public class ListImplemetationOfHashMap {

    public static void main(String[] args) {
        ListImplemetationOfHashMap application = new ListImplemetationOfHashMap();
        application.test();
    }

    public void test() {
        HashMapp hashMapp = new HashMapp<Integer, String>(10);
        hashMapp.put(1, "1");
        hashMapp.put(2, "2");
        hashMapp.put(3, "3");
        String a1 = (String) hashMapp.get(1);
        String a2 = (String) hashMapp.get(2);
        String a3 = (String) hashMapp.get(3);
    }

    private class HashMapp<K, V> {

        private HashNode<K, V>[] headNodeArray;
        private HashNode<K, V>[] lastNodeArray;

        public HashMapp(int size) {
            headNodeArray = new HashNode[size];
            lastNodeArray = new HashNode[size];
        }

        public void put(Object key, Object value) {
            int index = key == null ? 0 : key.hashCode();
            HashNode nevvNode = new HashNode(0, key, value, null);
            if (lastNodeArray[index] != null) {
                lastNodeArray[index].setNextHashNode(nevvNode);
            } else {
                headNodeArray[index] = nevvNode;
            }
            lastNodeArray[index] = nevvNode;
        }

        public Object get(Object key) {
            int index = key == null ? 0 : key.hashCode();
            HashNode currentNode = headNodeArray[index];
            while (currentNode != null) {
                if (key.equals(currentNode.getKey())) {
                    return currentNode.getValue();
                }
            }
            return null;
        }

    }

    private class HashNode<K, V> {

        private int hash;
        private K key;
        private V value;
        private HashNode<K, V> nextHashNode;

        public HashNode(int hash, K key, V value, HashNode<K, V> nextHashNode) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.nextHashNode = nextHashNode;
        }

        public int getHash() {
            return hash;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public HashNode<K, V> getNextHashNode() {
            return nextHashNode;
        }

        public void setNextHashNode(HashNode<K, V> nextHashNode) {
            this.nextHashNode = nextHashNode;
        }

    }

}
