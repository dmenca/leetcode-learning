package S0000_0099;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class SC0022_GenerateParenthesis {
    /**
     * 解题思路：dfs递归回溯 + 剪枝
     * 对于每一个位置尝试添加（或者）括号，再递归继续，当已使用的右括号大于左括号时显然不满足则剪枝
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n==0){
            return result;
        }
        dfs("",0,0,result,n);
        return result;
    }

    private void dfs(String str,int left,int right,List<String>res,int n){
        if (left>n||right>n||right>left){
            return;
        }
        if (left ==n && right==n){
            res.add(str);
            return;
        }
        dfs(str+"(",left+1,right,res,n);
        dfs(str+")",left,right+1,res,n);
    }
}
