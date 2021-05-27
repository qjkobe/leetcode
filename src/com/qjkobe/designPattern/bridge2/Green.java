package com.qjkobe.designPattern.bridge2;

public class Green implements Color {
  @Override
  public void applyColor() {
    System.out.println("green");
  }
}
