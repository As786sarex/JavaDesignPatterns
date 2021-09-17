package datatypes;

public interface Queue<T> {
    boolean add(T value);
    T peek();
    T poll();
    boolean isEmpty();
}
