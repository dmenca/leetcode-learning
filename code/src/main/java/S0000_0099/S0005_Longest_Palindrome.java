package S0000_0099;

import java.util.Stack;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 */
public class S0005_Longest_Palindrome {


    public static class PalindromeDTO{
        public PalindromeDTO(){
            this.start = 0;
            this.end = 0;
            this.len = 0;
        }
        private int start;
        private int end;
        private int len;

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getLen() {
            return len;
        }

        public void setLen(int len) {
            this.len = len;
        }
    }
    /**
     * 解题思路：
     * 中心扩散法：从一个点开始往两边找，左边的字符要等于右边的字符 分为奇数偶数串两种
     * 动态规划：记录s[i,j]为回文串的前提是s[i+1,j-1]%+&s[i]=s[j] 根据长度2到最大值遍历记录s[i,j]是maxArea回文串
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        //长度奇数 aba
        //长度偶数 abba
        //ccdccebbeccdcc
        //ccddccddcc
        if (s == null || s.length() < 1) {
            return "";
        }
        int maxLength = 0;
        int start=0;
        int end=0;
        for (int i=0 ; i<s.length();i++){
            PalindromeDTO palindromeDTO1 = searchToLeftAndRight(s, i, i);
            PalindromeDTO palindromeDTO2 = searchToLeftAndRight(s, i, i + 1);
            PalindromeDTO palindromeDTO = palindromeDTO1.len>palindromeDTO2.len?palindromeDTO1:palindromeDTO2;
            if (palindromeDTO.len>maxLength){
                start = palindromeDTO.getStart();
                end = palindromeDTO.getEnd();
                maxLength = palindromeDTO.len;
            }
            if (i>s.length()/2+1 && maxLength>i+1){
                break;
            }

        }
        return s.substring(start,end+1);

    }


    public static PalindromeDTO searchToLeftAndRight(String s,int left,int right){
        PalindromeDTO palindromeDTO = new PalindromeDTO();
        while (left >=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            palindromeDTO.setStart(left);
            palindromeDTO.setEnd(right);
            palindromeDTO.setLen(right - left +1);
            left--;
            right++;
        }
        return palindromeDTO;
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
