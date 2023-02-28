package S0000_0099;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class S0136_Single_Number {
    /**
     * 通过异或运算 相同为0不同为1 两个相同的树异或一定是0 0与某个数异或得到的就是另一个数字
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int single = 0 ;
        for (int i=0;i<nums.length;i++){
            single = single^nums[i];
        }
        return single;
    }

    public static int singleNumber1(int[] nums) {
        Arrays.sort(nums);
        int x=0,i=0;
        while (i<nums.length){
            if (i+1<nums.length && nums[i] == nums[i+1]){
                i = i + 2;
            }else{
                x = nums[i];
                break;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber1(new int[]{4,1,2,1,2}));
    }
}
