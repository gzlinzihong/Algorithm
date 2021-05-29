package cn.ilanky.leetcode;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author ilanky
 * @date 2021年 05月29日 16:38:53
 */
public class LinkedListCopy {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        /**
         * 解决办法:
         * 将原链表的每个节点复制一份放后面。即链表变为
         * node1 -> node1New -> node2 -> node2New
         * 进行random指针的赋值后拆开
         * @param head
         * @return
         */
        public Node copyRandomList(Node head) {
            if(head == null){
                return head;
            }
            Node n = head;
            while(n != null){
                Node tmp = new Node(n.val);
                tmp.next = n.next;
                n.next = tmp;
                n = tmp.next;
            }

            Node curr = head;
            while(curr != null){
                if(curr.random != null){
                    curr.next.random = curr.random.next;
                }
                curr = curr.next.next;
            }

            Node pre = head;
            Node cur = head.next;
            Node res = head.next;
            while(cur.next != null){
                pre.next = pre.next.next;
                cur.next = cur.next.next;
                pre = pre.next;
                cur = cur.next;
            }
            pre.next = null;
            return res;
        }
    }
}

