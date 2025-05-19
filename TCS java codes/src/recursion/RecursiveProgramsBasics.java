package recursion;
public class RecursiveProgramsBasics {
    public static void main(String[] args) {
        System.out.println(factorialRecursive(3));
        System.out.println(fibonacci(8));
        System.out.println(findPower(2,3));
        count(5);
        System.out.println();
        System.out.println(climbStairs(3));
    }
    static int factorialRecursive(int n){
        if (n<2) return 1;
        return n * factorialRecursive(n-1);
    }
    static int fibonacci(int n){
        if(n==1) return 0;
        if(n==2) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }
    static int findPower(int n, int pow){
        if(pow == 0) return 1;
        if(n == 1) return 1;
        if(pow == 1) return n;
        return n * findPower(n,pow-1);
    }
    static int climbStairs(int n){
        if (n==0 || n==1) return 1;
        return climbStairs(n-1) + climbStairs(n-2);

    }
    static void count(int n){
        //bc
        if(n == 0) return;
        count(n-1);
        System.out.print(n+ " ");
    }
}
