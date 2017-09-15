import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 找到第一个只出现一次的字符
 *
 * hash表
 */
public class NO35_FindFirstNotRepeatingChar {

    public static void main(String[] args) {
        System.out.println(findFirstNotRepeatingChar("google")); // l
        System.out.println(findFirstNotRepeatingChar("aabccdbd")); // '\0'
        System.out.println(findFirstNotRepeatingChar("abcdefg")); // a
        System.out.println(findFirstNotRepeatingChar("gfedcba")); // g
        System.out.println(findFirstNotRepeatingChar("zgfedcba")); // z
    }

    public static char findFirstNotRepeatingChar(String str) {
        //校验
        if (str == null || str.length() < 1) {
            throw new IllegalArgumentException("invalid input");
        }

        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -1);
            } else {
                map.put(c, i);
            }
        }

        int idx = Integer.MAX_VALUE;
        char result = '\0';
        //遍历map取i最小的key
        for (Map.Entry<Character, Integer> entry:map.entrySet()) {
            if (entry.getValue() >= 0 && entry.getValue() < idx) {
                idx = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
