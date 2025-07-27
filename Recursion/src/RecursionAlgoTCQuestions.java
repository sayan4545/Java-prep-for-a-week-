public class RecursionAlgoTCQuestions {
    //1
    public static int rec(int n){
        if(n<=1) return 1;
        return rec(n-1);
    }
    //2
    public static int rec1(int n){
        if(n==1) return 1;
        return rec1(n/2)+n;
    }
    //3
    public static int rec2(int n){
        if(n==1) return 1;
        return rec2(n/2) + rec2(n/2) + n;
    }
}
