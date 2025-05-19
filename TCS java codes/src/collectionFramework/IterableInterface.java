package collectionFramework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class IterableInterface {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);

        System.out.println(values);

        Iterator<Integer> valueIterator = values.iterator();
        while(valueIterator.hasNext()){
            int val = valueIterator.next();
            System.out.println(val);
            if(val == 3){
                valueIterator.remove();
            }
        }
        System.out.println(values);

        List<Integer> valuesModified = values.stream().map(val -> val *2).collect(Collectors.toList());
        System.out.println(valuesModified);


    }
}
