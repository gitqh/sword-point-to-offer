/**
 * 计算二进制中1的个数
 */
public class NO10_ComputeNumOf1WithBinary {

    public static void main(String[] args) {
        System.out.println(numberOfOne(5));
        System.out.println(numberOfOne(0));
        System.out.println(numberOfOne(0xffffffff));

        System.out.println(is2Power(5));
        System.out.println(is2Power(8));

        System.out.println(numberOfChanges(10,13));
    }

    public static int numberOfOne(int n) {
        int count = 0;
        while (n!=0) {
            count++;
            n=n&(n-1);
        }
        return count;
    }

    //判断是否是2的整数次幂
    public static boolean is2Power(int n) {
        return (n&(n-1))==0;
    }

    //输入两个整数m和n，计算需要改变m的二进制表示中的多少位才能得到n
    public static int numberOfChanges(int m, int n) {
        int tmp = m^n;
        return numberOfOne(tmp);
    }
}
