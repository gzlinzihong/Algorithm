package cn.ilanky.list;

import java.util.Iterator;

/**
 * @author ilanky
 * @date 2020年 09月20日 13:57:05
 * 线性表
 */
public class SequenceList<T> implements Iterable<T>,MyList<T>{

    /**
     * 存放数据的数组
     */
    private T[] elements;

    /**
     * 元素个数
     */
    private int N;


    public SequenceList(int capacity){
        elements = (T[]) new Object[capacity];
        N = 0;
    }

    @Override
    public void clear(){
        N = 0;
    }

    @Override
    public int length(){
        return N;
    }

    @Override
    public boolean isEmpty(){
        return N==0;
    }

    @Override
    public T get(int i){
        return elements[i];
    }

    @Override
    public void insert(T t){
        //如果数组长度不够了则进行扩容，扩容至其2倍
        if (N == elements.length){
            resize(2*elements.length);
        }
        elements[N++] = t;
    }

    @Override
    public void insert(int i,T t){
        //如果数组长度不够了则进行扩容，扩容至其2倍
        if (N == elements.length){
            resize(2*elements.length);
        }

        //从最后一个节点到i位置，全部往后挪一个位置
        for (int j = N;j>i;j--){
            elements[j] = elements[j-1];
        }

        //赋值
        elements[i] = t;
        N++;
    }

    @Override
    public T remove(int i){
        T element = elements[i];
        //从第i个元素开始后面的元素往前挪一个位置
        for (int j = i;j<N-1;j++){
            elements[j] = elements[j+1];
        }
        N--;

        //如果元素个数小于数组长度的1/4，则进行缩容
        if (N <elements.length/4){
            resize(elements.length/2);
        }
        return element;
    }

    @Override
    public int indexOf(T t){
        for (int i = 0;i<N;i++){
            if (elements[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    public void resize(int newSize){
        T[] tmp = elements;
        elements = (T[]) new Object[newSize];
        for (int i = 0;i<N;i++){
            elements[i] = tmp[i];
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{

        private int cursor;

        public SIterator(){
            cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return cursor<N;
        }

        @Override
        public Object next() {
            return elements[cursor++];
        }
    }
}
