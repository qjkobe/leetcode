package com.qjkobe.java8;

import java.io.File;
import java.io.FileFilter;

public class Main {
  public static void main(String[] args){

    FileFilter filter = (File file) -> file.getName().endsWith(".java");

    File dir = new File("/Users/i501206/Documents/JavaTrain/src/com/qjkobe");

    File[] files2 = dir.listFiles(filter);

    for (File f : files2) {
      System.out.println(f);
    }
  }
}
