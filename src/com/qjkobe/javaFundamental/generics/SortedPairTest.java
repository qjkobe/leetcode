package com.qjkobe.javaFundamental.generics;

import org.junit.Assert;
import org.junit.Test;

public class SortedPairTest {

  @Test
  public void shouldRetainOrderOfOrderedPair() {
    SortedPair<Integer> pair = new SortedPair<>(1, 2);
    Assert.assertEquals(1, pair.getFirst().intValue());
    Assert.assertEquals(2, pair.getSecond().intValue());
  }

  @Test
  public void shouldFlipOrderOfMisorderedPair(){
    SortedPair<Integer> pair = new SortedPair<>(2, 1);
    Assert.assertEquals(1, pair.getFirst().intValue());
    Assert.assertEquals(2, pair.getSecond().intValue());
  }
}
