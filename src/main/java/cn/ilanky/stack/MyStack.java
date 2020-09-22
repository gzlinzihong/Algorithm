package cn.ilanky.stack;

import java.util.Iterator;

/**
 * @author ilanky
 * @date 2020年 09月22日 20:32:36
 * 栈
 */
public class MyStack<T> implements Iterable<T>{

    //头结点
    private Node head;

    private int N;

    public MyStack(){
        head = new Node(null,null);
        N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void push(T t){
        Node oldFirst = head.next;
        Node newNode = new Node(t,null);
        head.next = newNode;
        newNode.next = oldFirst;
        N++;
    }

    public T peek(){
        return (T) head.next.item;
    }

    public T pop(){
        Node first = head.next;
        if (first==null){
            return null;
        }
        head.next = first.next;
        N--;
        return (T) first.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{

        private Node n;

        public SIterator(){
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
