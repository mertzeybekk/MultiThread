package ThreadPoolandExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[]args){
        ExecutorService executorService= Executors.newFixedThreadPool(2); //aynı anda kaç thread çalışacak onu belirtir.
        for(int i=1;i<=5;i++){
            executorService.submit(new Worker(String.valueOf(i),i)); // işler teslim edildi
        }
       executorService.shutdown(); //threadlerin işi bitene kadar iş kabul etmez

        try {
            executorService.awaitTermination(1,  TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
   /*  Thread t1=new Thread(new Worker("1",1));
     Thread t2=new Thread(new Worker("2",2));
     Thread t3=new Thread(new Worker("3",3));
     Thread t4=new Thread(new Worker("4",4));
     Thread t5=new Thread(new Worker("5",5));
     t1.start();
     t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();
        t4.start();
        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t5.start();
        try {
            t5.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


    }
}
