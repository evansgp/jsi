package au.id.gareth.rstartree.impl;

import au.id.gareth.rstartree.geometry.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class BranchNode<U extends Comparable, T> extends Node<U, T> {

  private final List<Node<U, T>> children = new ArrayList<>();
  private final Integer minNodes;
  private final Integer maxNodes;

  public BranchNode(Rectangle<U> boundingBox, Integer minNodes, Integer maxNodes) {
    super(boundingBox);
    if( minNodes > maxNodes / 2 ) {
      throw new IllegalArgumentException("minNodes in greater than half maxNodes");
    }
    this.minNodes = minNodes;
    this.maxNodes = maxNodes;
  }

  @Override
  public List<LeafNode<U, T>> findLeaves(Rectangle<U> bounds) {

    for(Node<U, T> child : children) {
      //if(child.getBoundingBox())
    }

    return null;
  }

}
