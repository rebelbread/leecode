package Array;

import java.util.Arrays;

/**
 * @author zhiwj
 * @date 2018/7/24
 */
public class TwoSum {
    /**
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     *
     * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        int target = 6;

        int[] ints = new TwoSum().twoSumBetter2(nums, target);
        System.out.println(Arrays.toString(ints));

    }

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 更好的解法
     */

    public int[] twoSumBetter(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2) {
            return res;
        }

        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        // 这个数组的索引 记录原数组减去min值的值，值记录原数组的索引+1
        int[] index = new int[max - min + 1];
        int other =0;
        for (int i = 0; i < nums.length; i++) {
            other = target - nums[i];
            if(other < min || other > max) {
                // 另一个数如果不在这个数组的数字范围里
                continue;
            }
            if(index[other- min] > 0) {
                res[0] = index[other -min ]-1;
                res[1] = i;
                return res;
            }

            index[nums[i] - min] = i+1;
        }
        return res;
    }

    public int[] twoSumBetter2(int[] nums, int target) {

        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        int[] indexArr = new int[max - min + 1];
        int other = 0;
        for (int i = 0; i < nums.length; i++) {
            other = target - nums[i];
            if (other < min || other > max) {
                continue;
            }
            if (indexArr[other - min] > 0) {
                int[] res = new int[2];
                res[0] = indexArr[other - min] - 1;
                res[1] = i;
                return res;
            }

            indexArr[nums[i] - min] = i + 1;
        }

        return null;
    }

}
