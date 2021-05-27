package com.qjkobe.javaFundamental.generics;

import com.qjkobe.java8.Person;

public class Partner extends Person {
  public Partner(String name, int age) {
    super(name, age);
  }

  @Override
  public String toString() {
    return "[Partner]" + super.toString();
  }
}
