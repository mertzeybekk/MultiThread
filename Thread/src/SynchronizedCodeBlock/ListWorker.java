package SynchronizedCodeBlock;

import java.util.ArrayList;
import java.util.Random;

public class ListWorker {
    Random random=new Random();
    ArrayList<Integer> list1=new ArrayList<>();
    ArrayList<Integer>list2=new ArrayList<>();
    Object lock1=new Object();
    Object lock2=new Object();
    public  void listOneAddValue(){
        synchronized (lock1){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }

    }
    public  void listTwoAddValue(){
        synchronized (lock2){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }

    }
    public  void addValue(){
        for(int i=0;i<1000;i++){
            listOneAddValue();
            listTwoAddValue();
        }
    }
    public void RunThread(){
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
             addValue();
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
            addValue();
            }
        });
        Long aLong=System.currentTimeMillis();
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long aLong1=System.currentTimeMillis();
        System.out.println("Zaman" + (aLong1-aLong));
        System.out.println("list1 " + list1.size());
        System.out.println("list2 " + list2.size());
    }
    /*
     Bu kod örneğinde zaman önemli olduğunu düşünerek iki anahtar yarattık bu sayede zamandan tasarruf sağlamayı amaçladık.Bu kodun çalışma mantığı şöyle
     thread1 addValue() fonk çağrıldığı zaman ilk olarak listOneAddValue() fonk çağırır bu fonk bloğunun giriş izni ise lock1 e ait thread1 bu anahtarı aldı
     bu sırada da thread2 listOneAddValue fonk girmeyi bekliyor thread1 işi bitince lock1 anahtarını bırakır ve thread2 alır
     */

}
