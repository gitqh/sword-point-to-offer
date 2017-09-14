import java.util.stream.IntStream;


/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class NO14_ReorderOddEven {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        reorderOddEven(array);
        printArray(array);
    }

    public static void reorderOddEven(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            //寻找偶数
            while (start < end && !isEven(arr[start])) {
                start++;
            }
            //寻找奇数
            while (start < end && (isEven(arr[end]))) {
                end--;
            }
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
        }
    }

    public static boolean isEven(int n) {
        return (n & 0x01) == 0;
    }

    public static void printArray(int[] array) {
        IntStream.of(array).forEach(System.out::print);
    }
}
