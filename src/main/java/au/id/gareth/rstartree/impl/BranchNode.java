package au.id.gareth.rstartree.impl;

import au.id.gareth.rstartree.geometry.Rectangle;

public class BranchNode<T extends Comparable> extends Node<T> {

  private Node<T> children;

  public BranchNode(Rectangle boundingBox) {
    super(boundingBox);
  }
}
