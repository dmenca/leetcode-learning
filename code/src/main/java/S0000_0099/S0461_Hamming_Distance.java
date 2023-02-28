package S0000_0099;

/**
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 */
public class S0461_Hamming_Distance {


    public static int hammingDistance(int x, int y) {
        int distance = 0;
        while (x!=0&&y!=0){
            distance += (x%2==y%2)?0:1;
            x = x/2;
            y = y/2;
        }
        while (x!=0){
            distance += x%2;
            x = x/2;
        }
        while (y!=0){
            distance += y%2;
            y = y/2;
        }
        return distance;
    }

    public static int hammingDistance1(int x, int y) {
        // 不同为1 相同为0 异或方法
        return Integer.bitCount(x^y);
    }

    public static int hammingDistance2(int x, int y) {
        // 不同为1 相同为0 异或方法
        int s = x^y;
        int ret = 0;
        // 计算s中1的个数
        while(s!=0){
            // 判断最后一位是否为1
            ret = s & 1;
            // 向右边移动
            s>>=1;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
    }
}
