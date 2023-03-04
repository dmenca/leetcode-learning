package S0000_0099;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class S0070_ClimbStairs {
    /**
     * 跳到n阶台阶等于从 n-1个台阶的方法跳一级 和 n-2个台阶的方法跳二级
     * f(n) = f(n-1) + f(n-2)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n==1||n==2) {
            return n;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }
    public int climbStairs1(int n) {
        int p=0,q=0,r=1;
        for(int i=1;i<=n;i++){
            p = q;
            q = r;
            r = p+q;
        }
        return r;
    }

    /**
     * 动态规划 d(n) = d(n-1) + d(n-2)
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n<=1){
            return n;
        }
        int d[] = new int[n];
        d[1]=1;
        d[2]=2;
        for (int i=3;i<=n;i++){
            d[i] = d[i-1]+d[i-2];
        }
        return d[n];
    }
}
