package com.qjkobe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SpellChecker {
  private final Map<String, String> dictionary;

  public SpellChecker(Map<String, String> dictionary) {
    this.dictionary = Objects.requireNonNull(dictionary);
  }

  public boolean isValid(String word) {
    return true;
  }

  public List<String> suggestions(String type) {
    return new ArrayList<>();
  }
}
