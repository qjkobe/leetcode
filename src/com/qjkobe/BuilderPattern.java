package com.qjkobe;

public class BuilderPattern {
  private final int a1;
  private final int a2;
  private final int a3;
  private final int a4;

  public static class Builder {
    //necessary
    private final int a1;
    private int a2;
    //optional
    private int a3 = 0;
    private int a4 = 0;

    public Builder(int a1, int a2) {
      this.a1 = a1;
      this.a2 = a2;
    }

    public Builder a3(int a3) {
      this.a3 = a3;
      return this;
    }

    public Builder a4(int a4) {
      this.a4 = a4;
      return this;
    }

    public BuilderPattern build() {
      return new BuilderPattern(this);
    }
  }

  private BuilderPattern(Builder builder) {
    this.a1 = builder.a1;
    this.a2 = builder.a2;
    this.a3 = builder.a3;
    this.a4 = builder.a4;
  }
}
