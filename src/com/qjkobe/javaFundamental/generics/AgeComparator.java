package com.qjkobe.javaFundamental.generics;

import com.qjkobe.java8.Person;

import java.util.Comparator;

//Implement a Comparator interface.
public class AgeComparator implements Comparator<Person> {
  @Override
  public int compare(Person left, Person right) {
    return Integer.compare(left.getAge(), right.getAge());
  }
}
