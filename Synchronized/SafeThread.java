package Synchronized;

public class SafeThread {
    public static int COUNT = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        synchronized (SafeThread.class) {
                            COUNT++;
                        }
                    }
                }
            });
        }
        for (Thread t : threads) {
            t.start();
        }
        //让主线程等待所有的子线程执行完毕
        for (Thread t : threads) {
            t.join();
        }
        System.out.println(COUNT);
    }
}
