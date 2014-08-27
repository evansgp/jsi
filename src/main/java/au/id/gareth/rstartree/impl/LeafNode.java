package au.id.gareth.rstartree.impl;

import au.id.gareth.rstartree.geometry.Rectangle;

import java.util.List;

public class LeafNode<U extends Comparable, T> extends Node<U, T> {

  //leaf data may itself be an array/list as per the original algorithm
  private LeafData<U, T> leafData;

  public LeafNode(Rectangle<U> boundingBox) {
    super(boundingBox);
  }

  @Override
  public List<LeafNode<U, T>> findLeaves(Rectangle<U> bounds) {
    return null;
  }
}
