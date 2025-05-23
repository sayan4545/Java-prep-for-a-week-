package multithreadingAndConcurrency.implementsRunnable;

public class Main {
    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            for(int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+" "+ i);

            }
        },"Thread-Sayan");
        int count = Thread.activeCount();
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+ i);
        }
        t1.start();
        System.out.println(count);
    }
}
