package functionalProgramming.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        // streams --> to process collections of data in declarative and functional manner
        //introduced in java8
        // How to use streams? -- source, intermediate operations, terminal operatons

        List<Integer> l1 = Arrays.asList(1,2,3,4,5,6,7,8);
        System.out.println("The original list: "+ l1);
        // find the even ntegers from the list

        List<Integer> evenStrem= l1.stream().filter(x-> x%2==0).toList();
        System.out.println("The updated stream: " + evenStrem);

        // count the integers that are even
        System.out.println("The count of even integers are : "+ l1.stream().filter(x->x%2==0).count());

        // creating streams
        // from collections
        List<String> strList = new ArrayList<>(Arrays.asList("Sayan","Chandrika","Monlithisc"));
        Stream<String> strListStream  = strList.stream();

        // from arrays
        String[] strArray = {"A","B","C"};
        Stream<String> strArrayStream = Arrays.stream(strArray);

        // Using stream.of()

        Stream<String> strOf = Stream.of("ABC", "CDA", "MNOP");

        // infinite stream
        Stream<Integer> streamGenerateInfinite = Stream.generate(()->1).limit(10);
        streamGenerateInfinite.forEach(System.out::println);

        Stream.
                iterate(2,x-> x*2).
                limit(4).
                forEach(System.out::println);


    }
}
