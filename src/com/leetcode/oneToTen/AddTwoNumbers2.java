package com.leetcode.oneToTen;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class AddTwoNumbers2 {

  public static void main(String[] args) {
    ListNode l1_3 = new ListNode(9);
    ListNode l1_2 = new ListNode(9, l1_3);
    ListNode l1 = new ListNode(9, l1_2);
    l1_3.next = new ListNode(9);


    ListNode l2_3 = new ListNode(9);
    ListNode l2_2 = new ListNode(9,l2_3);
    ListNode l2 = new ListNode(9, l2_2);

    ListNode result = addTwoNumbers(l1, l2);
    System.out.println(result.val + " " + result.next.val + " " + result.next.next.val + " " + result.next.next.next.next.val);
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode l3 = new ListNode();
    ListNode result = l3;
    int addFlag = 0;
    while (true) {
      int l1Val = 0;
      int l2Val = 0;
      if (l1 == null && l2 == null && addFlag == 0) {
        break;
      }
      l3.next = new ListNode();
      l3 = l3.next;
      if (l2 != null) {
        l2Val = l2.val;
        l2 = l2.next;
      }
      if (l1 != null) {
        l1Val = l1.val;
        l1 = l1.next;
      }
      l3.val = l1Val + l2Val + addFlag;
      addFlag = 0;
      if (l3.val > 9) {
        l3.val -= 10;
        addFlag = 1;
      }
    }
    return result.next;
  }
}
