package Array;

import java.util.Arrays;

/**
 * @author zhiwj
 * @date 2018/7/24
 */
public class MedianOfTwoSortedArrays {
    /**
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
     *
     * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
     *
     * 示例 1:
     *
     * nums1 = [1, 3]
     * nums2 = [2]
     *
     * 中位数是 2.0
     * 示例 2:
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     *
     * 中位数是 (2 + 3)/2 = 2.5
     */


    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double mid = new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2);
        System.out.println(mid);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double[] total = new double[nums1.length + nums2.length];

        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < nums1.length + nums2.length; i++) {
            if (p1 < nums1.length && p2 < nums2.length) {
                if (nums1[p1] < nums2[p2]) {
                    total[i] = nums1[p1];
                    p1++;
                } else {
                    total[i] = nums2[p2];
                    p2++;
                }
            } else if(p1 < nums1.length){
                total[i] = nums1[p1];
                p1++;
            } else if (p2 < nums2.length) {
                total[i] = nums2[p2];
                p2++;
            }
        }
        System.out.println(Arrays.toString(total));
        double mid = 0;
        if (total.length % 2 == 1) {
            mid = total[total.length / 2];
        } else {
            mid = (total[total.length / 2] + total[(total.length / 2) - 1])/2;
        }

        return mid;
    }

    public double findMedianSortedArraysBetter(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, left = (m + n + 1) / 2, right = (m + n + 2) / 2;
        return (findKth(nums1, nums2, left) + findKth(nums1, nums2, right)) / 2.0;
    }
    int findKth(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        if (m > n) return findKth(nums2, nums1, k);
        if (m == 0) return nums2[k - 1];
        if (k == 1) return Math.min(nums1[0], nums2[0]);
        int i = Math.min(m, k / 2), j = Math.min(n, k / 2);
        if (nums1[i - 1] > nums2[j - 1]) {
            return findKth(nums1, Arrays.copyOfRange(nums2, j, n), k - j);
        } else {
            return findKth(Arrays.copyOfRange(nums1, i, m), nums2, k - i);
        }
    }

}
