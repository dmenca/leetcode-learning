package S0000_0099;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 */
public class S0169_MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int majorityElement1(int[] nums) {
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int num : nums){
            if (countMap.containsKey(num)){
                countMap.put(num,countMap.get(countMap)+1);
            }else{
                countMap.put(num,1);
            }
        }
        Map.Entry<Integer,Integer> majorEntry = null;
        for (Map.Entry<Integer,Integer> entry:countMap.entrySet()){
            if (majorEntry == null || entry.getValue()>majorEntry.getValue()){
                majorEntry = entry;
            }
        }
        return majorEntry.getKey();
    }
}
