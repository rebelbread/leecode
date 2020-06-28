package test.linkedList;

import test.linkedList.node.Node;

/**
 * @author zhiwj
 * @Description:
 * @date 2020-06-25 15:19
 */
public class Test2 {

    public static void main(String[] args) {
        // 2.单链表中倒数第K个节点
        int k = 2;
        Node node = Node.gen(10);
        Node n = node;
        Node p = node;
        while (k-- > 0) {
            p = p.next;
        }
        while (p.next != null) {
            n = n.next;
            p = p.next;
        }
        System.out.println(n.data);
    }

}
