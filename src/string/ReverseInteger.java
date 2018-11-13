package string;

/**
 * @author zhiwj
 * @date 2018/11/13
 */
public class ReverseInteger {
    /**
     * 给定一个 32 位有符号整数，将整数中的数字进行反转。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 123
     * 输出: 321
     * 示例 2:
     * <p>
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * <p>
     * 输入: 120
     * 输出: 21
     * 注意:
     * <p>
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
     */
    public static void main(String[] args) {
//        int r1 = new ReverseInteger().reverse(123);
//        System.out.println(r1);
//        int r2 = new ReverseInteger().reverse(-123);
//        System.out.println(r2);
//        int r3 = new ReverseInteger().reverse(120);
//        System.out.println(r3);
        int r3 = new ReverseInteger().reverse(1534236469);
        System.out.println(r3);
    }

    public int reverse(int x) {
        int i;
        long result = 0;
        do {
            i = x % 10;
            x = x / 10;
            result = result * 10 + i;
        } while (x != 0);

        double max = Math.pow(2, 31);
        if (result >= max || result < -max) {
            return 0;
        }
        return (int) result;
    }




}
