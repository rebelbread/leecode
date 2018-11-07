package Array;

import java.util.Arrays;

/**
 * @author zhiwj
 * @date 2018/11/7
 */
public class PlusOne {
    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 示例 2:
     * <p>
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     */
    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        int[] result = new PlusOne().plusOne(digits);
        System.out.println(Arrays.toString(result));

    }

    public int[] plusOne(int[] digits) {
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        if (digits[digits.length - 1] == 10) {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] == 10 && i >= 1) {
                        digits[i] = 0;
                        digits[i - 1] = digits[i - 1] + 1;
                }
            }
        }

        if (digits[0] == 10) {
            int[] tmp = new int[digits.length + 1];
            tmp[0] = 1;
            digits = tmp;
        }

        return digits;
    }


}
