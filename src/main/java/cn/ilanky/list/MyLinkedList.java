package cn.ilanky.list;

import java.util.Iterator;

/**
 * @author ilanky
 * @date 2020年 09月20日 14:22:17
 * 单向链表
 */
public class MyLinkedList<T> implements MyList<T>,Iterable<T>{

    /**
     * 节点
     */
    private Node head;

    /**
     * 个数
     */
    private int N;

    public MyLinkedList(){
        head = new Node(null,null);
        N = 0;
    }

    @Override
    public void clear() {

        //清空链表只需将头节点断开
        head.next = null;
        N = 0;
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
        Node n = head.next;
        for (int index = 0;index<=i-1;index++){
            n = n.next;
        }
        return (T) n.item;
    }

    @Override
    public void insert(T t) {
        Node n = head;

        //循环遍历到链表尾部
        while (n.next!=null){
            n = n.next;
        }

        n.next = new Node(t,null);
        N++;
    }

    @Override
    public void insert(int i, T t) {
        //在第i个位置添加元素，则要找到i-1元素，将其指针指向新节点，新节点的指针指向i+1节点
        Node pre = head;
        for (int index = 0;index<=i-1;index++){
            pre = pre.next;
        }

        Node cur = pre.next;

        pre.next = new Node(t,cur);

        N++;
    }

    @Override
    public T remove(int i) {
        Node pre = head;

        for (int index = 0;index<=i-1;index++){
            pre = pre.next;
        }

        Node cur = pre.next;

        pre.next = cur.next;

        N--;
        return (T) cur.item;
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

    //反转链表
    public void reverse(){
        if (isEmpty()){
            return;
        }

        reverse(head.next);
    }

    public Node reverse(Node curr){
        //测试例子 1 2 3 4
        //递归出口是4这个元素，此时将头结点指向4 然后返回
        if (curr.next==null){
            head.next = curr;
            return curr;
        }

        //第一个进到这里的是3这个元素 此时返回的pre是4
        //因此将4的下一个结点指向3
        //3的下一个结点先置为null
        //第二个进到这里的是2 此时返回的是3
        //将3的下一个结点指向2
        //2的下一个结点置为null
        //第三个进到这里的是1 此时返回的是2
        //将2的下一个结点指向1
        //1的下一个结点置为null，程序结束
        //最终结果 head -> 4 -> 3 -> 2 ->1 反转成功
        Node pre = reverse(curr.next);
        pre.next = curr;
        curr.next = null;
        return curr;
    }

    public boolean isCircle(){
        Node slow = head.next;
        Node fast = head.next;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast.equals(slow)){
                return true;
            }
        }

        return false;
    }

    public T getCircleEntrance(){
        Node slow = head.next;
        Node fast = head.next;
        Node tmp = null;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast.equals(slow)){
                tmp = head.next;
                continue;
            }

            if (tmp != null){
                tmp = tmp.next;
                if (tmp.equals(slow)){
                    break;
                }
            }
        }
        return (T) tmp.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator{

        private Node n;

        public LIterator(){
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
