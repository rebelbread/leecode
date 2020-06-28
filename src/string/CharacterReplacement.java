package string;

/**
 * 替换后的最长重复字符
 *给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。

 注意:
 字符串长度 和 k 不会超过 104。

 示例 1:

 输入:
 s = "ABAB", k = 2

 输出:
 4

 解释:
 用两个'A'替换为两个'B',反之亦然。
 示例 2:

 输入:
 s = "AABABBA", k = 1

 输出:
 4

 解释:
 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 子串 "BBBB" 有最长重复字母, 答案为 4。
 * @Description:
 * @author zhiwj
 * @date 2019-09-30 16:31
 */
public class CharacterReplacement {

    public static void main(String[] args) {
        int i = new CharacterReplacement().characterReplacement("ABAB", 2);
        System.out.println(i);
    }

    public int characterReplacement(String s, int k) {
        if (s.length() < 1)
            return 0;
        int start = 0;
        int end = 0;
        int res = 0;
        int[] charNum = new int[26];
        charNum[s.charAt(0) - 'A']++;
        while (s.length() > end) {
             int maxChar = 0;
             for (int i = 0; i < 26; i++) {
                 if (charNum[i] > maxChar)
                     maxChar = charNum[i];
             }
             if (maxChar + k > end - start) {
                 end++;
                 if (end < s.length())
                     charNum[s.charAt(end) - 'A']++;
             } else {
                 charNum[s.charAt(start) - 'A']--;
                 start++;
             }
             if (maxChar + k > res)
                 res = maxChar + k <= s.length() ? maxChar + k : s.length();
        }
        return res;
    }

}
