package multithreadingAndConcurrency.thread02;

public class Main {
    public static void main(String[] args) {
//        MyThread t1 = new MyThread();
//        //t1.start();
//        t1.run();
//        for(int i=0;i<10;i++){
//            System.out.println(Thread.currentThread().getName());
//        }
//        System.out.println("Main thread finishes");
        MyThread02 t2 = new MyThread02();
        t2.start();

    }
}
