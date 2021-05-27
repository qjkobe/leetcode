package com.qjkobe;

public class SingletonFactory {

  private static final SingletonFactory SINGLETON_FACTORY = new SingletonFactory();

  public static SingletonFactory getInstance() {
    return SINGLETON_FACTORY;
  }
  private SingletonFactory() {

  }

  private Object readResolve() {
    return SINGLETON_FACTORY;
  }
}
