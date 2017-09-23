/**
 * 合并两个排序的链表
 *
 * 注意：
 * 1.鲁棒性，输入校验，边界校验
 * 2.指针指向
 *
 * 思路：
 * 递归解决
 */
public class NO17_MergeSortedLists {

    public static void main(String[] args) {
        Node h1 = new Node();
        h1.val = 1;
        h1.next = new Node();
        h1.next.val = 3;
        h1.next.next = new Node();
        h1.next.next.val = 5;
        h1.next.next.next= null;

        Node h2 = new Node();
        h2.val = 2;
        h2.next = new Node();
        h2.next.val = 4;
        h2.next.next = null;

        printList(h1);
        printList(h2);

        Node mergeHead1 = mergeListWithIteration(h1, h2);
        printList(mergeHead1);
//
//        Node mergeHead2 = mergeListsWithRecursion(h1, h2);
//        printList(mergeHead2);

    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static Node mergeListWithIteration(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        Node mergeHead = new Node();
        Node pointer = mergeHead;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                pointer.next = head1;
                head1 = head1.next;
            } else {
                pointer.next = head2;
                head2 = head2.next;
            }
            //移动pointer到合并后的链表末尾
            pointer = pointer.next;
        }

        if (head1 != null) {
            pointer.next = head1;
        }
        if (head2 != null) {
            pointer.next = head2;
        }
        return mergeHead.next;
    }


    //递归解法
    public static Node mergeListsWithRecursion(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        Node mergeHead = null;
        if (head1.val < head2.val) {
            mergeHead = head1;
            mergeHead.next = mergeListsWithRecursion(head1.next, head2);
        } else {
            mergeHead = head2;
            mergeHead.next = mergeListsWithRecursion(head1, head2.next);
        }
        return mergeHead;
    }

    static class Node {
        int val;
        Node next;
    }
}
