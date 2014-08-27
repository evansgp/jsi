package au.id.gareth.rstartree.geometry;

import java.util.Arrays;
import java.util.Iterator;

public class Rectangle<U extends Comparable> extends Dimensional<Interval<U>> {

  public Rectangle(Interval<U>...intervals) {
    super(intervals);
  }

  public Interval<U>[] getIntervals() {
    return this.values;
  }

  public Boolean overlaps(Rectangle<U> rectangle) {
    if(!this.hasDimensionsOf(rectangle)) {
      throw new IllegalArgumentException("Dimensions of rectangles differ");
    }
    Iterator<Interval<U>> iterator = Arrays.asList(this.values).iterator();
    for(Interval interval : rectangle.getIntervals()) {
      if(!interval.overlaps(iterator.next())) {
        return Boolean.FALSE;
      }
    }
    return Boolean.TRUE;
  }

}
