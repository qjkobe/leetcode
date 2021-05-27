package com.qjkobe.designPattern.bridge2;

public class Blue implements Color {
  @Override
  public void applyColor() {
    System.out.println("blue");
  }
}
