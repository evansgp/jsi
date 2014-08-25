package au.id.gareth.rstartree.geometry;

public class Rectangle<T extends Comparable> {

  //TODO: List/Collection? Immutability?
  private final Interval<T>[] intervals;

  public Rectangle(Interval<T>...intervals) {
    if(intervals == null || intervals.length == 0) {
      throw new IllegalArgumentException("Intervals must be supplied");
    }
    this.intervals = intervals;
  }

  public Interval<T>[] getIntervals() {
    return this.intervals;
  }

}
