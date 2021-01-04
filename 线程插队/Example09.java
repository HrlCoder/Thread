package ThreadExample.线程插队;

public class Example09 {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new EmergencyThread(),"线程一");
        t.start();
        for (int i = 0; i < 6; i++) {
            System.out.println(Thread.currentThread().getName()+"输出："+i);
            if(i == 2) {
                t.join();
            }
            Thread.sleep(500);
        }
    }
}

class EmergencyThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println(Thread.currentThread().getName()+"输出："+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}