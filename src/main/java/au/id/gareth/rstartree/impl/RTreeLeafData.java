package au.id.gareth.rstartree.impl;

import au.id.gareth.rstartree.geometry.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class RTreeLeafData<U extends Comparable, T> implements LeafData<U, T> {

  private final Integer maxNodes;
  private final Integer minNodes;
  private final List<RTreeDataHolder<T>> data = new ArrayList<>();

  public RTreeLeafData(Integer minNodes, Integer maxNodes) {
    if(minNodes > maxNodes / 2) {
      throw new IllegalArgumentException("minNodes must be less than half maxNodes");
    }

    this.minNodes = minNodes;
    this.maxNodes = maxNodes;
  }

  @Override
  public Boolean canAdd(T data, Rectangle<U> rectangle) {
    return null;
  }

  @Override
  public Boolean add(T data, Rectangle<U> rectangle) {
    return null;
  }

  @Override
  public Boolean remove(T data, Rectangle<U> rectangle) {
    return null;
  }

  private class RTreeDataHolder<T> {
    private final Rectangle boundingBox;
    private final T data;

    public RTreeDataHolder(Rectangle boundingBox, T data) {
      this.boundingBox = boundingBox;
      this.data = data;
    }

  }

}
