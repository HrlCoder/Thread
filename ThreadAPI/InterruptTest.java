package ThreadAPI;

public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                for (int i = 0; i < 10000 && !Thread.currentThread().isInterrupted();i++) {
                    System.out.println(i);
                        Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        System.out.println("t start");
        Thread.sleep(5000);
        t.interrupt();
        System.out.println("t stop");
    }
}
