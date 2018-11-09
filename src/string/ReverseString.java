package string;

/**
 * @author zhiwj
 * @date 2018/11/9
 */
public class ReverseString {

    /**
     * 反转字符串
     * 编写一个函数，其作用是将输入的字符串反转过来。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "hello"
     * 输出: "olleh"
     * 示例 2:
     * <p>
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: "amanaP :lanac a ,nalp a ,nam A"
     */

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new ReverseString().reverseString(s));

    }

    public String reverseString(String s) {
//        return new StringBuilder(s).reverse().toString();
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {

            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;

            left++;
            right--;
        }
        return new String(chars);
    }

}
