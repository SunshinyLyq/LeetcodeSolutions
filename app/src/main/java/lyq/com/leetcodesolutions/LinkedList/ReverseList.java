package lyq.com.leetcodesolutions.LinkedList;

/**
 * @author sunshiny
 * @date 2020-05-16.
 * @desc
 */
public class ReverseList {

    /**
     * Leetcode 24 反转链表
     * @param head
     * @return
     */
    // 递归算法
    public ListNode reverseListRecursion(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode reverseListHead = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return reverseListHead;
    }

    public ListNode revertseListCycle(ListNode head){
        if (head == null) return head;

        ListNode  cur = null;
        ListNode pre = head;

        while(pre != null){
            ListNode next = pre.next;
            pre.next = cur;
            cur = pre;
            pre = next;
        }

        return cur;
    }
    /**
     * 反转前N个元素
     * 递归
     * 注意点在于反转之后节点的连接
     */

    ListNode temp = null;
    public ListNode reverseN(ListNode head,int n){
        if (n == 1){
            temp = head.next;
            return head;
        }

        ListNode newHead = reverseN(head.next,n-1);
        head.next.next = head;
        head.next = temp;

        return newHead;

    }

    /**
     * leetcode 92 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     */
    public ListNode reverseBetween(ListNode head,int m,int n){
        //base case
        if (m == 1){
            return reverseN(head,n);
        }
        head.next = reverseBetween(head.next,m-1,n-1);
        return head;
    }

}
