/**
 * 斐波那契数列
 * 0，1，2，3，4，5，6，...
 * 0，1，1，2，3，5，8，...
 *
 */
public class NO9_Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacciByRecursion(0));
        System.out.println(fibonacciByRecursion(1));
        System.out.println(fibonacciByRecursion(5));
        System.out.println(fibonacciByRecursion(-1));
        System.out.println();
        System.out.println(fibonacciByIteration(0));
        System.out.println(fibonacciByIteration(1));
        System.out.println(fibonacciByIteration(5));
        System.out.println(fibonacciByIteration(-1));
    }

    //递归解法
    public static long fibonacciByRecursion(int n) {
        if (n <= 0){
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacciByRecursion(n-1)+fibonacciByRecursion(n-2);
    }

    //循环解法
    public static long fibonacciByIteration(int n) {
        if (n<=0) {
            return 0;
        }
        if (n == 1 || n==2 ) {
            return 1;
        }
        long fibonacci = 0;
        long fibonacciOne = 1;
        long fibonacciTwo = 1;
        for (int i=3;i<=n;i++) {
            fibonacci = fibonacciOne+fibonacciTwo;
            fibonacciTwo = fibonacciOne;
            fibonacciOne = fibonacci;
        }
        return fibonacci;
    }
}
