package au.id.gareth.rstartree.impl;

import au.id.gareth.rstartree.geometry.Interval;
import au.id.gareth.rstartree.geometry.Rectangle;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class BranchNodeTest {

  @Test(expected = IllegalArgumentException.class)
  public void testNullArgs() throws Exception {
    new BranchNode<Integer, Integer>(null, 1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testLargeMin() throws Exception {
    new BranchNode<Integer, Integer>(new Rectangle<>(new Interval<>(0,1), new Interval<>(0, 1)), 2, 3);
  }

  @Test
  public void testBorderlineMinMax() throws Exception {
    new BranchNode<Integer, Integer>(new Rectangle<>(new Interval<>(0,1), new Interval<>(0, 1)), 1, 2);
  }

  @Test
  public void testSmallMin() throws Exception {
    new BranchNode<Integer, Integer>(new Rectangle<>(new Interval<>(0,1), new Interval<>(0, 1)), 1, 3);
  }

  @Test
  public void testGetBoundingBox() {
    BranchNode<Integer, Integer> node = new BranchNode<>(new Rectangle<>(new Interval<>(-1,1), new Interval<>(-1,1)), 1, 2);
    assertThat(node.getBoundingBox(), is(notNullValue()));
    assertThat(node.getBoundingBox().getIntervals(), is(notNullValue()));
    assertThat(node.getBoundingBox().getIntervals().length, is(2));
    assertThat(node.getBoundingBox().getIntervals()[0].getMin(), is(-1));
    assertThat(node.getBoundingBox().getIntervals()[0].getMax(), is(1));
    assertThat(node.getBoundingBox().getIntervals()[1].getMin(), is(-1));
    assertThat(node.getBoundingBox().getIntervals()[1].getMax(), is(1));
  }


}

