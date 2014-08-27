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

  @Test
  public void testOverlaps() {
    Rectangle<Integer> rectangle = new Rectangle<>(new Interval<>(-10,10), new Interval<>(-10,10));

    //equal, half and double scaled rectangle
    assertThat(rectangle.overlaps(new Rectangle<>(new Interval<>(-10, 10), new Interval<>(-10,10))), is(Boolean.TRUE));
    assertThat(rectangle.overlaps(new Rectangle<>(new Interval<>(-5, 5), new Interval<>(-5,5))), is(Boolean.TRUE));
    assertThat(rectangle.overlaps(new Rectangle<>(new Interval<>(-20, 20), new Interval<>(-20,20))), is(Boolean.TRUE));

    //exactly adjacent on each edge
    assertThat(rectangle.overlaps(new Rectangle<>(new Interval<>(-30, -10), new Interval<>(-10,10))), is(Boolean.TRUE));
    assertThat(rectangle.overlaps(new Rectangle<>(new Interval<>(-10, 10), new Interval<>(-30,-10))), is(Boolean.TRUE));
    assertThat(rectangle.overlaps(new Rectangle<>(new Interval<>(10, 30), new Interval<>(-10,10))), is(Boolean.TRUE));
    assertThat(rectangle.overlaps(new Rectangle<>(new Interval<>(-10, 10), new Interval<>(10,30))), is(Boolean.TRUE));

    //next smallest increment away on each edge
    assertThat(rectangle.overlaps(new Rectangle<>(new Interval<>(-31, -11), new Interval<>(-10,10))), is(Boolean.FALSE));
    assertThat(rectangle.overlaps(new Rectangle<>(new Interval<>(-10, 10), new Interval<>(-31,-11))), is(Boolean.FALSE));
    assertThat(rectangle.overlaps(new Rectangle<>(new Interval<>(11, 31), new Interval<>(-10,10))), is(Boolean.FALSE));
    assertThat(rectangle.overlaps(new Rectangle<>(new Interval<>(-10, 10), new Interval<>(11,31))), is(Boolean.FALSE));
  }

}
