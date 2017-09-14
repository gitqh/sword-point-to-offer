/**
 *
 * 旋转数组的最小数字
 * 数组已排序
 * {3,4,5,1,2}
 * 二分查找法
 * 考虑元素相等的情况
 * 移动下标，寻找两个子数组中较小的一个
 *
 */
public class NO8_MinNumOfRotateArray {

    public static void main(String[] args) {
        System.out.println(min(new int[]{3,4,5,1,2}));
        System.out.println(min(new int[]{1,2,3,4,5}));
        System.out.println(min(new int[]{1,0,1,1,1}));
        System.out.println(min(new int[]{1,0}));
        System.out.println(min(new int[]{0,1}));
        System.out.println(min(null));
        System.out.println(min(new int[]{}));
    }

    public static int min(int[] numbers) {
        //判断输入是否合法
        if (numbers == null || numbers.length ==0 ) {
            throw new RuntimeException("Invalid input");
        }

        //开始处理的第一个位置
        int i= 0;
        //开始处理的最后一个位置
        int j = numbers.length - 1;
        //设置初始值
        int m = i;
        //确保i在前一个排好序的子数组，j在后一个排好序的子数组
        while (numbers[i] >= numbers[j]) {
            if (j-i==1) {
                return numbers[j];
            }
            m = (j+i)/2;
            //如果三个数相等，需要顺序处理，从头到尾找最小值
            if (numbers[m] == numbers[i] && numbers[m] == numbers[j]) {
                return minInorder(numbers, i, j);
            }
            //如果中间位置对应的值在前一个排好序的子数组，将i设置为新的处理位置
            if (numbers[m] >= numbers[i]) {
                i = m;
            } else {
                j = m;
            }
        }
        return numbers[m];
    }

    /**
     * 找数组中最小值
     * @param numbers
     * @param start
     * @param end
     * @return
     */
    public static int minInorder(int[] numbers, int start, int end) {
        int result = numbers[start];
        for (int i= start + 1; i<=end;i++) {
            if (result > numbers[i]) {
                result = numbers[i];
            }
        }
        return result;
    }
}
