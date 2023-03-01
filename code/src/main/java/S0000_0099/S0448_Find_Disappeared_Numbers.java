package S0000_0099;

import java.util.*;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 */
public class S0448_Find_Disappeared_Numbers {
    /**
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num:nums){
            set.add(num);
        }
        List<Integer>results=new ArrayList<>();
        for (int i=1;i<=nums.length;i++){
            if (!set.contains(i)){
                results.add(i);
            }
        }
        return results;
    }

    /**
     * 反向思维，利用这一范围之外的数字，来表达是否存在。
     * 遍历数组，遇到一个数x时，就让nums[x-1]增加n。由于nums中所有数均在【1，n】中，增加之后，这个数必然大于n。
     * 最后遍历数组，如果nums[i]没有大于n，就说明没有遇到过该数。
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int length = nums.length;
        for(int num:nums){
            nums[(num-1)%length] = num + length;
        }
        for(int i =0 ;i< length;i++){
            if (nums[i]<=length){
                res.add(i+1);
            }
        }
        return res;
    }
}
