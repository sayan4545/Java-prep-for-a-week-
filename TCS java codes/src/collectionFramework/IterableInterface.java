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
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        l1.add(1);
        l1.add(10);
        l1.add(100);
        l1.add(200);
        l1.add(300);
        l1.add(400);
        l2.add(2);
        l2.add(20);
        l2.add(200);
        l2.add(300);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l1.isEmpty());
        System.out.println(l2.contains(300));

    }
}
