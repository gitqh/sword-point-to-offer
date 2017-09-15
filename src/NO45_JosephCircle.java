import java.util.LinkedList;
import java.util.List;

/**
 * 圆圈中最后剩下的数字（约瑟夫环问题）
 *
 * 0,1,2,...,n-1这n个数字排成一个圆圈，从数字0开始
 * 每次从圆圈里删除第m个数字，求出剩下的最后一个数字
 *
 * 思路：
 * 1.环形链表
 * 2.循环
 */
public class NO45_JosephCircle {

    public static void main(String[] args) {
        System.out.println(LastRemaining(5, 3)); // 最后余下3
        System.out.println(LastRemaining(5, 2)); // 最后余下2
        System.out.println(LastRemaining(6, 7)); // 最后余下4
        System.out.println(LastRemaining(6, 6)); // 最后余下3
        System.out.println(LastRemaining(0, 0)); // 最后余下-1
    }


    //环形链表
    public static int lastRemaingWithList(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (list.size() > 1) {
            //移动m-1次可以移动到下一个要删除的元素上
            //linkiedlist是双向链表
            for (int i = 1; i < m; i++) {
                idx = (idx + 1)%list.size();
            }
            list.remove(idx);
        }
        return list.get(0);
    }

    //循环
    public static int LastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}

