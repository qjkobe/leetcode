package com.qjkobe.对于所有对象都通用的方法;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.TreeSet;

public class ExtendsComparable {
  public static void main(String[] args) {
    BigDecimal a = new BigDecimal("1.0");
    BigDecimal b = new BigDecimal("1.00");
    HashSet<BigDecimal> set1 = new HashSet<>();
    TreeSet<BigDecimal> set2 = new TreeSet<>();

    set1.add(a);
    set1.add(b);
    set2.add(a);
    set2.add(b);
    System.out.println(set1.size());
    System.out.println(set2.size());
  }
}
