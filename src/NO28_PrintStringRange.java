import com.sun.org.apache.xpath.internal.operations.String;

/**
 * 打印字符串的全排列
 *
 * 输入abc
 *
 * 打印abc,acb,bac,bca,cab,cba
 */
public class NO28_PrintStringRange {

    public static void main(String[] args) {
        char[] c1 = {'a', 'b', 'c'};
        printRange(c1);
        System.out.println();
        char[] c2 = {'a', 'b', 'c', 'd'};
        printRange(c2);
    }

    public static void printRange(char[] data) {
        if (data == null || data.length == 0) {
            return;
        }
        printRange(data, 0);
    }

    private static void printRange(char[] data, int begin) {
        if (data.length - 1 == begin) {
            System.out.println(data.toString() +" ");
        } else {
            char tmp;
            for (int i = begin; i < data.length; i++) {
                tmp = data[begin];
                data[begin] = data[i];
                data[i] = tmp;
                printRange(data, begin + 1);
            }
        }
    }
}
