package com.leetcode.problems;

/**
 * @Description TODO
 * @Author cgc
 * @Date 2019/4/3/003 21:52
 * @Version 1.0
 */
public class N0002 {

    /**
     *      给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     *         如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     *         您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     *         示例：
     *
     *         输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     *         输出：7 -> 0 -> 8
     *         原因：342 + 465 = 807
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode s = new ListNode(0);
        ListNode h = s;
        int t = 0;
        while (true) {

            if (l1 != null) {
                t += l1.val;
            }
            if (l2 != null) {
                t += l2.val;
            }
            s.val = t % 10;
            t = t / 10;
            if ((l1 == null || l1.next == null) && (l2 == null || l2.next == null)) {
                if (t > 0) {
                    s.next = new ListNode(t);
                }
                break;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            s.next = new ListNode(0);
            s = s.next;
        }
        return h;
    }

    public static void main(String[] args) {
        ListNode l1 = new N0002().new ListNode(9);
        l1.next = new N0002().new ListNode(4);
        l1.next.next = new N0002().new ListNode(3);

        ListNode l2 = new N0002().new ListNode(5);
        l2.next = new N0002().new ListNode(6);
        l2.next.next = new N0002().new ListNode(4);

        ListNode aa = new N0002().addTwoNumbers(l1, l2);
        while (aa != null) {
            System.out.print(aa.val);
            aa = aa.next;
        }
        System.out.println();
    }
}

