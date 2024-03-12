public class Recursion {

    // Evaluate the sum of the first n integers
    public static long s(int n) {
        if(n == 1)
            return 1;
        else
            return s(n - 1) + n;
    }

    // Print n in base 10, recursively
    // Precondition: n >= 0
    public static void printDecimal(long n) {
        if(n >= 10)
            printDecimal(n / 10);
        System.out.print((char)('0' + (n % 10)));
    }

    private static final String DIGIT_TABLE = "0123456789abcdef";
    // Print n in any base, recursively
    // Precondition: n >= 0, base is valid
    public static void printInt(long n, int base){
        if(n >= base)
            printInt(n / base, base);
        System.out.print(DIGIT_TABLE.charAt((int)(n % base)));
    }

    public final class PrintInt{
        private static final String DIGIT_TABLE = "0123456789abcdef";
        private static final int MAX_BASE = DIGIT_TABLE.length();
        // Print n in any base, recursively
        // Precondition: n >= 0, 2 <= base <= MAX_BASE
        private static void printIntRec(long n, int base){
            if(n >= base)
                printIntRec(n / base, base);
            System.out.print(DIGIT_TABLE.charAt((int)(n % base)));
        }
        // Driver routine
        public static void printInt(long n, int base){
            if(base <= 1 || base > MAX_BASE)
                System.err.println("Cannot print in base " + base);
            else{
                if(n <0)
                {
                    n = -n;
                    System.out.print("-");
                }
                printIntRec(n, base);
            }    
        }
    }

    // Compute the Nth Fibonacci number
    // Bad algorithm 
    public static long fib(int n) {
        if(n <= 1)
            return n;
        else
            return fib(n - 1) + fib(n - 2);
    }

}
