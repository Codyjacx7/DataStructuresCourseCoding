package BinarySearchTrees;


class BinaryNode<AnyType>
{
        // Constructor
    BinaryNode( AnyType theElement )
    {
        element = theElement;
        left = right = null;
    }

      // Data; accessible by other package routines
    AnyType             element;  // The data in the node
    BinaryNode<AnyType> left;     // Left child
    BinaryNode<AnyType> right;    // Right child
}






/*class BinaryNode<AnyType> {
    public BinaryNode(){
        this(null, null, null);
    }
    public BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt){
        element = theElement;
        left = lt;
        right = rt;
    }
    public AnyType getElement(){
        return element;
    }
    public BinaryNode<AnyType> getLeft(){
        return left;
    }
    public BinaryNode<AnyType> getRight(){
        return right;
    }
    public void setElement(AnyType x){
        element = x;
    }
    public void setLeft(BinaryNode<AnyType> t){
        left = t;
    }
    public void setRight(BinaryNode<AnyType> t){
        right = t;
    }
    
    public static <AnyType> int size(BinaryNode<AnyType> t){
        if(t == null)
            return 0;
        else
            return 1 + size(t.left) + size(t.right);
    }
    public static <AnyType> int height(BinaryNode<AnyType> t){
        if(t == null)
            return -1;
        else
            return 1 + Math.max(height(t.left), height(t.right));
    }
    public BinaryNode<AnyType> duplicate(){
        BinaryNode<AnyType> root = new BinaryNode<AnyType>( element, null, null);
        if(left != null)
            root.left = left.duplicate();
        if(right != null)
            root.right = right.duplicate();
        return root;
    }
    public void printPreOrder(){
        System.out.println(element);
        if(left != null)
            left.printPreOrder();
        if(right != null)
            right.printPreOrder();
    }
    public void printPostOrder(){
        if(left != null)
            left.printPostOrder();
        if(right != null)
            right.printPostOrder();
        System.out.println(element);
    }
    public void printInOrder(){
        if(left != null)
            left.printInOrder();
        System.out.println(element);
        if(right != null)
            right.printInOrder();
    }
    private AnyType element;
    private BinaryNode<AnyType> left;
    private BinaryNode<AnyType> right;
}
*/