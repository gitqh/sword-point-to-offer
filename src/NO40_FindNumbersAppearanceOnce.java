/**
 * 寻找数组中只出现一次的数字
 *
 * 一个整形数组中除了两个数字之外，其他数字都出现了两次
 * 写程序找出这两个出现一次的数字，时间复杂度O(n)，空间复杂度O(1)
 *
 * 思路：先对整个数组异或，得到这两个数字的异或值，
 * 然后从右边找到第一位值为1，所对应的位数，通过该位数是否为1来对整个数组分组，
 * 分为两组，每个子数组内进行异或，可以得到对应的两个数字
 */
public class NO40_FindNumbersAppearanceOnce {

    public static void main(String[] args) {
        int[] data1 = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] result1 = findNumbersAppearanceOnce(data1);
        System.out.println(result1[0] + " " + result1[1]);
        int[] data2 = {4, 6};
        int[] result2 = findNumbersAppearanceOnce(data2);
        System.out.println(result2[0] + " " + result2[1]);
        int[] data3 = {4, 6, 1, 1, 1, 1};
        int[] result3 = findNumbersAppearanceOnce(data3);
        System.out.println(result3[0] + " " + result3[1]);
    }

    private static int[] findNumbersAppearanceOnce(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int xor = arr[0];
        for (int i=1;i<arr.length;i++) {
            xor ^= arr[i];
        }
        int index = bitOfOne(xor);
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isBit1(arr[i], index)) {
                num1^=arr[i];
            } else {
                num2^=arr[i];
            }
        }
        return new int[]{num1, num2};
    }

    private static int bitOfOne(int num) {
        int count = 0;
        while ((num & 0x01) ==0) {
            num = num>>1;
            count++;
        }
        return count;
    }

    private static boolean isBit1(int num, int indexBit) {
        return ((num>>indexBit) & 0x01) == 1;
    }
}
