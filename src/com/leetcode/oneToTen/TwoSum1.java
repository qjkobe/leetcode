package com.leetcode.oneToTen;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
  public static void main(String[] args) {
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    System.out.println(twoSum(nums, target)[1]);
  }
  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> temp = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (temp.containsKey(nums[i])) {
        int res[] = {temp.get(nums[i]), i};
        return res;
      }
      temp.put(target - nums[i], i);
    }
    return null;
  }
}
