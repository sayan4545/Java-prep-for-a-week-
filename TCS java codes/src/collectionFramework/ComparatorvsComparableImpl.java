package collectionFramework;

import java.util.Arrays;

public class ComparatorvsComparableImpl {
    public static void main(String[] args) {
        Car[] CarArray = new Car[3];
        CarArray[0] = new Car("TATA","SUV");
        CarArray[1] = new Car("HYUNDAI","SUV");
        CarArray[2] = new Car("MAHINDRA","SEDAN");

        Arrays.sort(CarArray);
        System.out.println(Arrays.toString(CarArray));

    }
}
