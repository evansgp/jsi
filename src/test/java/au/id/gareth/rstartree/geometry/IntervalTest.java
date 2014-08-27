package au.id.gareth.rstartree.geometry;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class IntervalTest {

  private Interval<Integer> interval;

  @Before
  public void setup() {
    interval = new Interval<>(0, 10);
  }

  @Test
  public void testGetMax() throws Exception {
    assertThat(interval.getMax(), is(10));
  }

  @Test
  public void testGetMin() throws Exception {
    assertThat(interval.getMin(), is(0));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMinGreaterThanMax() {
    Interval<Integer> interval = new Interval<>(10, 0);
  }

  @Test
  public void testMinSameAsMax() {
    Interval<Integer> interval = new Interval<>(10, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullMin() {
    Interval<Integer> interval = new Interval<>(null, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullMax() {
    Interval<Integer> interval = new Interval<>(10, null);
  }

  @Test
  public void testOverlaps() {
    assertThat(interval.overlaps(new Interval<>(0,10)), is(Boolean.TRUE));
    assertThat(interval.overlaps(new Interval<>(0,11)), is(Boolean.TRUE));
    assertThat(interval.overlaps(new Interval<>(-1,10)), is(Boolean.TRUE));

    assertThat(interval.overlaps(new Interval<>(-1,0)), is(Boolean.TRUE));
    assertThat(interval.overlaps(new Interval<>(10,11)), is(Boolean.TRUE));

    assertThat(interval.overlaps(new Interval<>(5,6)), is(Boolean.TRUE));

    assertThat(interval.overlaps(new Interval<>(-2,-1)), is(Boolean.FALSE));
    assertThat(interval.overlaps(new Interval<>(11,12)), is(Boolean.FALSE));
  }

}