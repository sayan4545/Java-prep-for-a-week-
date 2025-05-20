package collectionFramework.listInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListImpl {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        ListIterator<Integer> iterator1 = l1.listIterator();
        while(iterator1.hasNext()){
            System.out.print(iterator1.next()+" ");
        }
        System.out.println();
        System.out.println("Implementing the hasPrevious() and previous() methods..");
        while(iterator1.hasPrevious()){
            System.out.print(iterator1.previous()+" ");
        }
    }
}
