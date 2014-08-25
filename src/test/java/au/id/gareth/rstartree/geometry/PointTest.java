package au.id.gareth.rstartree.geometry;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class PointTest {

  @Test(expected = IllegalArgumentException.class)
  public void testNullValues() {
    new Point<Integer>(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNoValues() {
    new Point<Integer>();
  }

  @Test
  public void testGetValues() {
    Point<Integer> point = new Point<>(6,7,8,1);
    assertThat(point.getValues(), is(notNullValue()));
    assertThat(point.getValues().length, is(4));
    assertThat(point.getValues()[0], is(6));
    assertThat(point.getValues()[1], is(7));
    assertThat(point.getValues()[2], is(8));
    assertThat(point.getValues()[3], is(1));
  }

}
