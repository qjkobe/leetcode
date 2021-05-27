package com.qjkobe;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;
import java.util.Random;

public class Main{
  public static void main(String[] args) {
    StringBuffer sb = new StringBuffer();
    int count = 0;
    for (int i = 0; i < 1024 * 64; i+=30) {
      count++;
      sb.append("Jin, Kris <kris.jin@sap.com>; ");
    }
    System.out.println(count);
    try {
      BufferedWriter out = new BufferedWriter(new FileWriter("recepient.txt"));
      out.write(sb.toString());
      out.close();
      System.out.println("文件创建成功！");
    } catch (IOException e) {
    }
  }

}