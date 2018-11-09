package string;

/**
 * @author zhiwj
 * @date 2018/11/9
 */
public class Palindrome {

    /*

  验证回文字符串
    给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

    说明：本题中，我们将空字符串定义为有效的回文串。

    示例 1:

    输入: "A man, a plan, a canal: Panama"
    输出: true
    示例 2:

    输入: "race a car"
    输出: false

     */
    public boolean isPalindrome(String s) {

        char[] arr = new char[s.length()];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp >= 65 && tmp <= 90) {
                tmp += 32;
                arr[index] = tmp;
                index++;
            } else if (tmp >= 97 && tmp <= 122) {
                arr[index] = tmp;
                index++;
            }
        }

        int left = 0;
        int right = index;

        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }


        return true;
    }

    public static void main(String[] args) {
        boolean f1 = new Palindrome().isPalindrome2("A man, a plan, a canal: Panama");
        boolean f2 = new Palindrome().isPalindrome2("race a car");
        System.out.println(f1);
        System.out.println(f2);
        boolean palindrome = new Palindrome().isPalindrome2("0P");
        System.out.println(palindrome);
    }

    public boolean isPalindrome2(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            if (leftChar >= 65 && leftChar <= 90) {
                leftChar += 32;
            } else if ((leftChar >= 97 && leftChar <= 122) || (leftChar >= 48 && leftChar <= 57)) {

            } else {
                left++;
                continue;
            }

            char rightChar = s.charAt(right);
            if (rightChar >= 65 && rightChar <= 90) {
                rightChar += 32;
            } else if ((rightChar >= 97 && rightChar <= 122) || (rightChar >= 48 && rightChar <= 57)) {
            } else {
                right--;
                continue;
            }

            if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
