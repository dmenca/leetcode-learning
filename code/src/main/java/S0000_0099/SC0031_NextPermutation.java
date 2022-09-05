package S0000_0099;

/**
 * 下一个排序
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 *
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SC0031_NextPermutation {
    /**
     * 解题思路：
     * 我们需要将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
     * 同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        //从右向左遍历，找到第一个顺序对 (i,i+1)，满足nums[i]<nums[i+1],得到最小需要交换的数 此时（i+1，n）必然是降序序列
        while (i >= 0&&nums[i]>=nums[i+1]) {
            //1 2 3 6 5
            i--;
        }
        if (i>=0){
            //从右向左遍历，找到第一个大于最小数的较大数，将较大数与较小数进行交换，此时（i+1，n）必然是降序，再反转后面的数为升序即可
            int j =nums.length-1;
            while (j>=0&&nums[i]>=nums[j]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
