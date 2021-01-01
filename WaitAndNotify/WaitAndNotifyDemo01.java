package HMThread.WaitAndNotify;
/**
 * 等待唤醒案例，：线程之间的通信
 */
public class WaitAndNotifyDemo01 {
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
                        System.out.println("告知老板要的包子的种类和数量");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("拿到包子了，开吃。");
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
                        obj.notify();
                    }
                }
            }
        }.start();
    }
}
