public class MyQueue <T> {

    private final MyArrayList <T> list = new MyArrayList<>();

    public void add (T value) {
        list.add(value);
    }

    public void remove (int index){
        list.remove(index);
    }

    public void clear (){
        list.clear();
    }

    public int size (){
        return list.size();
    }

    public T peek (){
        return list.get(0);
    }

    public T poll (){
        T value = list.get(0);
        list.remove(0);
        return value;
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        MyQueue <String> queue = new MyQueue<>();
        queue.add("aaa");
        queue.add("bbb");
        queue.add("ccc");
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue);
    }
}
