package test.linkedList;

import test.linkedList.node.Node;

/**
 * @author zhiwj
 * @Description:
 * @date 2020-06-25 15:52
 */
public class Test5 {

    public static void main(String[] args) {
        // 5. 合并两个有序的单链表
        Node node1 = Node.gen(8, 1, 2);
        Node node2 = Node.gen(8, 2, 2);

        Node newNode = new Node();
        Node head = newNode;

        while (node1 != null && node2 != null) {
            if (node1.data < node2.data) {
                newNode.next = node1;
                node1 = node1.next;
                newNode = newNode.next;
                newNode.next = null;
            } else {
                newNode.next = node2;
                node2 = node2.next;
                newNode = newNode.next;
                newNode.next = null;
            }
        }

        while (node1 != null) {
            newNode.next = node1;
            node1 = node1.next;
            newNode = newNode.next;
            newNode.next = null;
        }

        while (node2 != null) {
            newNode.next = node2;
            node2 = node2.next;
            newNode = newNode.next;
            newNode.next = null;
        }

        Node.print(head);

    }
}
