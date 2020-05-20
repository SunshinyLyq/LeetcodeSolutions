package lyq.com.leetcodesolutions.LinkedList;

/**
 * @author sunshiny
 * @date 2020-05-16.
 * @desc
 *
 * Leetcode 234 回文链表
 * 思想： 回文字符串可以用双指针，但是因为单链表无法倒着遍历
 * 可以利用递归函数的堆栈，也就是说将链表进行后序遍历，然后与单链表进行对比
 */
public class Palindrome {

    ListNode left;

    private boolean isPalindrome(ListNode head){
        left = head;
        return traverse(head);
    }

    private boolean traverse(ListNode right) {
        if (right == null) return true;

        boolean res = traverse(right.next);
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }
    //此刻的时间复杂度和空间复杂度为o(n),能不能优化一下空间复杂度
    /**
     * 1.可以先使用快慢指针，找到链表的中点
     * 3.从slow后面开始反转这个链表，并进行比较
     *
     * 空间复杂度为O（1）;
     */
    public boolean isPailndrome2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode left = head;
        ListNode right = reverse(slow.next);
        while(right != null){
            if (left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        slow.next = reverse(right);//将链表恢复
        return true;
    }

    private ListNode reverse(ListNode slow) {
        ListNode pre = null;
        ListNode cur = slow;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
