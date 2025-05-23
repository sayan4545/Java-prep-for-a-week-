package multithreadingAndConcurrency.thread02;

public class MyThread02 extends Thread{

    public void start(){
        super.start();
        System.out.println("Start method from the " + Thread.currentThread().getName());
    }
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " no args constructor");
    }


}
