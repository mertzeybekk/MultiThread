package WaitNotify;

public class Main{
    public static void main(String[]args){
        WaitNotify waitNotify=new WaitNotify();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                waitNotify.produce();
            }
        });
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
             waitNotify.consume();
            }
        });
        thread.start();
        thread1.start();
        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
