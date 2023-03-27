package Thread1;

public class Printer extends Thread{
    private String name;
    public Printer(String name){
        this.name=name;
    }

    @Override
    public void run() {
        System.out.println(this.name + " working ");
        for(int i=0;i<10;i++){
            System.out.println(name + " reading : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread Stop");
            }
        }
    }
}
