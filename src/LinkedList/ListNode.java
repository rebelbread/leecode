package LinkedList;

/**
 * @author zhiwj
 * @date 2018/11/13
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static void print(ListNode n1) {
        while (n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }
}
