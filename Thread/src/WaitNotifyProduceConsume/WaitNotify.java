package WaitNotifyProduceConsume;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class WaitNotify {
    Queue<Integer> queue=new LinkedList<Integer>();
    Random random=new Random();
    Object lock=new Object();
    private int Limit=10;
    public void produce(){
        while (true){
            synchronized (lock){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(queue.size()==Limit){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Integer value=random.nextInt(100);
                queue.offer( value);
                System.out.println("produce" + value );
                lock.notify();
            }

        }

    }
    public void consume(){
        while (true){
            synchronized (lock){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(queue.size()==0){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Integer value=queue.poll();
                System.out.println("consumer " + value);
                System.out.println("queue size" + queue.size());
                lock.notify();
            }
        }


    }
}
