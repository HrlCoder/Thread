package HMThread.Lambda;

public class DemoLambda {
    public static void main(String[] args) {
        new Thread(()-> {
            System.out.println(Thread.currentThread().getName()+"新的线程创建了");
        }).start();

        new Thread(()->System.out.println(Thread.currentThread().getName()+"新的线程创建了")).start();
    }
}
