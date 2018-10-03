package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author zhiwj
 */
public class Intersect2 {
    /*
     两个数组的交集 II
给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2,2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [4,9]
说明：

输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
我们可以不考虑输出结果的顺序。
进阶:

如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小很多，哪种方法更优？
如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     */
    public static void main(String[] args) {
        int[] ints = new Intersect2().intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        System.out.println(Arrays.toString(ints));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            Integer integer = map.get(nums1[i]);
            map.put(nums1[i], integer == null ? 1 : (integer + 1));
        }
        ArrayList<Integer> list = new ArrayList<>(nums1.length > nums2.length ? nums1.length : nums2.length);
        for (int num : nums2) {
            Integer integer = map.get(num);
            if (integer != null && integer > 0) {
                map.put(num, --integer);
                list.add(num);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }


/*    public int[] intersectBetter(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] arr = new int[nums1.length > nums2.length ? nums1.length : nums2.length];
        for (int num : nums1) {
            arr[num] += 1;
        }
        for (int num : nums1) {
            arr[num] += 1;
        }


    }*/

}
