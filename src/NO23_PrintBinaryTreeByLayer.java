import java.util.LinkedList;
import java.util.Queue;

/**
 * 分层打印二叉树
 *
 * 思路：
 * 队列
 */
public class NO23_PrintBinaryTreeByLayer {

    public static void main(String[] args) {
//       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        Node root = new Node();
        root.val = 8;
        root.left = new Node();
        root.left.val = 6;
        root.left.left = new Node();
        root.left.left.val = 5;
        root.left.right = new Node();
        root.left.right.val = 7;
        root.right = new Node();
        root.right.val = 10;
        root.right.left = new Node();
        root.right.left.val = 9;
        root.right.right = new Node();
        root.right.right.val = 11;
        printBinaryTreeByLayer(root);
        //         1
        //        /
        //       3
        //      /
        //     5
        //    /
        //   7
        //  /
        // 9
        Node root2 = new Node();
        root2.val = 1;
        root2.left = new Node();
        root2.left.val = 3;
        root2.left.left = new Node();
        root2.left.left.val = 5;
        root2.left.left.left = new Node();
        root2.left.left.left.val = 7;
        root2.left.left.left.left = new Node();
        root2.left.left.left.left.val = 9;
        System.out.println("\n");
        printBinaryTreeByLayer(root2);
        // 0
        //  \
        //   2
        //    \
        //     4
        //      \
        //       6
        //        \
        //         8
        Node root3 = new Node();
        root3.val = 0;
        root3.right = new Node();
        root3.right.val = 2;
        root3.right.right = new Node();
        root3.right.right.val = 4;
        root3.right.right.right = new Node();
        root3.right.right.right.val = 6;
        root3.right.right.right.right = new Node();
        root3.right.right.right.right.val = 8;
        System.out.println("\n");
        printBinaryTreeByLayer(root3);
        // 1
        Node root4 = new Node();
        root4.val = 1;
        System.out.println("\n");
        printBinaryTreeByLayer(root4);
        // null
        System.out.println("\n");
        printBinaryTreeByLayer(null);
    }

    public static void printBinaryTreeByLayer(Node n) {
        if (n==null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(n);
        while (!queue.isEmpty()) {
            Node front = queue.poll();
            System.out.print(front.val + " ");
            if (front.left!=null) {
                queue.add(front.left);
            }
            if (front.right != null) {
                queue.add(front.right);
            }
        }
    }

    static class  Node {
        int val;
        Node left;
        Node right;
    }
}
