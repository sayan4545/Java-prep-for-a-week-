package recursion;
public class RecursiveProgramsBasics {
    public static void main(String[] args) {
        System.out.println(factorialRecursive(3));
        System.out.println(fibonacci(8));
        System.out.println(findPower(2,3));
        count(5);
        System.out.println();
        System.out.println(climbStairs(3));
        System.out.println(powerOfThree(27));
        System.out.println(powerOfThree(1));
        System.out.println(powerOfThree(-1));
        System.out.println(powerOfThree(7));
        System.out.println("----------------------------------");

        printArray(new int[]{1,2,3,4,5},5);
        System.out.println("----------------------------------");
        int max = Integer.MIN_VALUE;
        System.out.println(findMaxRecursively(new int[]{1,4,5,6,3,2,9},0,max));
        System.out.println(isPresentInAString("Sayan",'a',0));


        System.out.println("----------------------------------------");
        printDigits(647);
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
    static boolean powerOfThree(int num){
        // bc
        if(num == 1) return true;
        if(num <= 0) return false;
        return (num %3 ==0) && powerOfThree(num/3);
    }
    static boolean powerOfFour(int num){
        if(num == 1) return true;
        if(num <= 0) return false;
        return (num % 4 == 0) && powerOfFour(num/4);
    }
    static void printArray(int[] arr, int i){
        if(i == arr.length) {
            System.out.println("Traversed whole length of the array , or the iterator is out of the array length.");
            return;
        }
        System.out.print(arr[i] + " ");
        i++;
        printArray(arr,i);
    }
    static int findMaxRecursively(int[] arr,int i,int max){

        // bc
        if(i == arr.length){
            System.out.println("Traversed whole length of the array, or iterator has been set out of the array size");
            return max;
        }
        if(arr[i] > max){
            max = arr[i];

        }
        return findMaxRecursively(arr,i+1, max);

    }

    static boolean isPresentInAString(String str, char c,int i){
        if(i == str.length()) return false;
        return str.charAt(i) == c || isPresentInAString(str,c,i+1);

    }

    static void printDigits(int num){
        if(num == 0) return;
        printDigits(num/10);
        System.out.print(num%10);


    }
}
