/**
 * 输入数组，判断该数组是否为某二叉搜索树的后序遍历结果
 *
 * 递归
 */
public class NO24_IterateBinarySearchTree {

    public static void main(String[] args) {
        //           10
        //         /   \
        //        6     14
        //       /\     /\
        //      4  8  12  16
        int[] data = {4, 8, 6, 12, 16, 14, 10};
        System.out.println("true: " + verifySquenceOfBST(data, data.length));
        //           5
        //          / \
        //         4   7
        //            /
        //           6
        int[] data2 = {4, 6, 7, 5};
        System.out.println("true: " + verifySquenceOfBST(data2,data2.length));
        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        int[] data3 = {1, 2, 3, 4, 5};
        System.out.println("true: " + verifySquenceOfBST(data3,data3.length));
        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        int[] data4 = {5, 4, 3, 2, 1};
        System.out.println("true: " + verifySquenceOfBST(data4,data4.length));
        // 树中只有1个结点
        int[] data5 = {5};
        System.out.println("true: " + verifySquenceOfBST(data5,data5.length));
        int[] data6 = {7, 4, 6, 5};
        System.out.println("false: " + verifySquenceOfBST(data6,data6.length));
        int[] data7 = {4, 6, 12, 8, 16, 14, 10};
        System.out.println("false: " + verifySquenceOfBST(data7,data7.length));
    }

    public static boolean verifySquenceOfBST(int[] sequence, int length) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }

        int root = sequence[sequence.length - 1];
        //在二叉搜索树中左子树的节点小于根节点
        int i = 0;
        for (;i< length - 1;i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        //在二叉搜索树中右子树的节点大于根节点
        int j = i;
        for (;j< length - 1;j++) {
            if (sequence[j] < root)
                return false;
        }
        boolean left = true;
        if (i > 0)
            left = verifySquenceOfBST(sequence,i);
        boolean right = true;
        if (i < length - 1)
            right = verifySquenceOfBST(sequence, length - i - 1);
        return left&&right;
    }
}
