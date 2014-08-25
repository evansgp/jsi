package au.id.gareth.rstartree.impl;

import au.id.gareth.rstartree.geometry.Rectangle;

public class LeafNode<T extends Comparable> extends Node<T> {

  //leaf data may itself be an array/list as per the original algorithm
  private LeafData leafData;

  public LeafNode(Rectangle boundingBox) {
    super(boundingBox);
  }

}
