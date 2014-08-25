package au.id.gareth.rstartree.geometry;

public class Point<T extends Comparable> {

  //TODO: List/Collection? Immutability?
  private final T[] values;

  public Point(T...values) {
    if(values == null || values.length == 0) {
      throw new IllegalArgumentException("Values must be supplied");
    }
    this.values = values;
  }

  public T[] getValues() {
    return values;
  }



}
