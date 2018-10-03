package Array;

import java.util.Arrays;

/**
 * @author zhiwj
 */
public class SingleNumber {
    /*
      只出现一次的数字
        给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

        说明：

        你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

        示例 1:

        输入: [2,2,1]
        输出: 1
        示例 2:

        输入: [4,1,2,1,2]
        输出: 4
     */
    public static void main(String[] args) {

        System.out.println(new SingleNumber().singleNumber(new int[]{1}));
//        System.out.println(new SingleNumber().singleNumber(nums2));
    }

    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && i != nums.length - 1) {
                if ((nums[i] != nums[i + 1]) && ((nums[i] != nums[i - 1]))) {
                    return nums[i];
                }
            } else if (i == 0 && (nums[i] != nums[i + 1])) {
                return nums[i];
            }

            if (i == nums.length - 1 && (nums[i] != nums[i - 1])) {
                return nums[i];
            }

        }
        return -1;
    }

    public int singleNumberBetter(int[] nums) {
        // 使用了亦或
        int i = 0;
        for (int num : nums) {
            i ^= num;
        }
        return i;
    }

}
