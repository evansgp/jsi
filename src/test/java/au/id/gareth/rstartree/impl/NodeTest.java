package au.id.gareth.rstartree.impl;

import au.id.gareth.rstartree.geometry.Interval;
import au.id.gareth.rstartree.geometry.Rectangle;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class NodeTest {

  @Test(expected = IllegalArgumentException.class)
  public void testNullArgs() throws Exception {
    new Node<Integer>(null);
  }

  @Test
  public void testGetBoundingBox() {
    Node<Integer> node = new Node<>(new Rectangle<>(new Interval<>(-1,1), new Interval<>(-1,1)));
    assertThat(node.getBoundingBox(), is(notNullValue()));
    assertThat(node.getBoundingBox().getIntervals(), is(notNullValue()));
    assertThat(node.getBoundingBox().getIntervals().length, is(2));
    assertThat(node.getBoundingBox().getIntervals()[0].getMin(), is(-1));
    assertThat(node.getBoundingBox().getIntervals()[0].getMax(), is(1));
    assertThat(node.getBoundingBox().getIntervals()[1].getMin(), is(-1));
    assertThat(node.getBoundingBox().getIntervals()[1].getMax(), is(1));
  }


}

