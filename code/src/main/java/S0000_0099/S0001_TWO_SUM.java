package S0000_0099;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
//你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
public class S0001_TWO_SUM {
    public int[] twoSum(int[] nums, int target) {
        //从小到大进行排序
        int results [] = new int[2];
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int index = 0;index<nums.length;index++){
            int num = target - nums[index];
            if (hashMap.containsKey(num)){
                return new int[]{index,hashMap.get(num)};
            }
            hashMap.put(nums[index],index);
        }
        return results;
    }

    public static void main(String[] args) {
        S0001_TWO_SUM s0001_two_sum = new S0001_TWO_SUM();
        int[] ints = s0001_two_sum.twoSum(new int[]{3, 2, 4}, 6);
        for (int x:ints){
            System.out.println(x);
        }
    }
}
