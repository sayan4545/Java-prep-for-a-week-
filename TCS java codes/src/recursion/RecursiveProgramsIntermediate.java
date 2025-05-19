package recursion;

public class RecursiveProgramsIntermediate {
    public static void main(String[] args) {
        System.out.println(isSorted(new int[]{1,2,2,2,2,2,3,4,3,6},0));
    }
    static boolean isSorted(int[] arr, int i){
        if(i >= arr.length-1) return true;
        if(arr[i]> arr[i+1]) return false;
        return isSorted(arr,i+1);
    }
}
