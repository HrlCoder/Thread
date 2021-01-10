package BreadShop;

public class BreadShop {
    /**
     * 面包店库存
     */
    private static int COUNT;

    /**
     * 消费者
     */
    public static class Consumer implements Runnable {

        private String name;

        public Consumer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            //一直消费
            try {
                while (true) {
                    synchronized (BreadShop.class) {
                        //库存到达下限，不能继续消费，需要阻塞等待
                        if(COUNT == 0) {
                            BreadShop.class.wait();//释放对象锁
                        } else {
                            System.out.printf("消费者%s消费了1个面包,库存为%d\n",name,--COUNT);
                            //通知BreadShop.class.wait()代码进入阻塞的线程
                            BreadShop.class.notifyAll();
                            Thread.sleep(500);
                        }
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 生产者
     */

    public static class Producer implements Runnable {

        private String name;

        public Producer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (BreadShop.class){
                        if(COUNT + 3 > 100) {
                            BreadShop.class.wait();
                        } else {
                            COUNT += 3;
                            System.out.printf("面包师%s生产了3个面包，库存为%d\n",name,COUNT);
                            BreadShop.class.notifyAll();
                            Thread.sleep(500);
                        }
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread[] consumers = new Thread[20];
        for (int i = 0; i < 20; i++) {
            consumers[i] = new Thread(new Consumer(String.valueOf(i)));
        }

        Thread[] producers = new Thread[10];
        for (int i = 0; i < 10; i++) {
            producers[i] = new Thread(new Producer(String.valueOf(i)));
        }

        for (Thread t : consumers) {
            t.start();
        }

        for (Thread t : producers) {
            t.start();
        }
    }
}
