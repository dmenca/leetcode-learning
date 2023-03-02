package S0000_0099;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 * 必须在不复制数组的情况下原地对数组进行操作。
 * [0,1,0,3,12] -> [1,3,12,0,0]
 */
public class S0283_MoveZeroes {
    /**
     * 双指针做法，一个慢指针记录结果，一个快指针遍历数组
     * 创建两个指针i跟j，j记录当前有多少个非0的元素。
     * 遍历一遍数组，遇到非0的数时，则替换到nums[j]的位置，j指针向右移动。遍历完之后，j指针忘右的全都是应该为0的数目。
     * @param nums
     */
    public void moveZeroes(int [] nums){
        int j=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0) {
                nums[j] = nums[i];
                j++;
            }
        }
        while (j<nums.length){
            nums[j]=0;
            j++;
        }
    }

    public void moveZeroes1(int []nums){

    }
}
