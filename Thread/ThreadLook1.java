package Thread;

public class ThreadLook1 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {

                }
            }
        };
        t.start();
    }
}
