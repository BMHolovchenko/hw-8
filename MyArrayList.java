public class MyArrayList <T>{
    private Object [] list;
    private int size;

    public MyArrayList() {
        this.list = new Object[10];
    }

    public void add(T value) {
        if (list.length==size){
            Object[] newArray = new Object[list.length * 2];
            System.arraycopy(list,0,newArray,0,size);
            list = newArray;
        }
        list[size] = value;
        size++;
    }

    public void remove(int index) {
        if (size==0) {
            System.out.println("Collection is empty");
        } else {
            System.arraycopy(list, index + 1, list, index, size - index - 1);
            size--;
        }
    }

    public void clear() {
        size = 0;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) list [index];
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(list[i]).append(" ");
        }
        return result.toString();
    }
}