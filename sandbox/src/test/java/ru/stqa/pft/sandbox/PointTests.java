package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.task2.Point;

public class PointTests {
  @Test
  public void testZeroDistance() {
    Point o = new Point(0, 0);
    Point o1 = new Point(0, 0);
    Assert.assertEquals(o.distance(o1), 0);
  }

  @Test
  public void testDistance() {
    Point o = new Point(1, 0);
    Point o1 = new Point(0, 0);
    Assert.assertEquals(o.distance(o1), 1);
  }

  @Test
  public void testDistance3() {
    Point o = new Point(1, 1);
    Point o1 = new Point(0, 0);
    Assert.assertEquals(o.distance(o1), Math.sqrt(2));
  }
}

