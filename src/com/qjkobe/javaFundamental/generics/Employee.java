package com.qjkobe.javaFundamental.generics;

import com.qjkobe.java8.Person;

public class Employee extends Person {
  public Employee(String name, int age) {
    super(name, age);
  }

  @Override
  public String toString() {
    return "[Employee]" + super.toString();
  }
}
