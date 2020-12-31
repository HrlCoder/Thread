package ThreadAPI;

public class ThreadTest1 {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            final int n = i;
            //子线程休眠三秒之后，同时执行，无序的
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        //内部类使用外边的变量必须是final修饰的
                        System.out.println(n);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
        System.out.println("OK");
    }
}
