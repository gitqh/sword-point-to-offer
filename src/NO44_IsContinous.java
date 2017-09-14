import java.util.Arrays;

/**
 * 从扑克牌中随机抽 5 张牌，判断是不是一个顺子， 即这 5 张牌是不是连续的。2～10 为数字本身，
 * A 为 1。J 为 11、Q 为 12、 为 13。小王可以看成任意数字
 *
 * 排序后统计数组中0的个数，然后统计数组中相邻数字的空缺总数，
 * 如果空缺总数小于等于0的个数，数组是连续的
 *
 * 如果非0数字重复出现，则数组是不连续的
 */
public class NO44_IsContinous {

    public static void main(String[] args) {
        int[] numbers1 = {1, 3, 2, 5, 4};
        System.out.println(isContinous(numbers1));
        int[] numbers2 = {1, 3, 2, 6, 4};
        System.out.println(isContinous(numbers2));
        int[] numbers3 = {0, 3, 2, 6, 4};
        System.out.println(isContinous(numbers3));
        int[] numbers4 = {0, 3, 1, 6, 4};
        System.out.println(isContinous(numbers4));
        int[] numbers5 = {1, 3, 0, 5, 0};
        System.out.println(isContinous(numbers5));
        int[] numbers6 = {1, 3, 0, 7, 0};
        System.out.println(isContinous(numbers6));
        int[] numbers7 = {1, 0, 0, 5, 0};
        System.out.println(isContinous(numbers7));
        int[] numbers8 = {1, 0, 0, 7, 0};
        System.out.println(isContinous(numbers8));
        int[] numbers9 = {3, 0, 0, 0, 0};
        System.out.println(isContinous(numbers9));
        int[] numbers10 = {0, 0, 0, 0, 0};
        System.out.println(isContinous(numbers10));
        int[] numbers11 = {1, 0, 0, 1, 0};
        System.out.println(isContinous(numbers11));
    }

    public static boolean isContinous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }

        Arrays.sort(numbers);
        int numberOfZero = 0;
        for (int i = 0; i<numbers.length && numbers[i] == 0; i++) {
            numberOfZero++;
        }
        int numberOfGap = 0;
        int small = numberOfZero;
        int big = small + 1;
        while (big < numbers.length) {
            if (numbers[small] == numbers[big]) {
                return false;
            }
            numberOfGap += (numbers[big] - numbers[small] - 1);
            small = big;
            big++;
        }
        return numberOfGap <= numberOfZero;
    }


}
