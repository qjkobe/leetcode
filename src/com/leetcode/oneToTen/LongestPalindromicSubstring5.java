package com.leetcode.oneToTen;

public class LongestPalindromicSubstring5 {
  public static void main(String[] args) {
    Boolean[] dp = new Boolean[2];
    System.out.println(dp.toString());
    System.out.println(manacher("nabcbab"));
    System.out.println(longestPalindrome("cbbd"));
    System.out.println(longestPalindrome("a"));
    System.out.println(longestPalindrome("ac"));
  }

  /**
   * P(i, j): true if is Palindrome.
   * false if isn't Palindrome.
   * P(i - 1, j + 1) = true if j + 1 = i - 1
   * P(i, i) = true
   * P(i, i + 1) = true if i = i + 1
   *
   * @param s string
   * @return string
   */
  public static String longestPalindrome(String s) {
    Boolean[][] dp = new Boolean[s.length()][s.length()];
    int left = 0;
    int right = 0;
    int max = 1;
    for (int i = 0; i < dp.length - 1; i++) {
      dp[i][i] = true;
    }
    for (int i = dp.length - 2; i >= 0; i--) {
      for (int j = i + 1; j < dp.length; j++) {
        if (s.charAt(i) == s.charAt(j)) {
          if (j - i < 3) {
            dp[i][j] = true;
          } else {
            dp[i][j] = dp[i + 1][j - 1];
          }
          if (Boolean.TRUE.equals(dp[i][j]) && j - i + 1 > max) {
            left = i;
            right = j;
            max = j - i;
          }
        } else {
          dp[i][j] = false;
        }
      }
    }
    return s.substring(left, right + 1);
  }

  public static String manacher(String s) {
    StringBuffer sb = new StringBuffer();
    sb.append("$#");
    for (int i = 0; i < s.length(); i++) {
      sb.append(s.charAt(i));
      sb.append('#');
    }
    int mostRightIndex = 0;
    int middleOfMRI = 0;
    int maxP = 0;
    int middleOfMP = 0;
    int[] P = new int[sb.length()];
    for (int i = 1; i < sb.length(); i++) {
      P[i] = P[i] < mostRightIndex ? Math.min(mostRightIndex - i, P[2 * middleOfMRI - i]) : 1;
      while (i + P[i] < sb.length() && sb.charAt(i + P[i]) == sb.charAt(i - P[i])) {
        P[i]++;
      }
      if (i + P[i] > mostRightIndex) {
        mostRightIndex = i + P[i];
        middleOfMRI = i;
      }
      if (maxP < P[i]) {
        maxP = P[i];
        middleOfMP = i;
      }
    }
    return s.substring((middleOfMP - maxP) / 2, (middleOfMP + maxP) / 2 - 1);
  }
}
