package BinarySearchTrees;

import java.io.File;
import java.util.Scanner;

public class BinaryTreeDriver {
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
}