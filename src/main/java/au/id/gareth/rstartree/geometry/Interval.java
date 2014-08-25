package au.id.gareth.rstartree.geometry;

/**
 * A closed bounded interval along a dimension.
 */
public class Interval<T extends Comparable> {

  private final T min;
  private final T max;

  public Interval(T min, T max) {
    if(min == null || max == null) {
      throw new IllegalArgumentException("Both min ("+min+") and max ("+max+") must be supplied");
    }
    if(min.compareTo(max) > 0) {
      throw new IllegalArgumentException("Minimum (" + min + ") was larger than the maximum (" + max +")");
    }
    this.min = min;
    this.max = max;
  }

  public T getMax() {
    return max;
  }

  public T getMin() {
    return min;
  }
}
