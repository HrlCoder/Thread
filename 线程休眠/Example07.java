package ThreadExample.线程休眠;

public class Example07 {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Task1()).start();
        for (int i = 1; i <= 10; i++) {
            if(i == 3) {
                Thread.sleep(2000);
            } else {
                Thread.sleep(500);
            }
            System.out.println("main主线程正在输出："+i);
        }
    }
}

class Task1 implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                if(i == 3) {
                    Thread.sleep(2000);
                } else {
                    Thread.sleep(500);
                }
                System.out.println("线程一正在输出："+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}