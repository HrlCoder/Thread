package Homework;

public class SequencePrint进阶 {

    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        new Thread(new Task("A",c,a)).start();
        new Thread(new Task("B",a,b)).start();
        new Thread(new Task("C",b,c)).start();
    }

    public static class Task implements Runnable {
        private String name;
        private Object pre;
        private Object self;

        public Task(String name, Object pre, Object self) {
            this.name = name;
            this.pre = pre;
            this.self = self;
        }

        @Override
        public void run() {
            int count = 10;
            while (count > 0) {
                synchronized (pre) {
                    synchronized (self) {
                        System.out.print(name);
                        count--;
                        self.notifyAll();
                    }
                    try {
                        pre.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}