package collectionFramework.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumPriorityQueueAndMaximumPriorityQueueImpl {
    public static void main(String[] args) {
//        Queue<Integer> MinPQ = new PriorityQueue<>((a,b)-> b-a);
//        Queue<Integer> MinPQ1 = new PriorityQueue<>();
//        MinPQ.add(1);
//        MinPQ.add(3);
//        MinPQ.add(2);
//        MinPQ1.add(1);
//        MinPQ1.add(3);
//        MinPQ1.add(2);
//        System.out.println("MinPQ1: "+ MinPQ1);
//        System.out.println("MinPQ: "+ MinPQ);
//
//        while(!MinPQ1.isEmpty()){
//            //MinPQ1.forEach(a-> System.out.println(a));
//            System.out.println("Removing from top: "+ MinPQ1.poll());
//
//        }

        Queue<Integer> q1 = new PriorityQueue<>();
        Queue<Integer> q2 = new PriorityQueue<>((Integer a, Integer b)-> b-a);
        q1.add(8);
        q1.add(5);
        q1.add(2);
        q1.add(1);
        q2.add(8);
        q2.add(5);
        q2.add(2);
        q2.add(1);
        System.out.println("Polling through the MinPriorityQueue");
        while(!q1.isEmpty()){
            int val = q1.poll();
            System.out.print(val +" ");
        }

        System.out.println();
        System.out.println("Polling through the MaxPriorityQueue");
        while(!q2.isEmpty()){
            int val = q2.poll();
            System.out.print(val+" ");
        }

    }
}
