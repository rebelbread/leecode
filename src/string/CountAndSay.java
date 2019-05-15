package string;

/**
 * @author zhiwj
 * @date 2019/5/15
 */

/**
 * 报数
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 */
public class CountAndSay {

    public static void main(String[] args) {
//        System.out.println(new CountAndSay().next("1"));
        System.out.println(new CountAndSay().next("11"));
        System.out.println(new CountAndSay().next("21"));
        System.out.println(new CountAndSay().next("1211"));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String next = "1";
        for (int i = 0; i < n - 1; i++) {
            next = next(next);
        }
        return next;
    }

    // 1211
    public String next(String next) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < next.length(); ) {
            int j = i + 1;
            for (; j < next.length() && next.charAt(j) != next.charAt(i); j++) ;

            sb.append(j - i + 1).append(next.charAt(i));
            if (j >= next.length() -1) {
                return sb.toString();
            }
            i = j;
        }
        return sb.toString();
    }

}
