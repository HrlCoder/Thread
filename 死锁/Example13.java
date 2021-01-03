package ThreadExample.死锁;

class DeadLockThread implements Runnable{
    //定义Object类型的chopsticks锁对象
    static Object chopsticks = new Object();
    //定义Object类型的knifeAndFork锁对象
    static Object knifeAndFork = new Object();

    private boolean flag;
    DeadLockThread(boolean flag) {
        this.flag = flag;
    }
    @Override
    public void run() {
        if(flag) {
            while (true) {
                //chopsticks锁对象上的同步代码块
                synchronized (chopsticks) {
                    System.out.println(Thread.currentThread().getName()+"---if---chopsticks");
                    //knifeAndFork锁对象上的同步代码块
                    synchronized (knifeAndFork) {
                        System.out.println(Thread.currentThread().getName()+"---if---knifeAndFork");
                    }
                }
            }
        } else {
            while (true) {
                //knifeAndFork锁对象上的同步代码块
                synchronized (knifeAndFork) {
                    System.out.println(Thread.currentThread().getName()+"---if---knifeAndFork");
                    //chopsticks锁对象上的同步代码块
                    synchronized (chopsticks) {
                        System.out.println(Thread.currentThread().getName() + "---if---chopsticks");
                    }
                }
            }
        }
    }
}

public class Example13 {
    public static void main(String[] args) {
        //创建两个DeadLockThread对象
        DeadLockThread d1 = new DeadLockThread(true);
        DeadLockThread d2 = new DeadLockThread(false);
        //创建并开启两个线程
        new Thread(d1,"Chinese").start();
        new Thread(d2,"American").start();
    }
}
