/**
 * 
 * 根据前序中序遍历的结果,重建二叉树
 * 
 * 例如：
 * 前序{1,2,4,7,3,5,6,8}
 * 中序{4,7,2,1,5,3,8,6}
 * 后序{7,4,2,5,8,6,3,1}
 *
 * 思路：递归实现重建
 */
public class NO6_ConstructBinaryTree {
    public static void main(String[] args) {
        int[] preorder = {1,2,4,7,3,5,6,8};
        int[] inorder = {4,7,2,1,5,3,8,6};
        int[] lastorder = {7,4,2,5,8,6,3,1};

//        printTreePreorder(constructBinaryTreeWithPreAndMid(preorder,inorder));
//        System.out.println();
//        printTreeInorder(constructBinaryTreeWithPreAndMid(preorder,inorder));
//        System.out.println();
//        printTreeLastorder(constructBinaryTreeWithPreAndMid(preorder,inorder));
//        System.out.println();
//
        printTreePreorder(constructBinaryTreeWithLastAndMid(lastorder, inorder));
        System.out.println();
        printTreeInorder(constructBinaryTreeWithLastAndMid(lastorder, inorder));
        System.out.println();
        printTreeLastorder(constructBinaryTreeWithLastAndMid(lastorder, inorder));
    }

    public static Node constructBinaryTreeWithPreAndMid(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length!=inorder.length) {
            return null;
        }
        return constructBinaryTreeWithPreAndMid(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

//    public static Node constructBinaryTreeWithPreAndMid(int[] preOrder, int[] inOrder, int startPreorder, int endPreorder,
//                                                        int startInorder, int endInorder) {
//        if (startPreorder > endPreorder || startInorder > endInorder) {
//            return null;
//        }
//        Node root = new Node(preOrder[startPreorder]);
//
//        int divider = 0;
//        while (divider <= endInorder && inOrder[divider] != root.val) {
//            divider++;
//        }
//        int offSet = divider - startInorder;
//        root.left = constructBinaryTreeWithPreAndMid(preOrder, inOrder, startPreorder + 1,
//                startPreorder + offSet, startInorder,
//                startInorder + offSet - 1);
//        root.right = constructBinaryTreeWithPreAndMid(preOrder, inOrder, startPreorder + offSet + 1,
//                endPreorder, divider + 1, endInorder);
//        return root;
//    }

    public static Node constructBinaryTreeWithPreAndMid(int[] preOrder, int[] inOrder, int startPreorder, int endPreorder,
                                                        int startInorder, int endInorder) {
        if (startPreorder > endPreorder || startInorder > endInorder) {
            return null;
        }
        Node root = new Node(preOrder[startPreorder]);
        for (int i = startInorder; i<=endInorder;i++) {
            if (inOrder[i] == preOrder[startPreorder]) {
                int offset = i - startInorder;
                root.left = constructBinaryTreeWithPreAndMid(preOrder, inOrder, startPreorder + 1,
                        startPreorder + offset, startInorder,i - 1);
                root.right = constructBinaryTreeWithPreAndMid(preOrder, inOrder, startPreorder + offset + 1,
                        endPreorder, i + 1, endInorder);
            }
        }
        return root;
    }

    public static Node constructBinaryTreeWithLastAndMid(int[] lastOrder, int[] inOrder,
                                                        int startLast, int endLast,
                                                        int startInorder, int endInorder) {
        if (startLast > endLast || startInorder > endInorder) {
            return null;
        }
        Node root = new Node(lastOrder[endLast]);
        for (int i = 0; i <= endInorder; i++) {
            if (inOrder[i] == lastOrder[endLast]) {
                int offset = i - startInorder;
                root.left = constructBinaryTreeWithLastAndMid(lastOrder, inOrder, startLast, startLast + offset - 1,
                        startInorder, i-1);
                root.right = constructBinaryTreeWithLastAndMid(lastOrder, inOrder, startLast + offset, endLast - 1,
                        i+1, endInorder);
            }
        }
        return root;
    }

    public static Node constructBinaryTreeWithLastAndMid(int[] lastorder, int[] inorder) {
        if (lastorder == null || inorder == null || lastorder.length != inorder.length) {
            return null;
        }
        return constructBinaryTreeWithLastAndMid(lastorder,inorder,0,lastorder.length-1, 0,
                inorder.length-1);
    }

    public static void printTreeInorder(Node root) {
        if (root != null) {
            printTreeInorder(root.left);
            System.out.print(root.val+" ");
            printTreeInorder(root.right);
        }
    }

    public static void printTreePreorder(Node root) {
        if (root != null) {
            System.out.print(root.val+" ");
            printTreePreorder(root.left);
            printTreePreorder(root.right);
        }
    }

    public static void printTreeLastorder(Node root) {
        if (root != null) {
            printTreeLastorder(root.left);
            printTreeLastorder(root.right);
            System.out.print(root.val+" ");
        }
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
}
