package cn.ilanky.queue;

import java.util.Iterator;

/**
 * @author ilanky
 * @date 2020年 09月22日 21:46:13
 * 队列
 */
public class MyQueue<T> implements Iterable<T>{

    private Node head;

    private Node last;

    private int N;

    public MyQueue(){
        head = new Node(null,null);
        last = head;
        N = 0;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public T dequeue(){
        if (isEmpty()){
            return null;
        }
        Node n = head.next;
        head.next = n.next;
        N--;
        return (T) n.item;
    }

    public void enqueue(T t){
        Node<T> newNode = new Node<>(t, null);
        Node oldLast = last;
        oldLast.next = newNode;
        last = newNode;
        N++;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator{

        private Node n;

        public QIterator(){
            n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }

    public class Node<T>{

        public T item;

        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
