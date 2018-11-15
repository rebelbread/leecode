package LinkedList;

/**
 * @author zhiwj
 * @date 2018/11/15
 */
public class MergeTwoLists {
    /**
     * 合并两个有序链表
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p>
     * 示例：
     * <p>
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */
    /**
     * 输入：
     * [-9,3]
     * [5,7]
     * 输出：
     * [-9,3,7]
     * 预期：
     * [-9,3,5,7]
     */
    public static void main(String[] args) {
        ListNode n1 = new ListNode(-9);
        ListNode n2 = new ListNode(3);
        n1.next = n2;
        ListNode m1 = new ListNode(5);
        ListNode m2 = new ListNode(7);
        m1.next = m2;

        ListNode listNode = new MergeTwoLists().mergeTwoLists(n1, m1);
        ListNode.print(listNode);

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode node = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        if (l1 == null) {
            while (l2 != null) {
                node.next = l2;
                l2 = l2.next;
                node = node.next;
            }
        } else {
            while (l1 != null) {
                node.next = l1;
                l1 = l1.next;
                node = node.next;
            }
        }

        head = head.next;
        return head;
    }
}
