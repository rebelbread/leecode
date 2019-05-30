package Array;

/**
 * @author zhiwj
 * @date 2019/5/27
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeNum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new ThreeNum().threeSum(nums);
        System.out.println(lists);

    }

    // -4, -1, -1, 0, 1, 2
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return list;
        }
        if (nums[0] == 0 && 0 == nums[nums.length - 1]) {
            list.add(Arrays.asList(0, 0, 0));
            return list;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = nums.length - 1;
            int k = i + 1;
            int target = - nums[i];
            int sum;
            do {
                sum = nums[j] + nums[k];
                if (sum == target) {
                    list.add(Arrays.asList(nums[i], nums[k], nums[j]));
                    do {
                        k++;
                    } while (k < j && nums[k] == nums[k - 1]);
                    do {
                        j--;
                    } while (k < j && nums[j] == nums[j + 1]);
                } else if (sum < target) {
                    do {
                        k++;
                    } while (k < j && nums[k] == nums[k - 1]);
                } else if (sum > target) {
                    do {
                        j--;
                    } while (k < j && nums[j] == nums[j + 1]);
                }
            } while (k < j);
        }
        return list;
    }
}
