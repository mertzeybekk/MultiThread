package ReentrantLock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockk {
    private int count=0;
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    public void countUp(){
        for (int i=0;i<10000;i++){count++;}
    }
    public void threadOne(){
        lock.lock();
        System.out.println("threadOne uyandirilmayi bekliyor");
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }System.out.println("threadOne uyandi devam ediyor");
        countUp();
        lock.unlock();
    }
    public void threadTwo(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Scanner scanner=new Scanner(System.in);
        lock.lock();
        System.out.println("threadTwo calisiyor");
        countUp();
        scanner.nextLine();
        condition.signal();
        lock.unlock();
    }
    public void show(){
        System.out.println("count" + count);
    }
}
