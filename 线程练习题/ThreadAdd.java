package Homework;

public class ThreadAdd {
    private static int COUNT = 0;
    private static class Task implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                synchronized (Task.class) {
                    COUNT++;
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
            }
            System.out.println(COUNT);
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
    }
}
