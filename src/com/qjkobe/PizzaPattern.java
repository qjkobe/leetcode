package com.qjkobe;

import java.util.*;

public abstract class PizzaPattern {
  public enum Topping {HAM, MASHROOM, ONION, PEPPER, SAUSAGE,}

  final Set<Topping> toppings;

  abstract static class Builder<T extends Builder<T>> {
    EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

    public T addTopping(Topping topping) {
      toppings.add(Objects.requireNonNull(topping));
      return self();
    }

    abstract PizzaPattern build();

    // Subclasses must override this method to return ” this"
    protected abstract T self();
  }

  PizzaPattern(Builder<?> builder) {
    System.out.println("clone toppings to main class");
    toppings = builder.toppings.clone();
  }
}

