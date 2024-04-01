package BinarySearchTrees;
import java.io.File;

public class PrintBST {
// Output file name with indentation
    public static void printName( String name, int depth ) {
        for( int i = 0; i < depth; i++ )
            System.out.print( " " );
            System.out.println( name );
    }

// Public driver to list all files in directory
    public static void listAll( File dir ) {
        listAll( dir, 0 );
    }

 // Recursive method to list all files in directory
    private static void listAll( File dir, int depth ) {
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

 // Simple main to list all files in current directory
     public static void main( String [ ] args ) {
        File dir = new File( "." );
        listAll( dir );
        System.out.println( "Total bytes: " + size( dir ) );
    }
 }
