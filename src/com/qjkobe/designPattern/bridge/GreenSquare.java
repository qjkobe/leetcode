package com.qjkobe.designPattern.bridge;

public class GreenSquare extends Square {
  @Override
  public void applyColor() {
    System.out.println("green");
  }
}
