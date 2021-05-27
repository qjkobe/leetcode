package com.leetcode.oneToTen;

public class LongestSubstringWithoutRepestingCharacters3 {
  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("aav"));
    System.out.println(lengthOfLongestSubstring(" "));
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
    System.out.println(lengthOfLongestSubstring("pwwkew"));
  }
  public static int lengthOfLongestSubstring(String s) {
    if (s.length() == 0) {
      return 0;
    }
    if (s.length() == 1) {
      return 1;
    }
    int temp[] = new int[128];
    // 表示当前开始计算的下标。重复了以后就上移一个。
    int start = 1;
    int max = -1;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (temp[c] == 0 || temp[c] < start) {
        temp[c] = i + 1;
        int len = i + 1 - (start - 1);
        if (len > max) {
          max = len;
        }
      } else {
        int len = i - (start - 1);
        if (len > max) {
          max = len;
        }
        start = temp[c] + 1;
        temp[c] = i + 1;
      }
    }
    return max == -1 ? s.length() : max;
  }
}
