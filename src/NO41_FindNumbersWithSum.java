import javafx.beans.binding.ListBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，
 * 得到他们的和s，如果有多对数字和为s，输出任意一堆即可
 */
public class NO41_FindNumbersWithSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,7,11,15};
        IntStream.of(findNumbersWithSum(arr,15)).forEach(System.out::println);
        System.out.println();
        List<List<Integer>> resultList = findContinousSequence(15);
        for (List list: resultList) {
            list.stream().forEach(System.out::println);
            System.out.println();
        }
    }

    public static int[] findNumbersWithSum(int[] arr, int sum) {
        //检查输入
        if (arr == null || arr.length == 0) {
            return null;
        }
        int start = 0;
        int end = arr.length - 1;
        int tempSum = 0;
        while (start < end) {
            tempSum = arr[start] + arr[end];
            if (tempSum < sum) {
               start++;
            } else if (tempSum == sum) {
                return new int[] {arr[start], arr[end]};
            } else {
                end--;
            }
        }
        return null;
    }

    /**
     * 输入一个正数，打印出所有和为s的连续整数序列（至少两个数）
     */
    public static List<List<Integer>> findContinousSequence(int sum) {
        if (sum < 2) {
            return null;
        }
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        int small = 1;
        int big = 2;
        int middle = (1+sum) / 2;
        int curSum = small + big;
        while (small < middle) {
            if (curSum == sum) {
                List<Integer> list = new ArrayList<>();
                for (int i= small; i<=big; i++) {
                    list.add(i);
                }
                resultList.add(list);
            }
            while (curSum > sum && small < middle) {
                curSum-=small;
                small++;
                if (curSum == sum) {
                    List<Integer> list = new ArrayList<>();
                    for (int i= small; i<=big; i++) {
                        list.add(i);
                    }
                    resultList.add(list);
                }
            }
            big++;
            curSum+=big;
        }
        return resultList;
    }
}
