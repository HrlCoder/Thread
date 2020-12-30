package Synchronized;
/**
 * 有一个教室，座位有50个，同时有三个老师安排学生的座位，
 * 每个老师 安排100个同学到这个教室，模拟使用多线程实现：
 * 座位编号1-50/0-49，三个线程同时启动来安排同学，
 * 座位满了停止执行
 */
public class SynchronizedTest {
    private static int count = 50;

    private static class Zw extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                synchronized (SynchronizedTest.class) {
                    if(count > 0) {
                        System.out.println(Thread.currentThread().getName()+"安排学生到"
                                +count+"座位");
                        count--;
                    }
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Zw z = new Zw();
        new Thread(z,"x老师").start();
        new Thread(z,"y老师").start();
        new Thread(z,"z老师").start();

    }
}
