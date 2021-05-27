package com.qjkobe.javaFundamental.generics;

import com.qjkobe.java8.Person;

import java.util.*;

public class SortingExamples {

  public static void main(String[] args) {
    Person kj = new Person("Kris Jin", 18);
    Person es = new Person("Xin Sun", 30);
    Person sp = new Person("Shawn Peng", 25);
    List<Person> personList = new ArrayList<>();
    personList.add(kj);
    personList.add(es);
    personList.add(sp);

    Collections.sort(personList, new AgeComparator());
    System.out.println(personList);

    Collections.sort(personList, (left, right) -> Integer.compare(right.getAge(), left.getAge()));
    System.out.println(personList);

    Collections.sort(personList, new ReverseComparator<>(new AgeComparator()));
    System.out.println(personList);

    final Person youngestMember = minWithGenerics(personList, new AgeComparator());
    System.out.println(youngestMember);

    List<Integer> numbers = new ArrayList<>();
    numbers.add(10);
    numbers.add(100);
    numbers.add(5);
    //静态方法引用：类名::方法名
    //任意对象的实例方法引用：类名::实例方法
    System.out.println(minWithGenerics(numbers, Integer::compareTo));
    System.out.println(minWithGenerics(numbers, Integer::compare));
    System.out.println(minWithGenerics(numbers, (x, y) -> Integer.compare(x, y)));
    System.out.println(minWithGenerics(numbers, (x, y) -> x.compareTo(y)));

  }

  //This method can work but cannot check error if comparator's type is wrong during compiling.
  public static Object min(List values, Comparator comparator) {
    if (values.isEmpty()) {
      throw new IllegalArgumentException("Empty list");
    }
    Object lowestElement = values.get(0);
    for (int i = 0; i < values.size(); i++) {
      final Object element = values.get(i);
      if (comparator.compare(element, lowestElement) < 0) {
        lowestElement = element;
      }
    }
    return lowestElement;
  }

  public static <T> T minWithGenerics(List<T> values, Comparator<T> comparator) {
    if (values.isEmpty()) {
      throw new IllegalArgumentException("Empty list");
    }
    T lowestElement = values.get(0);
    for (int i = 0; i < values.size(); i++) {
      final T element = values.get(i);
      if (comparator.compare(element, lowestElement) < 0) {
        lowestElement = element;
      }
    }
    return lowestElement;
  }
}
