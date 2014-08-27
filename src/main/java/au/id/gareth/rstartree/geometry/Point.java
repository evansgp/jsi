package au.id.gareth.rstartree.geometry;

public class Point<U extends Comparable> extends Dimensional<U> {

  public Point(U...values) {
    super(values);
  }

  public U[] getValues() {
    return values;
  }

}
