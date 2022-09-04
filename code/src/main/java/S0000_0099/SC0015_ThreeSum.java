package S0000_0099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SC0015_ThreeSum {

    /**
     * 解题思路：排序+双指针方法
     * 对数组小到大进行排序，固定3个指针中最左（最小的数）数字为指针i，双指针l，r分别在数组索引（k+1，len（nums）-1）处，双指针交替
     * 向中间移动，如果总和小于0，则移动左指针，如果总和大于0，则移动右指针，注意需要跳过重复的数值
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i =0 ;i<nums.length;i++){
            if(nums[i]>0){
                return list;
            }
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                int sum = nums[left] + nums[right] + nums[i];
                if (sum==0){
                    List<Integer> integers = Arrays.asList(nums[left],nums[right],nums[i]);
                    list.add(integers);
                    while (left < right &&nums[left]==nums[left+1]){
                        left++;
                    }
                    while (left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if (sum<0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int array1[]=new int[]{0,0,0,0};
        System.out.println(threeSum(array1));
    }
}
