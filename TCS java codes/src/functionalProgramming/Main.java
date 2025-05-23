package functionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        MathOperation add = (a,b) -> a+b;
        int res = add.operate(6,7);
        System.out.println(res);

        //Predicate -- test() -- boolean valued function . A functional interface

        Predicate<Integer> isEven = x -> x%2==0;
        System.out.println(isEven.test(9));

        Predicate<String> isStartsWithA = a-> a.startsWith("A");
        Predicate<String> isEndsWithA = x ->x.endsWith("A");
        Predicate<String> andFunctionalities = isStartsWithA.and(isEndsWithA);
        System.out.println("Checking the and functionalities: " + andFunctionalities.test( "AAAA"));

        // Function --> functional interface --> introduced in java 8

        Function<Integer,Integer> doubleIt = a -> a*2;
        System.out.println(doubleIt.apply(3));

        Function<Integer,Integer> tripleIt = a -> a*3;
        Function<Integer,Integer> andThenImplementation = doubleIt.andThen(tripleIt);
        System.out.println(andThenImplementation.apply(8));

        Function<Integer,Integer> addUp = x -> x+3;
        Function<Integer,Integer> multiplyUpBy2 = x -> x*2;

        Function<Integer,Integer> addDemo = addUp.andThen(multiplyUpBy2);
        Function<Integer,Integer> composeDemo = addUp.compose(multiplyUpBy2);

        System.out.println("Add demo : "+ addDemo.apply(5));
        System.out.println("Compose demo :"+ composeDemo.apply(5));

        Function<Integer,Integer> identityDemo = Function.identity();
        Integer id = identityDemo.apply(7);
        System.out.println(id);

        // Consumer --> functional interface . abstract function --> void accept(T t) --> accepts but donot return anything.

        Consumer<Integer> consumeDemo = a-> System.out.println(a*2);
        consumeDemo.accept(6);

        List<Integer> list = Arrays.asList(1,2,3,4);
        Consumer<List<Integer>> listConsume = a->{
            for(Integer c : a){
                System.out.print(c +" ");
            }
        };

        listConsume.accept(list);

        Consumer<List<Integer>> consumeAndThenDemo = x->{
            for(Integer a : x){
                a = a*2;
            }
        };

        consumeAndThenDemo.andThen(listConsume).accept(list);

        System.out.println();
        // supplier


        Supplier<String> giveHelloWorld = () -> "Hello World!";

        System.out.println(giveHelloWorld.get());

        // mixed example
        Predicate<Integer> ifEven = x->x%2==0;
        Function<Integer,Integer> function = x->x*x;
        Consumer<Integer> consumer = System.out::println;
        Supplier<Integer> supplier = () -> 7;
        System.out.println("<<--result -->>");
        if(ifEven.test(supplier.get())){
            consumer.accept(function.apply(supplier.get()));
        }


        // BiPredicate, BiConsumer, BiFunction
        BiPredicate<Integer,Integer> isSumEven = (x,y)-> (x+y)%2==0;
        isSumEven.test(8,8);
        BiFunction<Integer,Integer,Integer> bifunc = (x,y)-> x*y;
        BiConsumer<Integer,Integer> biCon = (x,y)-> System.out.println(bifunc.apply(x,y));


        biCon.accept(6,7);

        List<String> listOfString = new ArrayList<>(Arrays.asList("A","B","C"));
        List<MobilePhone> listOfMobilePhones = listOfString.stream().map(MobilePhone::new).toList();
        listOfMobilePhones.forEach(System.out::println);



    }
    static class MobilePhone{
        String name;
        public MobilePhone(String name){
            this.name = name;
        }
        public String toString(){
            return this.name +" ";
        }
    }
}


