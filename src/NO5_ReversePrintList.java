import java.util.Stack;

/**
 * 从尾到头打印链表，不改变链表结构
 */
public class NO5_ReversePrintList {

    public static void main(String[] args) {
        Node n1 = new Node();
        n1.val=1;
        n1.next = new Node();
        n1.next.val=2;
        n1.next.next = new Node();
        n1.next.next.val=3;
        n1.next.next.next=new Node();
        n1.next.next.next.val=4;
        n1.next.next.next.next=null;

        Node n2 = new Node();
        n2.val=1;
        n2.next=null;
//
//        printListReverseUsingIteration(n1);
//        System.out.println();
//        printListReverseUsingIteration(n2);
//        System.out.println();
//        printListReverseUsingIteration(null);
//        System.out.println();
//
//        printListReverseUsingRecursion(n1);
//        System.out.println();
//        printListReverseUsingRecursion(n2);
//        System.out.println();
//        printListReverseUsingRecursion(null);
//        System.out.println();

        printListReverseUsingReverse(n1);
        System.out.println();
        printListReverseUsingReverse(n2);
        System.out.println();
        printListReverseUsingReverse(null);
        System.out.println();
    }

    //利用栈先进后出的特性
    public static void printListReverseUsingIteration(Node head) {
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        Node tmp;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            System.out.print(tmp.val+" ");
        }
    }

    //递归本质是栈结构，但是链表较长时，函数调用层级较深，可能导致函数调用栈溢出
    public static void printListReverseUsingRecursion(Node head) {
        if (head != null) {
            printListReverseUsingIteration(head.next);
            System.out.print(head.val + " ");
        }
    }

    //改变链表结构--不符合本题要求
    public static void printListReverseUsingReverse(Node head) {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            System.out.println(head.val);
            return;
        }
        Node prev = null;
        while (head != null) {
            Node temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        while (prev.next != null) {
            System.out.print(prev.val);
            prev = prev.next;
        }
        System.out.print(prev.val);
    }

    public static class Node {
        int val;
        Node next;
    }
}
