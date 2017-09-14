/**
 * 翻转链表
 */
public class NO16_ReverseList {
    public static void main(String[] args) {
        Node node = new Node();
        node.val = 1;
        node.next = new Node();
        node.next.val = 2;
        node.next.next = new Node();
        node.next.next.val = 3;
        node.next.next.next = null;
        printList(node);
        Node reverseHead = reverseList(node);
        printList(reverseHead);
    }

    public static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        //使用逻辑头节点
        Node root = new Node();
        root.next = null;
        Node next = null;
        while (head != null) {
            //记录要处理的下一个节点
            next = head.next;
            //当前节点的下一个节点指向逻辑头节点的下一个节点
            head.next = root.next;
            root.next = head;
            head = next;
        }
        return root.next;
    }



    static class Node {
        int val;
        Node next;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }
}

