package test.linkedList;

import test.linkedList.node.Node;

/**
 * @author zhiwj
 * @Description:
 * @date 2020-06-25 15:23
 */
public class Test3 {
    public static void main(String[] args) {
        //        3. 单链表的反转
        Node node = Node.gen(10);
        Node newNode = null;
        while (node != null) {
            Node old = node;
            node = node.next;
            if (newNode != null) {
                old.next = newNode;
            } else {
                old.next = null;
            }
            newNode = old;
        }
        Node.print(newNode);
    }
}
