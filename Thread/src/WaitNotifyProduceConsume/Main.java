package WaitNotifyProduceConsume;

public class Main {
    public static void main(String[]args){
        WaitNotify waitNotify=new WaitNotify();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
              waitNotify.produce();
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
            waitNotify.consume();
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

    }
}
