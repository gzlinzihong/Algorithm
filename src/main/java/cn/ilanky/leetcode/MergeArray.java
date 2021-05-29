package cn.ilanky.leetcode;

/**
 * @author 嘿 林梓鸿
 * @date 2020年 09月26日 21:38:04
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //指针1
        int i1 = m-1;
        //指针2
        int i2 = n-1;

        //指针3
        int k = m+n-1;

        while(i1 >= 0 && i2 >= 0){
            if(nums1[i1]> nums2[i2]){
                nums1[k--] = nums1[i1];
                i1--;
            }else{
                nums1[k--] = nums2[i2];
                i2--;
            }
        }

        while(i1 >= 0){
            nums1[k--] = nums1[i1--];
        }

        while(i2 >= 0){
            nums1[k--] = nums2[i2--];
        }
    }
}
