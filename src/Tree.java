public interface Tree <T extends Comparable<T>>{

    boolean isEmpty();

    void insert(T data);

    void delete(T target);

    boolean contains(T target);
}
