/**
 * 寻找链表中倒数第k个节点
 *
 * 只遍历一次链表
 *
 * 当用一个指针遍历链表无法解决问题时，可以尝试用两个指针
 * 来遍历链表，可以让其中一个指针遍历的速度快一些，比如一次
 * 在链表上走两步，或者让它先走若干步
 *
 * 考察代码的鲁棒性
 *
 */
public class NO15_FindKthToTail {
    public static void main(String[] args) {
        Node head = new Node();
        head.val = 1;
        head.next = new Node();
        head.next.val = 2;
        head.next.next = new Node();
        head.next.next.val = 3;
        head.next.next.next = new Node();
        head.next.next.next.val = 4;
        head.next.next.next.next = new Node();
        head.next.next.next.next.val = 5;
        head.next.next.next.next.next = new Node();
        head.next.next.next.next.next.val = 6;
        head.next.next.next.next.next.next = new Node();
        head.next.next.next.next.next.next.val = 7;
        head.next.next.next.next.next.next.next = new Node();
        head.next.next.next.next.next.next.next.val = 8;
        head.next.next.next.next.next.next.next.next = new Node();
        head.next.next.next.next.next.next.next.next.val = 9;
        System.out.println(findKthToTail(head, 1).val); // 倒数第一个
        System.out.println(findKthToTail(head, 5).val); // 中间的一个
        System.out.println(findKthToTail(head, 9).val); // 倒数最后一个就是顺数第一个
        System.out.println(findKthToTail(head, 10));
    }

    public static Node findKthToTail(Node head, int k) {
        //输入链表不能为空，并且k大于0
        if (k < 1 || head == null) {
            return null;
        }
        //倒数第k个节点与倒数第一个节点相隔k-1个位置
        Node pointer = head;
        for (int i=1; i < k; i++) {
            if (pointer.next != null) {
                pointer = pointer.next;
            } else {
                return null;
            }
        }
        //pointer还没有走到链表的末尾，则pointer和head一起走
        //当pointer走到最后一个节点时，pointer.next=null，head就是倒数第k个节点
        while (pointer.next != null) {
            head = head.next;
            pointer = pointer.next;
        }
        return head;
    }

    static class Node {
        int val;
        Node next;
    }
}
