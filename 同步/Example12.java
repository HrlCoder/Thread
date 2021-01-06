package ThreadExample.同步;

public class Example12 {
    public static void main(String[] args) {
        TicketWindow1 task = new TicketWindow1();
        new Thread(task,"窗口1").start();
        new Thread(task,"窗口2").start();
        new Thread(task,"窗口3").start();
        new Thread(task,"窗口4").start();
    }
}

class TicketWindow1 implements Runnable {

    private int tickets = 10;
    Object obj = new Object();
    @Override
    public void run() {
        while (true) {
            sendTicket();
        }
    }

    public synchronized void sendTicket() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(tickets > 0) {
            System.out.println(Thread.currentThread().getName()+"---卖出的票"+tickets--);
        } else {
            System.exit(0);
        }
    }
}