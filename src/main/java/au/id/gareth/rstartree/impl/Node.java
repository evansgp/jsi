package au.id.gareth.rstartree.impl;

import au.id.gareth.rstartree.geometry.Rectangle;

import java.util.List;

public abstract class Node<U extends Comparable, T> {

  protected Rectangle<U> boundingBox;

  public Node(Rectangle boundingBox) {
    if(boundingBox == null) {
      throw new IllegalArgumentException("Bounding box must be supplied");
    }
    this.boundingBox = boundingBox;
  }

  public Rectangle<U> getBoundingBox() {
    return boundingBox;
  }

  //Algorithm "Search"
  public abstract List<LeafNode<U, T>> findLeaves(Rectangle<U> bounds);
}
