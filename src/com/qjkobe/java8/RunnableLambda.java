package com.qjkobe.java8;

import java.time.Duration;
import java.time.LocalTime;

public class RunnableLambda {
  public static void main(String[] args) throws InterruptedException {
    Runnable runnableLambda = () -> {
      for (int i = 0; i < 3; i++) {
        System.out.println("Hello: " + Thread.currentThread().getName());
      }
    };

    Thread t = new Thread(runnableLambda);
    t.start();
    System.out.println("before join");
    t.join();
    System.out.println("after join");

    //性能测试
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 3; i++) {
          System.out.println("Hello: " + Thread.currentThread().getName());
        }
      }
    };
    LocalTime startTime = LocalTime.now();
    for (int i = 0; i < Integer.MAX_VALUE; i++) {
      runnableLambda = () -> {
        for (int j = 0; j < 3; j++) {
          System.out.println("Hello: " + Thread.currentThread().getName());
        }
      };
    }
    LocalTime endTime = LocalTime.now();
    Duration duration = Duration.between(startTime, endTime);
    System.out.println(duration.toMillis());

    startTime = LocalTime.now();
    for (int i = 0; i < Integer.MAX_VALUE; i++) {
      runnable = new Runnable() {
        @Override
        public void run() {
          for (int i = 0; i < 3; i++) {
            System.out.println("Hello: " + Thread.currentThread().getName());
          }
        }
      };
    }
    endTime = LocalTime.now();
    duration = Duration.between(startTime, endTime);
    System.out.println(duration.toMillis());


  }
}
