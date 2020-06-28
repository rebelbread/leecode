package test.linkedList;

import test.linkedList.node.Node;

/**
 * @author zhiwj
 * @Description:
 * @date 2020-06-25 15:46
 */
public class Test4 {

    public static void main(String[] args) {
        //        4. 从尾到头打印单链表
        Node node = Node.gen(10);
        print(node);
    }

    private static void print(Node node) {
        if (node.next != null) {
            print(node.next);
        }
        System.out.println(node.data);
    }
}
