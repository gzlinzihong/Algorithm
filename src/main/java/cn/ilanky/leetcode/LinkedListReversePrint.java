package cn.ilanky.leetcode;

import java.util.Arrays;

/**
 * 反转链表
 * @author ilanky
 * @date 2021年 05月29日 12:03:02
 */
public class LinkedListReversePrint {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        head.next = n1;
        n1.next = n2;
        int[] ints = solution.reversePrint(head);
        Arrays.stream(ints).forEach(System.out::println);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class Solution {
        private int i = 0;
        private ListNode tail;
        public int[] reversePrint(ListNode head) {
            reverse(head, null);
            int[] res = new int[i];
            int j = 0;
            while(tail != null){
                res[j] = tail.val;
                tail = tail.next;
                j++;
            }
            return res;
        }

        public ListNode reverse(ListNode curr, ListNode pre){
            // 递归出口
            if(curr.next == null){
                i++;
                tail = curr;
                curr.next = pre;
                pre.next = null;
                return pre;
            }
            i++;
            ListNode n = reverse(curr.next, curr);
            n.next = pre;
            return pre;
        }
    }
}
