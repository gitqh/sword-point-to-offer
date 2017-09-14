/**
 * 求二叉树的镜像
 *
 * 递归
 */
public class NO19_MirrorBinaryTree {

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
        printTree(root);
        System.out.println();
        mirror(root);
        printTree(root);
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
        printTree(root2);
        System.out.println();
        mirror(root2);
        printTree(root2);
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
        printTree(root3);
        System.out.println();
        mirror(root3);
        printTree(root3);
    }

    public static void mirror(Node root) {
        if (root == null ||
                (root.left == null && root.right == null)) {
            return ;
        }
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left!=null) {
            mirror(root.left);
        }
        if (root.right != null) {
            mirror(root.right);
        }
    }

    public static void printTree(Node node) {
        if (node != null) {
            printTree(node.left);
            System.out.print(node.val + " ");
            printTree(node.right);
        }
    }

    static class Node {
        int val;
        Node left;
        Node right;
    }
}
