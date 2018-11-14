package LinkedList;

/**
 * @author zhiwj
 * @date 2018/11/14
 */
public class ReverseList {
    /**
     * 反转一个单链表。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     */

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
        ListNode result = new ReverseList().reverseList(n1);
        ListNode.print(result);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode resultNode = head;
        ListNode nextNode = head.next;
        resultNode.next = null;

        while (nextNode != null) {
            ListNode tmp = nextNode;
            nextNode = nextNode.next;

            tmp.next = resultNode;
            resultNode = tmp;
        }
        return resultNode;
    }

}
