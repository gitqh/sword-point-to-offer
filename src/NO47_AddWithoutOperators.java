/**
 * 不用加减乘除做加法
 *
 * 实现一个函数，求两个整数之和，要求在函数体内不得使用+,-,*,/
 *
 * 位运算
 */
public class NO47_AddWithoutOperators {

    public static void main(String[] args) {
        System.out.println(add(1, 2) + ", " + (1 + 2));
        System.out.println(add(13, 34)+ ", " + (13 + 34));
        System.out.println(add(19, 85)+ ", " + (19 + 95));
        System.out.println(add(865, 245)+ ", " + (865 + 245));
    }

    public static int add(int x, int y) {
        int sum, carry;
        do {
            //按位异或得到非进位结果
            sum = x^y;
            //x&y的某一位是1说明，它是它前一位的进位，所以向左移动一位
            carry = (x & y) << 1;
            x = sum;
            y = carry;
        } while (y != 0);
        return x;
    }
}
