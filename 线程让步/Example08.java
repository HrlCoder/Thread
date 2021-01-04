package ThreadExample.线程让步;

/**
 * 线程让步
 */
public class Example08 {
    public static void main(String[] args) {
        Thread t1 = new YieldThread("线程A");
        Thread t2 = new YieldThread("线程B");
        t1.start();
        t2.start();
    }
}

class YieldThread extends Thread {
    public YieldThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println(Thread.currentThread().getName()+"---"+i);
            if(i == 3) {
                System.out.print("线程让步：");
                Thread.yield();
            }
        }
    }
}