package S0000_0099;
//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//nums1 = [1,3], nums2 = [2] 2.00000
//nums1 = [1,2], nums2 = [3,4] 2.50000
public class S0004_Find_Median_Sorted_Arrays {
    /**
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums3 [] = new int[nums1.length+nums2.length];
        int index = 0;
        int l =0,r=0;
        double result = 0;
        while (l<nums1.length&&r<nums2.length){
            int nums1N = nums1[l];
            int nums2N = nums2[r];
            if (nums1N<nums2N){
                nums3[index] = nums1N;
                l++;
            }else{
                nums3[index] = nums2N;
                r++;
            }
            index++;
        }
        while (l<nums1.length){
            nums3[index++] = nums1[l++];
        }
        while (r<nums2.length){
            nums3[index++] = nums2[r++];
        }
        if (nums3.length %2 !=0){
            result = nums3[(nums3.length/2)];
        }else{
            result = (double)(nums3[(nums3.length/2)]+nums3[(nums3.length/2-1)])/2;

        }

        return result;
    }

    public static void main(String[] args) {
        S0004_Find_Median_Sorted_Arrays s0004_find_median_sorted_arrays = new S0004_Find_Median_Sorted_Arrays();
        System.out.println(s0004_find_median_sorted_arrays.findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
    }
}
