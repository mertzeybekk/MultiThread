package Synchronized;

public class ThreadSafe {
    private int count=0;
    public void threadRun(){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
               for(int i=0;i<5000;i++){
                 countUp();
               }
            }
        });
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
              for(int i=0;i<5000;i++){
                 countUp();
              }
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
        System.out.println("count:" + count);
    }
    public synchronized void countUp(){
            count++;
    }
    /*
    synchronized anahtar kelimesi fonksiyona özgü değil sınıfa özgü olur ve bu durum ilerde sorunlara yol açabilir bunun çözümü ise birden çok lock anahtar kullanmak olur
    sorunun nedeni ise örnek diyelim iki fonksiyonumuz var ikisi de synchronized anahtar kelimesi ile yazılmış olsun ama synchronized kelimesi sınıfa özgü tekil olduğu için bir thread
    bir fonksiyona girince öteki fonksiyon başka thread e giremez.
     */
    public static  void main(String[]args){
          ThreadSafe thread=new ThreadSafe();
          thread.threadRun();
    }
}
