package S0000_0099;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/container-with-most-water
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class SC0011_Max_Area {
    /**
     * 解题思路：双指针法，容器的面积公式为 area = Math.min(h[left],h[right])*(right-left)
     * 容器最大面积取决于短板
     * 数字较小的指针不动，移动数字较大的指针，面积永远都不会变大。因此数字较小的指针也永远不会在成为容器的边界了，移动数字较小的指针，
     * 使得问题的规模减少1，又以相同的思路来看待一个新的容器
     * 算法流程：
     * 初始化： 双指针 ii , jj 分列水槽左右两端；
     * 循环收窄： 直至双指针相遇时跳出；
     * 更新面积最大值 res；
     * 选定两板高度中的短板，向中间收窄一格；
     * 返回值： 返回面积最大值 res 即可；
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int l =0,r=height.length-1;
        while (l<r){
            int minHeight = Math.min(height[l],height[r]);
            int area = Math.min(height[l],height[r])*(r-l);
            maxArea = Math.max(area,maxArea);
            while (height[l]<=minHeight&&l<r){
                l++;
            }
            while (height[r]<=minHeight&&l<r) {
                 r--;
            }
        }
        return maxArea;
    }
//    public static int maxArea(int[] height) {
//        int maxHeight = 0;
//        int maxArea = 0;
//        for (int i=0;i<height.length;i++){
//            int h1 = height[i];
//            if (h1<=maxHeight){
//                continue;
//            }
//            maxHeight = Math.max(h1,maxHeight);
//            for (int j =i+1;j<height.length;j++){
//                int h2 = height[j];
//                int area = Math.min(h1,h2)*(j-i);
//                maxArea = Math.max(area,maxArea);
//            }
//        }
//        return maxArea;
//    }

    public static void main(String[] args) {
        int height[]= new int[]{1,1};
        System.out.println(maxArea(height));
    }
}
