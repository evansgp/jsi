package au.id.gareth.rstartree.impl;

import au.id.gareth.rstartree.geometry.Rectangle;

public interface LeafData<U extends Comparable, T> {

  public Boolean canAdd(T data, Rectangle<U> rectangle);
  public Boolean add(T data, Rectangle<U> rectangle);
  public Boolean remove(T data, Rectangle<U> rectangle);


}
