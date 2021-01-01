package HMThread.WaitAndNotify;

/**
 *
 */
public class WaitAndNotifyDemo02 {
    public static void main(String[] args) {
        //创建锁对象，保证唯一
        Object obj = new Object();
        //创建一个顾客线程（消费者）
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    //保证等待和唤醒有一个执行
                    synchronized (obj) {
                        System.out.println("顾客1告知老板要的包子的种类和数量");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("拿到包子了，顾客1开吃。");
                        System.out.println("----------------------");
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    //保证等待和唤醒有一个执行
                    synchronized (obj) {
                        System.out.println("顾客2告知老板要的包子的种类和数量");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("拿到包子了，顾客2开吃。");
                        System.out.println("----------------------");
                    }
                }
            }
        }.start();

        //创建一个老板线程（生产者）
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    //花费5秒做包子
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj) {
                        System.out.println("老板5秒钟之后告诉顾客可以吃包子了");
                        //obj.notify();
                        obj.notifyAll();
                    }
                }
            }
        }.start();
    }
}
