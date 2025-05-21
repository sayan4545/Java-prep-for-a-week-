package generics;


class Object{

}
class Animal extends Object{

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
        Home<Cat> catHome = new Home<>(new Cat(),new Cat());
        Home<Dog> dogHome = new Home<>(new Dog(),new Dog());

    }
}
