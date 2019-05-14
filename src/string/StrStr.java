package string;

/**
 * @author zhiwj
 * @date 2019/5/14
 */
public class StrStr {

    /**
     * 实现 strStr() 函数。
     * <p>
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * <p>
     * 示例 1:
     * <p>
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * 说明:
     * <p>
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * <p>
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     */
    public static void main(String[] args) throws InterruptedException {
        StrStr strStr = new StrStr();
        String haystack = "aaaaa";
        String needle = "bba";
        System.out.println(strStr.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        char first = needle.charAt(0);
        int max = haystack.length() - needle.length();
        for (int i = 0; i <= max; ) {
            for (;i < haystack.length() && haystack.charAt(i) != first ; i++) ;
            if (max < i) {
                return -1;
            }
            int end = i + needle.length();
            int j = i + 1;
            for (int k = 1; j < end && haystack.charAt(j) == needle.charAt(k); j++, k++) ;
            if (end == j) {
                return i;
            }
            i++;
        }
        return -1;
    }


    public int indexOf(char[] source, char[] target) {
        char first = target[0];
        int max = (source.length - target.length);

        for (int i = 0; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first) ;
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + target.length - 1;
                for (int k = 1; j < end && source[j] == target[k]; j++, k++) ;

                if (j == end) {
                    /* Found whole string. */
                    return i;
                }
            }
        }
        return -1;
    }


}