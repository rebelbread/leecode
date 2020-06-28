package test.linkedList;

import test.linkedList.node.Node;

/**
 * @author zhiwj
 * @Description:
 * @date 2020-06-25 15:03
 */
public class Test1 {

    public static void main(String[] args) {
        // 单链表中节点的个数
        Node node = Node.gen(10);
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        System.out.println(count);
    }


}
