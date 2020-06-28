package test.linkedList;

import test.linkedList.node.Node;

/**
 * @author zhiwj
 * @Description:
 * @date 2020-06-26 12:59
 */
public class Josephus {

    public static void main(String[] args) {
        // 假设有n个人围坐一圈，
        // 现在要求从第k个人开始报数，报到第m个数的人退出。
        // 然后从下一个人开始继续报数并按照同样的规则退出，
        // 直至所有人都退出。按照顺序输出各出列人的编号
        int n = 5;
        int k = 1;
        int m = 2;

        Node node = getNode(n);
        Node newDode = new Node();
        Node newHeadDode = newDode;

        // 第k个人开始报
        while (node.next != null) {
            for (int kt = 1; kt < k; kt++) {
                node = node.next;
            }
            Node lastNode = null;
            for (int mt = 1; mt < m; mt++) {
                lastNode = node;
                node = node.next;
            }
            newDode.next = node;
            newDode = newDode.next;

            lastNode.next = lastNode.next.next;
            node = lastNode.next;

            newDode.next = null;
        }
        Node.print(newHeadDode);
    }

    private static Node getNode(int n) {
        Node node = Node.gen(n);
        Node head = node;
        while (node.next != null) {
            node = node.next;
        }
        node.next = head;
        return head;
    }

}
