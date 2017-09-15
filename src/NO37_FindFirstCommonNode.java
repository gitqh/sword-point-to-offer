/**
 * 找到两个链表第一个公共节点
 *
 * 思路：
 * 1.直接法，第一个链表顺序遍历，每遍历到一个节点时，在
 * 第二个链表顺序遍历每个节点，O(mn)
 * 2.使用栈，O(m+n)
 * 3.先行法，O(m+n)，不需要使用辅助栈
 */
public class NO37_FindFirstCommonNode {
    public static void main(String[] args) {
        // 第一个公共结点在链表中间
        // 1 - 2 - 3 \
        //            6 - 7
        //     4 - 5 /
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n6;
        n6.next = n7;
        n4.next = n5;
        n5.next = n6;
        System.out.println(findFirstCommonNode(n1, n4).val); // 6
    }

    public static Node findFirstCommonNode(Node n1, Node n2) {
        int l1 = getLength(n1);
        int l2 = getLength(n2);
        int lDiff = l1 - l2;
        Node nLong = n1;
        Node nShort = n2;
        if (lDiff < 0) {
            nLong = n2;
            nShort = n1;
            lDiff = l2 - l1;
        }
        //先在长链表上走lDiff步
        for (int i = 0; i < lDiff; i++) {
            nLong = nLong.next;
        }
        while (nLong!=null&&nShort!=null
                &&nLong.val!=nShort.val) {
            nLong = nLong.next;
            nShort = nShort.next;
        }
        return nLong;
    }

    private static int getLength(Node node) {
        int length = 0;
        while (node!= null) {
            node = node.next;
            length++;
        }
        return length;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
