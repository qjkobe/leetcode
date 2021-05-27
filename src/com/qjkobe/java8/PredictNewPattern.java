package com.qjkobe.java8;

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredictNewPattern {
  public static void main(String[] args) {
    Predicate<String> p1 = s -> s.length() < 20;
    Predicate<String> p2 = s -> s.length() > 10;
    Predicate<String> p3 = p1.and(p2);
    Predicate<String> p4 = s -> s.equals("122");
    Predicate<String> p5 = Predicate.isEqual("122");
    List<String> list = Arrays.asList("122", "sdddddddddddd", "sdddddddddddddddddddddddddd");
    List<String> result = list.stream().filter(p5).collect(Collectors.toList());
    for (String a : result) {
      System.out.println(a);
    }

    List<String> list2 = new ArrayList<>();
    Consumer<String> c1 = System.out::println;
    Consumer<String> c2 = list2::add;

    list.forEach(c1.andThen(c2));
    list2.forEach(c1);
  }
}
