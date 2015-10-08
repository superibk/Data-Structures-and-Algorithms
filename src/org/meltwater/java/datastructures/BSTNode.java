package org.meltwater.java.datastructures;

public class BSTNode<E extends Comparable> {
    private E content;
    private BSTNode left;
    private BSTNode right;

    public BSTNode(E element)
    {
        E content = element;
        this.left = null;
        this.right = null;
    }


    public E getConent()
    { return this.content; }


    public BSTNode getLeft()
    {
        return this.left;
    }

    public void setLeft(BSTNode left)
    {
        this.left = left;
    }

    public BSTNode getRight()
    {
        return this.right;
    }

    public void setRight(BSTNode right)
    {
        this.right = right;
    } 

}
