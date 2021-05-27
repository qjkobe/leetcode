package com.qjkobe.javaFundamental.generics;

//Type Bounds. T is comparable and can be compared to itself.
public class SortedPair<T extends Comparable<T>> {
  private T first;
  private T second;

  public SortedPair(T left, T right) {
    if(left.compareTo(right) < 0){
      first = left;
      second = right;
    }else {
      first = right;
      second = left;
    }
  }

  public T getFirst() {
    return first;
  }

  public T getSecond() {
    return second;
  }
}
