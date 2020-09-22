package cn.ilanky.list;

import java.util.Iterator;

/**
 * @author ilanky
 * @date 2020年 09月22日 15:06:35
 * 双向链表
 */
public class TwoWayLinkedList<T> implements MyList<T>,Iterable<T>{

    private Node head;

    private Node last;

    private int N;

    public TwoWayLinkedList(){
        head = new Node(null,null,null);
        last = null;
        N = 0;
    }
    @Override
    public void clear() {
        head.next = null;
        head.pre = null;
        head.item = null;
        last = null;
        N = 0;
    }

    public T getFirst(){
        if (isEmpty()){
            return null;
        }
        return (T) head.next.item;
    }

    public T getLast(){
        if (isEmpty()){
            return null;
        }
        return (T) last.item;
    }

    @Override
    public int length() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return N==0;
    }

    @Override
    public T get(int i) {
        Node n = head;
        for (int index = 0;index<=i;index++){
            n = n.next;
        }
        return  (T) n.item;
    }

    @Override
    public void insert(T t) {
        //链表为空的情况
        if (isEmpty()){
            Node newNode = new Node(t, head, null);
            last = newNode;
            head.next = last;
        }else {
            Node oldLast = last;
            //新节点的前序结点为当前的last，后继结点为空
            Node newNode = new Node(t, oldLast, null);

            //原Last结点的next为新结点
            oldLast.next = newNode;

            //新结点为last
            last = newNode;
        }
        N++;
    }

    @Override
    public void insert(int i, T t) {
        Node pre = head;
        //1. 先找到i-1结点
        for (int index = 0;index<=i-1;index++){
            pre = pre.next;
        }
        //2. 找到i结点
        Node next = pre.next;

        //3. 新结点的前序结点为i-1，后继结点为i
        Node newNode = new Node(t, pre, next);

        //4. i-1的下一个结点为新结点，i的前一个结点为新结点
        pre.next = newNode;
        next.pre = newNode;

        N++;
    }

    @Override
    public T remove(int i) {

        Node pre = head;
        for (int index = 0;index<=i-1;index++){
            pre = pre.next;
        }

        Node curr = pre.next;

        Node next = curr.next;

        pre.next = next;
        next.pre = pre;
        return (T) curr.item;
    }

    @Override
    public int indexOf(T t) {
        Node n = head;

        for (int i = 0;n.next!=null;i++){
            n = n.next;
            if (n.item.equals(t)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }

    public class Node<T>{
        private T item;
        private Node pre;
        private Node next;

        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    private class TIterator implements Iterator{

        private Node n;

        public TIterator(){
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
}
