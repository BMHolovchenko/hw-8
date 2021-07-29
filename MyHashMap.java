import java.util.Arrays;
import java.util.Objects;

public class MyHashMap<K, V> {
    private final int CAPACITY = 16;
    private final Node<K, V>[] hashTable;
    private int size;

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?, ?> entry = (Node<?, ?>) o;
            return Objects.equals(key, entry.key);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(key);
        }
    }


    public MyHashMap() {
        hashTable = new Node[CAPACITY];
    }

    public void put(K key, V value) {
        int hash = key.hashCode() % CAPACITY;
        Node<K, V> e = hashTable[hash];

        if (e == null) {
            hashTable[hash] = new Node<K, V>(key, value);
        } else {
            while (e.next != null) {
                if (e.getKey() == key) {
                    e.setValue(value);
                    return;
                }
                e = e.next;
            }
            if (e.getKey() == key) {
                e.setValue(value);
                return;
            }
            e.next = new Node<K, V>(key, value);
        }
        size++;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int hash = key.hashCode() % CAPACITY;
        Node<K, V> e = hashTable[hash];
        if (e == null) {
            return null;
        }
        while (e != null) {
            if (e.getKey() == key) {
                return e.getValue();
            }
            e = e.next;
        }
        return null;
    }

    public void remove(K key) {
        if (size == 0) {
            System.out.println("Collection is empty");
        } else {
            int hash = key.hashCode() % CAPACITY;
            Node<K, V> e = hashTable[hash];
            if (e.getKey() == key) {
                hashTable[hash] = e.next;
                e.next = null;
            }
            Node<K, V> prev = e;
            e = e.next;
            while (e != null) {
                if (e.getKey() == key) {
                    prev.next = e.next;
                }
            }
            size--;
        }
    }
    public void clear() {
        size = 0;
        Arrays.fill(hashTable, null);
    }

    public void print() {
        for (int i = 0; i < CAPACITY; i++) {
            if (hashTable[i] != null) {
                Node<K, V> e = hashTable[i];
                while (e != null) {
                    System.out.println(e.getKey() +
                            "=" + e.getValue());
                    e = e.next;
                }
            }
        }
        if (size == 0) {
            System.out.println("Empty");
        }
    }
    public static void main(String[] args) {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        myHashMap.put(1, "One");
        myHashMap.put(2, "Two");
        myHashMap.put(3, "Three");
        myHashMap.put(4, "Four");
        myHashMap.print();
        System.out.println(myHashMap.size());
        System.out.println(myHashMap.get(3));
        myHashMap.remove(1);
        System.out.println(myHashMap.size());
        myHashMap.print();
        myHashMap.clear();
        System.out.println(myHashMap.size());
    }
}