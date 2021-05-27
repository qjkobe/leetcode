package com.qjkobe;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

public class LambdaExplained {
  public static void main(String[] args) {
    List<Integer> ints = new ArrayList<>();
    ints.add(2);
    ints.add(3);
    ints.add(4);
    try {
      requireNonNull(ints);
    } catch (NullPointerException e) {
      System.out.println("null");
    }

    List<Integer> intResult = ints.stream().filter(x -> x < 4).collect(Collectors.toList());

    System.out.println(intResult);
  }
}
