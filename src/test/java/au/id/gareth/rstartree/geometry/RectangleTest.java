package au.id.gareth.rstartree.geometry;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class RectangleTest {

  @Test(expected = IllegalArgumentException.class)
  public void testNullIntervals() {
    new Rectangle<Integer>(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNoIntervals() {
    new Rectangle<Integer>();
  }

  @Test
  public void testGetIntervals() {
    Rectangle<Integer> rectangle = new Rectangle<>(new Interval<>(23,42), new Interval<>(5,69));
    assertThat(rectangle.getIntervals(), is(notNullValue()));
    assertThat(rectangle.getIntervals().length, is(2));
    assertThat(rectangle.getIntervals()[0].getMin(), is(23));
    assertThat(rectangle.getIntervals()[0].getMax(), is(42));
    assertThat(rectangle.getIntervals()[1].getMin(), is(5));
    assertThat(rectangle.getIntervals()[1].getMax(), is(69));
  }

}
