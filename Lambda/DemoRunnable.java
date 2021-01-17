package HMThread.Lambda;

public class DemoRunnable {
    public static void main(String[] args) {
        RunnableImpl run = new RunnableImpl();
        Thread t = new Thread(run);
        t.start();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"新的线程创建了");
            }
        };
        new Thread(r).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"新的线程创建了");
            }
        }).start();


    }
}
