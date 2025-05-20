package collectionFramework;

import java.util.Comparator;

public class Car implements Comparable<Car> {
    private String name;
    private String type;

    public Car(String name, String type){
        this.name = name;
        this.type = type;
    }



    @Override
    public int compareTo(Car o) {
        return o.name.length()-this.name.length();
    }
    @Override
    public String toString(){
        return "name : "+ this.name +":: "+ "type: "+ this.type;
    }
}
