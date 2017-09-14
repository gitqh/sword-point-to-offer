import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * 树的子结构
 * 输入两颗二叉树A与B，判断B是不是A的子结构
 *
 * 递归遍历二叉树A
 */
public class NO18_HasSubTree {

    public static void main(String[] args) {
        Node root1 = new Node();
        root1.val = 8;
        root1.right = new Node();
        root1.right.val = 7;
        root1.left = new Node();
        root1.left.val = 8;
        root1.left.left = new Node();
        root1.left.left.val = 9;
        root1.left.right = new Node();
        root1.left.right.val = 2;
        root1.left.right.left = new Node();
        root1.left.right.left.left = new Node();
        root1.left.right.left.left.val = 4;
        root1.left.right.left.right = new Node();
        root1.left.right.left.right.val = 7;
        Node root2 = new Node();
        root2.val = 8;
        root2.left = new Node();
        root2.left.val = 9;
        root2.right = new Node();
        root2.right.val = 2;
        System.out.println(hasSubTree(root1, root2));
        System.out.println(hasSubTree(root2, root1));
        System.out.println(hasSubTree(root1, root1.left));
        System.out.println(hasSubTree(root1, null));
        System.out.println(hasSubTree(null, root2));
        System.out.println(hasSubTree(null, null));
    }

    /**
     * 在a树中找到一个与b树的根节点相等的元素的节点
     * 从这个节点开始判断树b是否为树a的子结构
     * @param a
     * @param b
     * @return
     */
    public static boolean hasSubTree(Node a, Node b) {
        boolean result = false;
        if (a == b) {
            return true;
        }
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (a.val == b.val) {
            result = DoesTree1HaveTree2(a, b);
        }
        if (result) {
            return result;
        }
        return hasSubTree(a.left, b) || hasSubTree(a.right, b);
    }

    /**
     * 从树a根节点root1和b根节点root2开始，一个一个元素进行判断
     * 判断b是否为a的子结构
     * @param a
     * @param b
     * @return
     */
    private static boolean DoesTree1HaveTree2(Node a, Node b) {
        if (a == b) {
            return true;
        }
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (a.val == b.val) {
            return DoesTree1HaveTree2(a.left, b.left) &&
                    DoesTree1HaveTree2(a.right, b.right);
        }
        return false;
    }

    static class Node {
        int val;
        Node left;
        Node right;
    }
}
