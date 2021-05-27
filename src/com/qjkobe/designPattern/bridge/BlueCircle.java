package com.qjkobe.designPattern.bridge;

public class BlueCircle extends Circle {
  @Override
  public void applyColor() {
    System.out.println("blue");
  }
}
