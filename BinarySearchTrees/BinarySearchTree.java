package BinarySearchTrees;

import java.io.File;
import java.util.Scanner;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

    public BinarySearchTree( ) {
        root = null;
    }

    public void insert( AnyType x ) {
        root = insert( x, root );
    }

    public void remove( AnyType x ) {
        root = remove( x, root );
    }

    public void removeMin( ) {
        root = removeMin( root );
    }

    public AnyType findMin( ) {
        return elementAt( findMin( root ) );
    }

    public AnyType findMax( ) {
        return elementAt( findMax( root ) );
    }

    public AnyType find( AnyType x ) {
        return elementAt( find( x, root ) );
    }

    public void makeEmpty( ) {
        root = null;
    }

    public boolean isEmpty( ) {
        return root == null;
    }

    public int treeSize() {
        return treeSize(root);
    }

    public void printTree() {
        if(isEmpty( ))
            System.out.println( "The Tree is Empty" );
        else
        	printTree();   	     	
    }

    // Output file name with indentation
    public static void printName( String name, int depth ) {
        for( int i = 0; i < depth; i++ )
            System.out.print( " " );
            System.out.println( name );
    }

    public static void listAll( File dir ) {
        listAll( dir, 0 );
    }

    public static void listAll( File dir, int depth ) {
        printName( dir.getName( ), depth );
            if( dir.isDirectory( ) )
                for( File child : dir.listFiles( ) )
                    listAll( child, depth + 1 );
    }

    public static long size( File dir ) {
        long totalSize = dir.length( );
        if( dir.isDirectory( ) )
            for( File child : dir.listFiles( ) )
                totalSize += size( child );
        return totalSize;
    }

    private AnyType elementAt( BinaryNode<AnyType> t ) {
        return t == null ? null : t.element;
    }

    protected BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t ) {
        if( t == null )
            t = new BinaryNode<AnyType>( x );
        else if( x.compareTo( t.element ) < 0 )
            t.left = insert( x, t.left );
        else if( x.compareTo( t.element ) > 0 )
            t.right = insert( x, t.right );
        else
            /*throw new DuplicateItemException( x.toString( ) );  // Duplicate*/
            throw new IllegalArgumentException();
        return t;
    }

    protected BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t ) {
        if( t == null )
            /*throw new ItemNotFoundException( x.toString( ) );*/
            throw new IllegalArgumentException();
        if( x.compareTo( t.element ) < 0 )
            t.left = remove( x, t.left );
        else if( x.compareTo( t.element ) > 0 )
            t.right = remove( x, t.right );
        else if( t.left != null && t.right != null ) {
            t.element = findMin( t.right ).element;
            t.right = removeMin( t.right );
        }
        else
            t = ( t.left != null ) ? t.left : t.right;
        return t;
    }

    protected BinaryNode<AnyType> removeMin( BinaryNode<AnyType> t ) {
        if( t == null )
            /*throw new ItemNotFoundException( );*/
            throw new IllegalArgumentException();
        else if( t.left != null ) {
            t.left = removeMin( t.left );
            return t;
        }
        else
            return t.right;
    }    

    protected BinaryNode<AnyType> findMin( BinaryNode<AnyType> t ) {
        if(t != null && t.left != null)
            t = findMin(t.left);
        return t;

        //Non-recursive
        /*if( t != null )
            while( t.left != null )
                t = t.left;
        return t;*/
    }

    private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t ) {
        if(t != null && t.right != null)
            t = findMax(t.right);
        return t;
        
        //Non-recursive
        /*if( t != null )
            while( t.right != null )
                t = t.right;
        return t;*/
    }

    private BinaryNode<AnyType> find( AnyType x, BinaryNode<AnyType> t ) {
        //Non-recursive
        /*while( t != null ) {
            if( x.compareTo( t.element ) < 0 )
                t = t.left;
            else if( x.compareTo( t.element ) > 0 )
                t = t.right;
            else
                return t;*/

        while( t != null) {
            if(x.compareTo(t.element) < 0 )
                t = find(x, t.left);
            else if(x.compareTo(t.element) > 0)
                t = find(x, t.right);
            else return t;

        }
        return null;
    }

    private int treeSize(BinaryNode<AnyType> t) {
        if(t == null){
            return 0;
        }
        return 1 + treeSize(t.left) + treeSize(t.right);
     }

    private BinaryNode<AnyType> findKth(int k, BinaryNode<AnyType> t) {
        if(k == 1)
            return t;
        if(treeSize(t.left) < k) {
            k = k - treeSize(t.left) - 1;
            if(treeSize(t.right) < k){
                System.out.println("The Entire Tree Size is Smaller Than the Given K value");
        //think harder more needed, change approach/structure asap
            }
        }
        return t;
    }

        /*while( t != null ) {
            if( x.compareTo( t.element ) < 0 )
                t = t.left;
            else if( x.compareTo( t.element ) > 0 )
                t = t.right;
            else
                return t;

    }*/
    
    /*private void printTree(BinaryNode<AnyType> t, int height) {
        if(root == null)
            System.out.println("There is No Tree to Print");
    }*/

    protected BinaryNode<AnyType> root;


    public static void main( String [ ] args ) {
        char ch = 0;
        int choice, value;
        Scanner sc = new Scanner(System.in);
        BinarySearchTree<Integer> root = new BinarySearchTree<Integer>();
        do {
            System.out.println("Pick an Option");
            System.out.println("1. Insert an Element");
            System.out.println("2. Find Maximum");
            System.out.println("3. Find Minimum");
            System.out.println("4. Remove Minimum Value");
            System.out.println("5. Remove an Element");
            System.out.println("6. Find an Element");
            System.out.println("7. Print Tree");
            System.out.println("8. Make Tree Empty");
            System.out.println("9. Tree Size");
            //System.out.println("10. Print Tree");
            System.out.println("10. Find Kth Value");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter value to insert: ");
                    value = sc.nextInt();
                    root.insert(value);
                    break;
                case 2:
                    System.out.println("Maximum value is: " + root.findMax());
                    break;
                case 3:
                    System.out.println("Minimum value is: " + root.findMin());
                    break;
                case 4:
                    root.removeMin();
                    break;
                case 5:
                    System.out.println("Enter value to remove: ");
                    value = sc.nextInt();
                    root.remove(value);
                    break;
                case 6:
                    System.out.println("Enter Value To Find: ");
                    value = sc.nextInt();
                    if(root.find(value) != null)
                        System.out.println("Value Was Found");
                    if(root.find(value) == null)
                        System.out.println("Value Was Not Found");
                    break;
                case 7:
                    System.out.println("Printing Tree");
                    File dir = new File( "." );
                    listAll( dir );
                    System.out.println( "Total Bytes: " + size( dir ) );
                case 8:
                    root.makeEmpty();
                    System.out.println("Tree is Empty");
                case 9:
                    System.out.println("Tree Size is: " + root.treeSize());
                case 10:
                    System.out.println("Printing Tree");
                    root.printTree();
                case 11:
                    //findKth(input, t);
                    System.out.println("Kth value is: ");
                default:
                    break;
            }
            System.out.println("Do you want to continue? (Y/N)");
            sc.nextLine();
            ch = sc.nextLine().charAt(0);
        }
        while (ch == 'y' || ch == 'Y');
    }


        /*BinarySearchTree<Integer> t = new BinarySearchTree<Integer>( );
        final int NUMS = 4000;
        final int GAP  =   37;

        System.out.println( "Checking... (no more output means success)" );

        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            t.insert( i );

        for( int i = 1; i < NUMS; i += 2 )
            t.remove( i );

        if( t.findMin( ) != 2 || t.findMax( ) != NUMS - 2 )
            System.out.println( "FindMin or FindMax error!" );

        for( int i = 2; i < NUMS; i += 2 )
             if( t.find( i ) != i )
                 System.out.println( "Find error1!" );

        for( int i = 1; i < NUMS; i += 2 )
            if( t.find( i ) != null )
                System.out.println( "Find error2!" );

        System.out.println(t.findMax());
        System.out.println(t.findMin());
        System.out.println(t.find(2));
        System.out.println();*/
}
