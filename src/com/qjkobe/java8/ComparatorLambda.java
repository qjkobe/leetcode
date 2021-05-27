package com.qjkobe.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambda {

  public static void main(String[] args) {

    Comparator<String> comp = (s1, s2) -> Integer.compare(s2.length(), s1.length());

    List<String> list = Arrays.asList("***", "**", "****", "*");
    Collections.sort(list, comp);

    for (String s : list) {
      System.out.println(s);
    }
  }
}
