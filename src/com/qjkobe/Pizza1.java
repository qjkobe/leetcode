package com.qjkobe;

import java.util.Objects;

public class Pizza1 extends PizzaPattern {
  public enum Size {SMALL, MEDIUM, LARGE,}

  private final Size size;

  public static class Builder extends PizzaPattern.Builder<Builder> {
    private final Size size;

    public Builder(Size size) {
      this.size = Objects.requireNonNull(size);
    }

    @Override
    public Pizza1 build() {
      return new Pizza1(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }

  private Pizza1(Builder builder) {
    super(builder);
    System.out.println("Calling parent's constructor ends.");
    size = builder.size;
  }
}
