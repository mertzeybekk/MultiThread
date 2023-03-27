package Thread1;

import Thread1.Printer;

public class Main {
    public static  void main(String[]args){
        Printer printer=new Printer("printer");
        Printer printer1=new Printer("printer1");
        printer.start();
        printer1.start();
        System.out.println("Main Thread Çalışır");
    }
}
