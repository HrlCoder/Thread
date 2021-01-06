package ThreadExample.实现Runnable;

public class Example03 {
    public static void main(String[] args) {
        MyThread3 myThread = new MyThread3();
        Thread thread = new Thread(myThread);
        thread.start();
        while (true) {
            System.out.println("main()方法在运行");
        }
    }
}

class MyThread3 implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("MyThread类的run()方法在运行");
        }
    }
}
