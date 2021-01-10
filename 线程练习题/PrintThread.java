package Homework;

public class PrintThread {
    private static int NUM = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(NUM++);
                }
            });
        }
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.println("OK");
    }
}