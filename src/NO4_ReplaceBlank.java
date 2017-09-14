import java.util.Arrays;

/**
 *
 * 请实现一个函数，把字符串中每个空格替换成"%20"
 * 例如：
 * 输入：we are happy
 * 输出：we%20are%20happy
 *
 * 思路：
 * 1.传统思路: 找到一个空格后，移动该空格后的O(n)个字符，时间复杂度O(n*n)
 * 2.解题思路: 需要实现O(n)算法，尾部向前查找，找到一个空格，长度+2
 *
 */
public class NO4_ReplaceBlank {

    public static void main(String[] args) {
        System.out.println(replaceBlank("we are happy"));
        System.out.println(replaceBlank(" we"));
        System.out.println(replaceBlank(null));
    }

    public static String replaceBlank(String input) {
        //检查输入
        if (input == null) {
            return null;
        }
        char[] str = input.toCharArray();
        int usedLength = str.length;

        int blankCount = 0;
        for (char aStr : str) {
            if (aStr == ' ') {
                blankCount++;
            }
        }

        //计算转换后的字符长度
        if (blankCount == 0) {
            return input;
        }
        int targetLength = usedLength + blankCount*2;
        char[] res = new char[targetLength];
        //从后向前处理
        usedLength--;
        targetLength--;
        while (usedLength >= 0 && usedLength < targetLength) {
            if (str[usedLength] == ' ') {
                res[targetLength--] = '0';
                res[targetLength--] = '2';
                res[targetLength--] = '%';
            } else {
                res[targetLength--] = str[usedLength];
            }
            usedLength--;
        }
        return new String(res);
    }
}
