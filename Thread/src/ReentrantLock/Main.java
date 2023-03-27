package ReentrantLock;

public class Main {
    public static void main(String[]args){
        ReentrantLockk reentrantLockk=new ReentrantLockk();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
             reentrantLockk.threadOne();
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLockk.threadTwo();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reentrantLockk.show();

    }
}
