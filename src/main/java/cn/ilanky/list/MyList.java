package cn.ilanky.list;

public interface MyList<T> extends Iterable<T>{

    void clear();

    int length();

    boolean isEmpty();

    T get(int i);

    void insert(T t);

    void insert(int i,T t);

    T remove(int i);

    int indexOf(T t);
}
