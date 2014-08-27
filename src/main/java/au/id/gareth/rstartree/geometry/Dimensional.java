package au.id.gareth.rstartree.geometry;

public abstract class Dimensional<T> {

  //TODO: List/Collection? Immutability?
  protected final T[] values;

  public Dimensional(T...values) {
    if(values == null || values.length == 0) {
      throw new IllegalArgumentException("Values must be supplied");
    }
    this.values = values;
  }

  public Integer getDimensions() {
    return values.length;
  }

  public Boolean hasDimensionsOf(Dimensional dimensional) {
    return this.getDimensions() == dimensional.getDimensions();
  }
}
