/**
 * 翻转单词顺序 vs 左旋转字符串
 *
 * I am a student.
 *
 * 输出： student. a am I
 */
public class NO42_ReverseSequence {
    public static void main(String[] args) {
        System.out.println(reverseSequence("I am a student.".toCharArray()));
    }

    public static char[] reverseSequence(char[] data) {
        if (data == null || data.length == 0 ){
            return null;
        }
        reverse(data,0,data.length-1);
        int start = 0;
        int end = 0;
        while (start < data.length) {
            if (data[start] == ' ') {
                start++;
                end++;
            } else if (end == data.length || data[end] == ' ') {
                reverse(data, start, end - 1);
                end++;
                start = end;
            } else {
                end++;
            }
        }
        return data;
    }

    public static char[] reverse(char[] data, int start, int end) {
        if (data == null || data.length == 0 || start < 0 || end > data.length
                || start > end){
            return null;
        }
        while (start < end) {
            char tmp = data[start];
            data[start] = data[end];
            data[end] = tmp;
            start++;
            end--;
        }
        return data;
    }
}
