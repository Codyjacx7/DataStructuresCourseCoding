/*package BinarySearchTrees;

import java.util.NoSuchElementException;


abstract class TreeIterator<AnyType> {
    //Construct the iterator, current position set to null
    public TreeIterator(BinaryTree<AnyType> theTree){
        t = theTree;
        current = null;
    }
    //Test if current position references a valid tree, returns true if current position is not null
    final public boolean isValid(){
        return current != null;
    }
    //Returns the item stored at current position
    final public AnyType retrieve(){
        if(current == null)
            throw new NoSuchElementException();
        return current.getElement();
    }

    abstract public void first();
    abstract public void advance();

    //Root
    protected BinaryTree<AnyType> t;
    //Current
    protected BinaryNode<AnyType> current;
}
/*
class PostOrder<AnyType> extends TreeIterator<AnyType>{
    protected static class StNode<AnyType>{
        StNode(BinaryNode<AnyType> n){
            node = n;
            timesPopped = 0;
        }
        BinaryNode<AnyType> Node;
        int timesPopped;
    }
    //Construct iterator, current is set to null
    public PostOrder(BinaryTree<AnyType> theTree){
        super(theTree);
        s = new ArrayStack<StNode<AnyType>>();
    }
}
*/