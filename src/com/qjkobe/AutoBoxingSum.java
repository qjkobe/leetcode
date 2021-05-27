package com.qjkobe;

import java.time.Duration;
import java.time.LocalTime;

public class AutoBoxingSum {
  public static void main(String[] args) {
    LocalTime startTime = LocalTime.now();
    sum();
    LocalTime endTime = LocalTime.now();
    Duration duration = Duration.between(startTime, endTime);
    System.out.println(duration.toMillis());

    startTime = LocalTime.now();
    sum2();
    endTime = LocalTime.now();
    duration = Duration.between(startTime, endTime);
    System.out.println(duration.toMillis());
  }

  private static long sum() {
    Long sum = 0L;
    for (long i = 0; i <= Integer.MAX_VALUE; i++) {
      sum += i;
    }
    return sum;
  }

  private static long sum2() {
    long sum = 0L;
    for (long i = 0; i <= Integer.MAX_VALUE; i++) {
      sum += i;
    }
    return sum;
  }
}
