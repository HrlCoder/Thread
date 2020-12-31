package ThreadAPI;

public class ThreadTest2 {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            final int n = i;
            //main主线程和子线程同时执行
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    //内部类使用外边的变量必须是final修饰的
                    System.out.println(n);
                }
            });
            for (Thread t : threads) {
                t.start();
            }
            //在debug中得到正确结果，直接run，idea会自动启动一个其他线程，就无法打印当前线程
//            while (Thread.activeCount()>1) {
//                Thread.yield();//当前线程让步，从运行态转变为就绪态
//            }
            for (Thread t : threads) {
                t.join();
            }
        }
        System.out.println("OK");
    }
}
