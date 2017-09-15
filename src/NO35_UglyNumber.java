/**
 * 丑数，只包含因子2，3，5的数
 *
 * 求按从小到大的顺序的第1500个丑数
 *
 * 一般把1当做第一个丑数
 */
public class NO35_UglyNumber {
    public static void main(String[] args) {
        System.out.println(findUglyNumber(1)); // 1
        System.out.println(findUglyNumber(2)); // 2
        System.out.println(findUglyNumber(3)); // 3
        System.out.println(findUglyNumber(4)); // 4
        System.out.println(findUglyNumber(5)); // 5
        System.out.println(findUglyNumber(6)); // 6
        System.out.println(findUglyNumber(7)); // 8
        System.out.println(findUglyNumber(8)); // 9
        System.out.println(findUglyNumber(9)); // 10
        System.out.println(findUglyNumber(10)); // 12
        System.out.println(findUglyNumber(11)); // 15
        System.out.println(findUglyNumber(1500)); // 859963392
        System.out.println(findUglyNumber(0)); // 0
    }

    public static int findUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int nextUglyIndex = 1;
        int p2=0,p3=0,p5=0;
        while (nextUglyIndex < n) {
            int min = min(uglyNumbers[p2] * 2, uglyNumbers[p3] * 3,uglyNumbers[p5] * 5);
            uglyNumbers[nextUglyIndex] = min;
            while (uglyNumbers[p2] * 2 <= uglyNumbers[nextUglyIndex]) {
                p2++;
            }
            while (uglyNumbers[p3] * 3 <= uglyNumbers[nextUglyIndex]) {
                p3++;
            }
            while (uglyNumbers[p5] * 5 <= uglyNumbers[nextUglyIndex]) {
                p5++;
            }
            nextUglyIndex++;
        }
        return uglyNumbers[nextUglyIndex - 1];
    }

    private static int min (int n1, int n2, int n3) {
        int min = n1 < n2 ? n1 : n2;
        return min < n3 ? min : n3;
    }

    /**
     * 判断一个数是否只含有2，3，5因子
     * @param num
     * @return
     */
    public static boolean isUgly(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
