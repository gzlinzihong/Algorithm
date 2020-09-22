package cn.ilanky.list;


import java.util.Scanner;

/**
 * @author ilanky
 * @date 2020年 09月22日 18:15:50
 */
public class JohnTest {

    public void testJohnCircle(){
        //整个环总共及个人
        int n;

        //报数为多少自杀
        int sign;

        int count = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入总人数:");
        n = Integer.valueOf(scanner.nextLine());
        System.out.println("请输入报数值:");
        sign = Integer.valueOf(scanner.nextLine());

        Node<Integer> first = null;
        Node<Integer> pre = null;
        //构建循环列表
        for (int i = 1;i<=n;i++){
            if (first == null){
                first = new Node<>(i,null);
                pre = first;
                continue;
            }

            pre.next = new Node(i,null);
            pre = pre.next;
        }
        pre.next = first;


//        print(first);

        Node t = first;
        Node before = first;
        while (t != t.next){

            count++;

            if (count == sign){
                 before.next = t.next;
                 count = 0;
//                 System.out.print(t.item+" ");
                 t = t.next;
            }else {
                before = t;
                t = t.next;
            }
        }

        System.out.println(t.item);

    }

    public void print(Node first){
        while (first!=null){
            System.out.print(first.item+" ");
            first = first.next;
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

    public static void main(String[] args) {
        JohnTest test = new JohnTest();
        test.testJohnCircle();
    }

}
