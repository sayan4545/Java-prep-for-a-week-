public class PrintName {
    public static void printName(String name, int i){
        // base condition
        if(i==5) return;
        //System.out.println(name+" "+ i++);
        printName(name,i+1);
        System.out.println(name+" "+i++);
    }
    public static void printNumber(int number){
        if(number == 10) return;
        //System.out.println(number);
        printNumber(number+1);
        System.out.println(number);
       // System.out.println(rec(5));
    }

    public static void main(String[] args) {
        //printName("Chandrika",0);
       // printNumber(0);
       // System.out.println(rec(100));
        rec3(1);

    }
    public static int rec(int n){
        if(n<=1) return 1;
        else{
            return 2*rec(n-1) +n;
        }
    }

    public static int rec2(int n){
        if(n==1) return 1;
        return rec2(n-1) + rec2(n-1);
    }
    public static void rec3(int n){
        if(n==10) return ;
        else{

            for(int i = 1;i<=n;i++){
                System.out.print(i+" ");
            }
            System.out.println();
            rec3(n+1);
        }
    }
}
