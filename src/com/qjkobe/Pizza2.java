package com.qjkobe;

public class Pizza2 extends PizzaPattern {
  private final boolean sauceInside;

  public Pizza2(Builder builder) {
    super(builder);
    sauceInside = builder.sauseInside;
  }

  public static class Builder extends PizzaPattern.Builder<Builder> {
    private boolean sauseInside = false;

    public Builder sauceInside() {
      sauseInside = true;
      return this;
    }

    @Override
    public Pizza2 build() {
      return new Pizza2(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
