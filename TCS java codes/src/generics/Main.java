package generics;


import java.util.ArrayList;
import java.util.List;

import static generics.PESC.displayList;
import static generics.Sample.DoubleSum;

class Object{

}
class Animal extends Object{
    void makeSound(){
        System.out.println(this + "makes sound");
    }

    public static void displayAnimals(List<? extends Animal> listOfAnimals){
        for(Animal an : listOfAnimals){
            System.out.println(an);
        }
    }

}
class Dog extends Animal{

}
class Cat extends Animal{


}
class BritishShortHair extends Cat{

}
class Husky extends Dog{

}
class Home<T extends Animal>{ // This is unbounded restrictions. The Home class can have Integer, String etc as the type
    // that is not expected behaviour. Animal is the upperbound
    private T animal1;
    private T animal2;

    public T getAnimal1(){
        animal1.makeSound();
        return animal1;
    }
    public T getAnimal2(){
        return animal2;
    }
    public Home(T animal1, T animal2){
        this.animal1 = animal1;
        this.animal2 = animal2;
    }
}
public class Main {
    public static void main(String[] args) {
//        Home<Husky> huskyHome = new Home<>(new Husky(),new Husky());
//        Home<Dog> dogHome = new Home<>(new Dog(),new Dog());
//        dogHome.getAnimal1();

//        List<Integer> listOfIntegers = new ArrayList<>();
//        listOfIntegers.add(12);
//        listOfIntegers.add(10);
//        System.out.println(DoubleSum(listOfIntegers));
//
//        List<? extends Number> list1;
//        list1 = new ArrayList<Double>();
//        // The above list declaration, bars us from accessing the methods to write.
//        // since it dont have the access to the initialization type parameter.

        List<Integer> l1 = List.of(1,2,3);
        displayList(l1);
        System.out.println("--------------");
        List<Double> l2 = new ArrayList<>();
        l2.add(1.0);
        l2.add(6.8);
        displayList(l2);
        System.out.println("---------------");

        List<? extends Number> l3 = List.of(23,78,99);
        displayList(l3);

        List<? extends Animal> a1 = List.of(new Dog(),new Husky());
        Animal.displayAnimals(a1);
        List<? extends Animal> a2 = List.of(new Cat(),new BritishShortHair());











    }
}
