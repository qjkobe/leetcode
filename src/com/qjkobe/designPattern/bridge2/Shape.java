package com.qjkobe.designPattern.bridge2;

public abstract class Shape {
  protected Color color;

  public Shape(Color color) {
    this.color = color;
  }

  abstract public void applyColor();
}
