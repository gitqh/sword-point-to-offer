/**
 * 数字在排序数组中出现的次数
 *
 * 思路：
 * 递归
 * 1.寻找数字出现的第一次
 * 2.寻找数字出现的最后一次
 * 3.求差值
 */
public class NO38_CountsOfNumberInOrderArray {

    public static void main(String[] args) {
        // 查找的数字出现在数组的中间
        int[] data1 = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(countsOfNumber(data1, 3)); // 4
        // 查找的数组出现在数组的开头
        int[] data2 = {3, 3, 3, 3, 4, 5};
        System.out.println(countsOfNumber(data2, 3)); // 4
        // 查找的数组出现在数组的结尾
        int[] data3 = {1, 2, 3, 3, 3, 3};
        System.out.println(countsOfNumber(data3, 3)); // 4
        // 查找的数字不存在
        int[] data4 = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(countsOfNumber(data4, 2)); // 0
        // 查找的数字比第一个数字还小，不存在
        int[] data5 = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(countsOfNumber(data5, 0)); // 0
        // 查找的数字比最后一个数字还大，不存在
        int[] data6 = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(countsOfNumber(data6, 0)); // 0
        // 数组中的数字从头到尾都是查找的数字
        int[] data7 = {3, 3, 3, 3};
        System.out.println(countsOfNumber(data7, 3)); // 4
        // 数组中的数字从头到尾只有一个重复的数字，不是查找的数字
        int[] data8 = {3, 3, 3, 3};
        System.out.println(countsOfNumber(data8, 4)); // 0
        // 数组中只有一个数字，是查找的数字
        int[] data9 = {3};
        System.out.println(countsOfNumber(data9, 3)); // 1
        // 数组中只有一个数字，不是查找的数字
        int[] data10 = {3};
        System.out.println(countsOfNumber(data10, 4)); // 0
    }

    public static int countsOfNumber(int[] arr, int n) {
        if (arr == null || arr.length ==0) {
            return 0;
        }
        int counts = 0;
        int first = GetFirstN(arr, n, 0, arr.length - 1);
        int last = GetLastN(arr, n, 0, arr.length - 1);
        if (first > -1 && last > -1) {
            counts = last - first + 1;
        }
        return counts;
    }

    private static int GetFirstN(int[] arr, int n, int start, int end) {
        if (start > end ) {
            return -1;
        }
        int middle = start + (end - start) / 2;
        int middleN = arr[middle];
        if (middleN == n) {
            if ((middle > 0 && arr[middle - 1] != n)
                    || middle == 0 ) {
                return middle;
            } else {
                end = middleN - 1;
            }
        } else if (middleN > n) {
            end = middle - 1;
        } else {
            start = middle + 1;
        }
        return GetFirstN(arr, n, start, end);
    }


    private static int GetLastN(int[] arr, int n, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middle = start + (end - start) / 2;
        int middleN = arr[middle];
        if (middleN == n) {
            if ((middle < arr.length-1 && arr[middle + 1] != n)
                    || middle == arr.length - 1 ) {
                return middle;
            } else {
                start = middle + 1;
            }
        } else if (middleN > n) {
            end = middle - 1;
        } else {
            start = middle + 1;
        }
        return GetLastN(arr, n, start ,end);
    }

}
