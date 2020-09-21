package string;

/**
 * @author zhiwj
 * @Description:
 * @date 2020-09-21 16:40
 */
public class LengthOfLongestSubstring {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     */

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    private static int lengthOfLongestSubstring(String str) {
        char[] arr = str.toCharArray();
        if (arr.length == 0) {
            return 0;
        }
        int i = 0, j = 1;
        int max=1;
        while (j < arr.length) {
            int index = repeat(arr, i, j);
            if (repeat(arr, i, j) >= 0) {
                i = index + 1;
            }
            j++;
            int length = j - i;
            if (length >= max) {
                max = length;
            }
        }
        return max;
    }

    private static int repeat(char[] arr, int i, int j) {
        for (int k = i; k < j; k++) {
            if (arr[j] == arr[k]) {
                return k;
            }
        }
        return -1;
    }

}