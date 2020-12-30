package Thread;

public class ThreadLook4 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    for (int i = 0; i < 10000; i++) {
                        //某个线程异常，抛异常到run方法，整个线程直接结束
                        //但是不会影响其他线程
                        //线程中处理异常的方式，线程对象.setUncaughtExceptionHandler();
                        if(i == 20) {
                            throw new RuntimeException();
                        }
                        System.out.println(i);
                    }
                }
            }
        };
        t.start();

        while (true) {

        }
    }
}
