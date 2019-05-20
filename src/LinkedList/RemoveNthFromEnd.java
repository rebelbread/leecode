package LinkedList;

/**
 * @author zhiwj
 * @date 2019/5/17
 */

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        new RemoveNthFromEnd().removeNthFromEnd(n1, 5);
        ListNode.print(n1);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nodeFirst = head;
        ListNode nodeSecond = head;
        ListNode pre = head;
        while (--n > 0) {
            nodeSecond = nodeSecond.next;
        }
        while (nodeSecond.next != null) {
            pre = nodeFirst;
            nodeSecond = nodeSecond.next;
            nodeFirst = nodeFirst.next;
        }
        if (nodeFirst == pre) {
            // 删除的是第一个
            head = head.next;
        } else {
            pre.next = nodeFirst.next;
        }
        return head;
    }

}
