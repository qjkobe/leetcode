package com.qjkobe.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Reduction {

  public static void main(String[] args) {

    List<Integer> list = Arrays.asList();
    Optional<Integer> red1 = list.stream().reduce(Integer::max);
    System.out.println(red1);
    Stream<Integer> stream = Stream.of(1, 2, 3);

    BinaryOperator<Integer> sum = (i1, i2) -> i1 - i2;

    Integer id = 10;

    int red = stream.reduce(id, sum);
    System.out.println(red);
  }
}
