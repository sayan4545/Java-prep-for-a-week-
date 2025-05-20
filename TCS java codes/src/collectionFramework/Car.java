package collectionFramework;

import java.util.Comparator;

public class Car{
    public String name;
    public String type;

    public Car(String name, String type){
        this.name = name;
        this.type = type;
    }




    @Override
    public String toString(){
        return "name : "+ this.name +":: "+ "type: "+ this.type;
    }


}
