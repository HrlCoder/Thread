package ThreadExample.ThreadVsRunnable;

public class Example05 {
    public static void main(String[] args) {
        TicketWindow1 task = new TicketWindow1();
        new Thread(task,"窗口1").start();
        new Thread(task,"窗口2").start();
        new Thread(task,"窗口3").start();
        new Thread(task,"窗口4").start();
    }
}

class TicketWindow1 extends Thread {
    private int tickets = 100;

    @Override
    public void run() {
        while (true) {
            if(tickets > 0) {
                Thread th = Thread.currentThread();
                String th_name = th.getName();
                System.out.println(th_name+"正在发售第"+tickets--+"张票");
            }
        }
    }
}
