package lyq.com.leetcodesolutions.LinkedList;

/**
 * @author sunshiny
 * @date 2020-05-18.
 * @desc 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoSum {
    public static void main(String[] args) {


    }

    /**
     * 伪代码：
     * 1. 将当前节点初始化为返回列表的哑结点
     * 2. 设置进位为0
     * 3. 遍历列表知道尾端
     * 3.1 记录遍历的节点，并记录下来
     * 3.2 将 两个链接的节点 相加求和 需要加上进位carry值
     * 3.3 更新进位的数值
     * 3.4 计算出下一个节点，用sum值对10求余获取到下一个节点
     * 4. 判断进位值是否为1，如果是的，需要追加一个节点
     * 5. 返回哑结点的下一个结点
     */
    public static ListNode addTwoSum(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;
        ListNode cur = dummyNode;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) {
            cur.next = new ListNode(carry);
        }

        return dummyNode.next;
    }
}

