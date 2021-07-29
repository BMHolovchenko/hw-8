import java.util.Stack;

public class MyStack <T> {
    private final MyArrayList <T> list = new MyArrayList<>();

    public void push (T value) {
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
        return list.get(list.size()-1);
    }

    public void pop (){
        T value = list.get(list.size()-1);
        list.remove(list.size()-1);
        System.out.println(value);
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        MyStack <String> stack = new MyStack<>();
        stack.push("aaa");
        stack.push("bbb");
        stack.push("ccc");
        stack.push("ddd");
        stack.push("eee");
        stack.pop();
        System.out.println(stack);
        stack.remove(0);
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.size());
        stack.clear();
        System.out.println(stack.size());
    }
}
