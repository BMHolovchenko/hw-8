public class MyLinkedList<T> {

    private int size;
    private Node<T> last;
    private Node<T> first;

    public MyLinkedList() {
        last = new Node<T>(null, first, null);
        first = new Node<T>(null, null, last);
    }

    private static class Node<T> {
        private T element;
        Node<T> previous;
        Node<T> next;

        public Node(T element, Node<T> previous, Node<T> next) {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public void setPrev(Node<T> previous) {
            this.previous = previous;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    public void add(T element) {
        Node<T> prev = last;
        prev.setElement(element);
        last = new Node<T>(null, prev, null);
        prev.setNext(last);
        size++;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        if (size == 0) {
            System.out.println("Collection is empty");
        }
        else if (index >= 0 && index < size) {
            Node<T> deleted = getNodeByIndex(index);
            Node<T> prevNode = deleted.getPrevious();
            Node<T> nextNode = deleted.getNext();
            prevNode.setNext(nextNode);
            nextNode.setPrev(prevNode);
            size--;
        }
    }

    private Node<T> getNodeByIndex(int counter) {
        Node<T> removeTarget = first.getNext();
        for (int i = 0; i < counter; i++) {
            removeTarget = getNextElement(removeTarget);
        }
        return removeTarget;
    }

    public T get(int index) {
        Node<T> value = first.getNext();
        for (int i = 0; i < index; i++) {
            value = getNextElement(value);
        }
        return value.getElement();
    }

    private Node<T> getNextElement(Node<T> initial) {
        return initial.getNext();
    }

    public void clear() {
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(get(i)).append(" ");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        MyLinkedList <String> list = new MyLinkedList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println(list);
        System.out.println(list.size());
        list.remove(1);
        System.out.println(list);
        System.out.println(list.get(1));
        list.clear();
        System.out.println(list.size());
    }
}