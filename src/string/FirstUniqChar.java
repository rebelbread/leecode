package string;

/**
 * @author zhiwj
 * @date 2018/11/13
 */
public class FirstUniqChar {

    /**
     * 字符串中的第一个唯一字符
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * <p>
     * 案例:
     * <p>
     * s = "leetcode"
     * 返回 0.
     * <p>
     * s = "loveleetcode",
     * 返回 2.
     * <p>
     * <p>
     * 注意事项：您可以假定该字符串只包含小写字母。
     */
    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "aadadaad";
        int i1 = new FirstUniqChar().firstUniqChar(s1);
        System.out.println(i1);
        int i2 = new FirstUniqChar().firstUniqChar(s2);
        System.out.println(i2);
        int i3 = new FirstUniqChar().firstUniqChar(s3);
        System.out.println(i3);

    }

    public int firstUniqChar(String s) {
        int size = 'z' - 'a' + 1;
        int[] arr = new int[size];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (arr[c - 'a'] != 0) {
                arr[c - 'a'] = -1;
            } else {
                arr[c - 'a'] = i + 1;
            }
        }
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > 0) {
                if (arr[i] < min) {
                    min = arr[i];
                } else if (arr[i] > 0 && min <= 0) {
                    min = arr[i];
                }
            }
        }
        return min > 0 ? min - 1 : -1;
    }

    public int firstUniqChar2(String s) {
        int res = -1;

        for(char ch='a'; ch<='z'; ch++) {
            int index = s.indexOf(ch);
            if(index != -1 && index == s.lastIndexOf(ch)) {
                res = res == -1?index:Math.min(res, index);
            }
        }

        return res;
    }
}
