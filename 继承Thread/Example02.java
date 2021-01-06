package ThreadExample.继承Thread;

public class Example02 {
    public static void main(String[] args) {
        MyThread2 myThread = new MyThread2();
        myThread.start();
        while (true) {
            System.out.println("main()方法在运行");
        }
    }
}

class MyThread2 extends Thread {
    public void run() {
        while (true) {
            System.out.println("MyThread类的run()方法在运行");
        }
    }
}
