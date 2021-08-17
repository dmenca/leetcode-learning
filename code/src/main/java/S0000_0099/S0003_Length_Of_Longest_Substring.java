package S0000_0099;

import java.util.*;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
// s = "abcabcbb"  3
// s = "bbbbb" 1
// s = "abbbabb";
// s = "tmmzuxt"
// abcdc
public class S0003_Length_Of_Longest_Substring {
    /**
     * 思路:
     * @param s
     * @return
     */
//    public int lengthOfLongestSubstring(String s) {
//        int res = 0;
//        Set<Character> set = new HashSet<>();
//        for (int i = 0, j = 0; i < s.length(); ++i) {
//            char c = s.charAt(i);
//            while (set.contains(c)) {
//                set.remove(s.charAt(j++));
//            }
//            set.add(c);
//            res = Math.max(res, i - j + 1);
//        }
//        return res;
//    }

    /**
     * 思路: 采用窗口的+哈希的方式实现。i，j分别代表了不重复字串的结束位置和开始位置。[i-j+1]为不重复字符串长度
     * 从i开始往后遍历，如果i所在的元素在没出现过，则继续往后遍历，将当前元素的位置插入到哈希表中。
     * 如果i元素出现过，则从hash表中获取上一次i元素出现的位置，比较i元素与当前不重复字符串结束位置谁大(防止取到了最开头出现过的元素)，取大的，此时[j,i]中不包含重复的字符串。
     * 更新res的最大值为 res = max(res, i - j + 1)。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int res = 0 , j = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            Integer p = map.get(c);
            if (p!=null){
                j = Math.max(j,p+1);
            }
            map.put(c,i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }


    public static void main(String[] args) {
        S0003_Length_Of_Longest_Substring s = new S0003_Length_Of_Longest_Substring();
        System.out.println(s.lengthOfLongestSubstring(new String("tmmzuxt")));
    }
}
