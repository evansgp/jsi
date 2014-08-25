package au.id.gareth.rstartree.impl;

import au.id.gareth.rstartree.geometry.Rectangle;

public class Node<T extends Comparable> {

  protected Rectangle<T> boundingBox;

  public Node(Rectangle boundingBox) {
    if(boundingBox == null) {
      throw new IllegalArgumentException("Bounding box must be supplied");
    }
    this.boundingBox = boundingBox;
  }

  public Rectangle<T> getBoundingBox() {
    return boundingBox;
  }
}
