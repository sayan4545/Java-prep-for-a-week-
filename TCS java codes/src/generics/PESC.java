package generics;

import java.util.List;

public class PESC {

    public static void displayList(List<? extends Number> listOfNumbers){
        for(Number n : listOfNumbers){
            System.out.println(n);
        }
    }
}
