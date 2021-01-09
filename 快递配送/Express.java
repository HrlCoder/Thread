package 快递配送;

public class Express {
    private static int COUNT = 100;

    private static class Kd extends Thread {
        @Override
        public void run() {
            while (COUNT > 0) {
                synchronized (Express.class) {
                    if(COUNT > 0) {
                        System.out.println(Thread.currentThread().getName()+"送编号"+COUNT--+"号快递。");
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
        Kd k = new Kd();
        new Thread(k,"1号快递员").start();
        new Thread(k,"2号快递员").start();
        new Thread(k,"3号快递员").start();
    }
}
