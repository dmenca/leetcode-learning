package S0000_0099;

/** 比特位计数
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 */
public class S0338_Count_Bits {

    public int[] countBits(int n) {
        int counts[] = new int[n+1];
        for (int i=0;i<=n;i++){
            counts[i]=Integer.bitCount(i);
        }
        return counts;
    }

    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }



}
