package S0000_0099;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class SC0017_LetterCombinations {

    /**
     * 解题思路
     * 回溯法
     * 回溯过程中维护一个字符串，表示已有的字母排列（如果未遍历完电话号码的所有数字，则已有的字母排列是不完整的）。该字符串初始为空。
     * 每次取电话号码的一位数字，从哈希表中获得该数字对应的所有可能的字母，并将其中的一个字母插入到已有的字母排列后面，然后继续处理电话号码的后一位数字，直到处理完电话号码中的所有数字，即得到一个完整的字母排列。
     * 然后进行回退操作，遍历其余的字母排列。
     * 回溯算法用于寻找所有的可行解，如果发现一个解不可行，则会舍弃不可行的解。在这道题中，由于每个数字对应的每个字母都可能进入字母组合，因此不存在不可行的解，直接穷举所有的解即可。
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        Map<Character,String> hashMap = new HashMap<>();
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        if (digits==null||digits.length()==0){
            return result;
        }
        backtrack(0,digits,new StringBuffer(""),result,hashMap);
        return result;
    }

    public static void backtrack(int index,String digits,StringBuffer str,List<String> res,Map<Character, String>phoneMap){
        if (index == digits.length()){
            res.add(str.toString());
            return;
        }
        char digit = digits.charAt(index);
        String s = phoneMap.get(digit);
        for (int i=0;i<s.length();i++){
            String letter = String.valueOf(s.charAt(i));
            str.append(letter);
            backtrack(index+1,digits,str,res,phoneMap);
            str.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
