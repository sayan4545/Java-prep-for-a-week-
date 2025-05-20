package collectionFramework;

import java.util.Comparator;

public class CarNameComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        if(o1.name.length() == o2.name.length()) return 1;
        else if(o2.name.length() > o1.name.length()) return 1;
        else {
            return -1;
        }

    }
}
