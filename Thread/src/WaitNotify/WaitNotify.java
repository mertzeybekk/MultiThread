package WaitNotify;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class WaitNotify{
    Object lock=new Object();
   public void produce(){
       try {
           Thread.sleep(1000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       synchronized (this){
           System.out.println("produce calisiyor");
           System.out.println("produce consumerin uyandirmasini bekliyor");
           try {
               wait(); //anahtarı teslim etti uyandırılmayı bekliyor

           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("producer uyandı devam ediyor");
       }
   }
   public void consume(){
       Scanner scanner=new Scanner(System.in);
       try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       synchronized (this){
           System.out.println("consume calisiyor");
           System.out.println("devam etmek icin bir tusa basin");
           scanner.nextLine();
           notify();
           try {
               Thread.sleep(2500);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("uyandirdim");
       }

   }
}
