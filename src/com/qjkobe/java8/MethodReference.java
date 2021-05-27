package com.qjkobe.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class MethodReference {
  public static void main(String[] args) {
    Consumer<String> c = s -> System.out.println(s);

    Consumer<String> c2 = System.out::println;

    Comparator<Integer> c3 = Integer::compare;

    List<String> list = Arrays.asList("1", "a", "bs");
    list.forEach(System.out::println);
  }
}
