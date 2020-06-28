package test.linkedList.node;

/**
 * @author zhiwj
 * @Description:
 * @date 2020-06-25 15:04
 */
public class Node {

    public Integer data;
    public Node next;

    public Node() {
    }

    public Node(Integer data) {
        this.data = data;
    }

    public Node(Integer data, Node next) {
        this.data = data;
        this.next = next;
    }

    public static Node gen(int count) {
        Node head = new Node(1);
        Node node = head;
        for (int i = 1; i < count; i++) {
            node = genNext(node);
        }
        return head;
    }
    public static Node gen(int count, int start, int step) {
        Node head = new Node(start);
        Node node = head;
        for (int i = 1; i < count; i = i + step) {
            node = genNext(node, step);
        }
        return head;
    }

    public static Node genNext(Node node) {
        Node curr = new Node();
        curr.data = node.data + 1;
        node.next = curr;
        return curr;
    }

    public static Node genNext(Node node, int step) {
        Node curr = new Node();
        curr.data = node.data + step;
        node.next = curr;
        return curr;
    }

    public static void print(Node node) {
        Node curr = node;
        while (curr != null) {
            System.out.print(curr.data + "\t");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        Node gen = gen(5);
        print(gen);
    }
}
