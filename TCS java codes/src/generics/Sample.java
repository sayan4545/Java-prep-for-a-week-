package generics;

import java.util.List;

public class Sample {

    public static <T extends Number> double DoubleSum(List<T> listOfValues){
        int sum = 0;
        for(T values : listOfValues){
            sum += values.doubleValue();
        }
        return sum;
    }
}
