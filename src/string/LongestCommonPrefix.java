package string;

/**
 * @author zhiwj
 * @date 2019/5/16
 */

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {


    public static void main(String[] args) {
        LongestCommonPrefix commonPrefix = new LongestCommonPrefix();
        String s = commonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        System.out.println("fl".equals(s));
        String s1 = commonPrefix.longestCommonPrefix(new String[]{"dog", "racecar", "car"});
        System.out.println("".equals(s1));
        String s2 = commonPrefix.longestCommonPrefix(new String[]{"aa", "a"});
        System.out.println("a".equals(s2));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1 || "".equals(strs[0])) {
            return strs[0];
        }
        char[] sb = strs[0].toCharArray();
        int l = sb.length;
        for (int j = 1; j < strs.length; j++) {
            if ("".equals(strs[j]) || sb[0] == 0) {
                return "";
            }
            for (int i = 0; i < l ; i++) {
                if (i == strs[j].length() || sb[i] != strs[j].charAt(i)) {
                    sb[i] = 0;
                    l = i;
                }
                if (i == strs[j].length()) {
                    break;
                }
            }
        }
        return new String(sb, 0, l);
    }

}
