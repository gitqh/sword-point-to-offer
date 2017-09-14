/**
 * O(1)时间删除链表节点
 * 给定单项链表的头指针和一个节点指针，定义一个函数在O(1)时间删除该节点
 *
 * 思路：利用给定的节点指针，通过该节点指向的下一个节点的值替换该节点值，
 * 然后修改指向，指向下一个节点的下一个节点
 *
 * 1->2->3->4->...->5->6->7
 * 5
 *
 * node(5).val = node(5).next.val;
 * node(5).next = node(5).next.next;
 */
public class NO13_DeleteNodeFromList {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node middle = new Node(2);
        head.next = middle;
        head.next.next = new Node(3);
        Node last = new Node(4);
        head.next.next.next = last;
        Node node = new Node(5);


        head = deleteNode(head, null);
        printList(head);
        head = deleteNode(head, head);
        printList(head);
        head = deleteNode(head, last);
        printList(head);
        head = deleteNode(head, middle);
        printList(head);
        head = deleteNode(head, node);
        printList(head);

    }

    public static Node deleteNode(Node head, Node toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return head;
        }
        if (head == toBeDeleted) {
            return head.next;
        }
        //链表至少有两个节点，判断是否是最后一个元素
        if (toBeDeleted.next == null) {
            Node tmp = head;
            while (tmp.next != toBeDeleted) {
                tmp = tmp.next;
            }
            tmp.next = null;
        } else {
            toBeDeleted.val = toBeDeleted.next.val;
            toBeDeleted.next = toBeDeleted.next.next;
        }
        return head;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
