package au.id.gareth.rstartree.geometry;

/**
 * A closed bounded interval along a dimension.
 */
public class Interval<U extends Comparable> {

  private final U min;
  private final U max;

  public Interval(U min, U max) {
    if(min == null || max == null) {
      throw new IllegalArgumentException("Both min ("+min+") and max ("+max+") must be supplied");
    }
    if(min.compareTo(max) > 0) {
      throw new IllegalArgumentException("Minimum (" + min + ") was larger than the maximum (" + max +")");
    }
    this.min = min;
    this.max = max;
  }

  public U getMax() {
    return max;
  }

  public U getMin() {
    return min;
  }

  public Boolean overlaps(Interval<U> interval) {
    if(interval.getMax().compareTo(this.getMin()) >= 0
        && interval.getMin().compareTo(this.getMax()) <= 0) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }
}
