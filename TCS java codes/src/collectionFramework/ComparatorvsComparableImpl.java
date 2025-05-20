package collectionFramework;

import java.util.Arrays;
import java.util.Scanner;

public class ComparatorvsComparableImpl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car[] CarArray = new Car[3];
        CarArray[0] = new Car("TATA","SUV");
        CarArray[1] = new Car("HYUNDAI","SUV");
        CarArray[2] = new Car("MAHINDRA","SEDAN");

        Arrays.sort(CarArray,(Car obj1, Car obj2) -> obj2.name.length()-(obj1.name.length()));
        System.out.println(Arrays.toString(CarArray));

       Integer[] intArray = new Integer[4];
       for(int i =0;i<4;i++){
           intArray[i] = sc.nextInt();
       }
        System.out.println(Arrays.toString(intArray));
        Arrays.sort(intArray,(v1,v2)-> v1-v2);
        System.out.println(Arrays.toString(intArray));
        System.out.println("Sorting in descending order.");
        Arrays.sort(intArray,(v1,v2)->v2-v1);
        System.out.println(Arrays.toString(intArray));


        Arrays.sort(CarArray, new CarNameComparator());
        System.out.println(Arrays.toString(CarArray));
    }
}
