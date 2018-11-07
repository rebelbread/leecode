package Array;

import java.util.Arrays;

/**
 * @author zhiwj
 * @date 2018/11/7
 */
public class MoveZeroes {
    /**
     * 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     * <p>
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     */

    public static void main(String[] args) {
//        int[] nums = {1, 0, 0};
        int[] nums = {0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroesBetter(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        // i指向0  j指向非0
        for (int i = 0, j = 0; i < nums.length - 1 && j < nums.length - 1; ) {
            while (i < nums.length && nums[i] != 0) {
                i++;
            }
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
            if (i < nums.length && j < nums.length) {
                if (i < j) {
                    swap(nums, i, j);
                } else {
                    j = i;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void moveZeroesBetter(int[] nums) {
        // i指向非0  j指向0
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }


}
