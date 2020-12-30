package Thread;

public class ThreadAdvantage {
    private static final long count = 10_0000_0000;

    public static void main(String[] args) throws InterruptedException {
        //并发
        concurrency();
        //串行
        serial();
    }

    //利用一个线程计算a的值
    private static void concurrency() throws InterruptedException {
      long begin = System.nanoTime();

      Thread t = new Thread(new Runnable() {
          @Override
          public void run() {
              int a= 0;
              for (long i = 0; i < count; i++) {
                  a--;
              }
          }
      });
      t.start();

      //主线程计算b的值
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        t.join();

        //统计耗时
        long end = System.nanoTime();
        double ms = (end - begin) *1.0/1000/100;
        System.out.printf("并发:%f 毫秒%n",ms);
    }

    private static void serial() {
        long begin = System.nanoTime();

        int a= 0;
        for (long i = 0; i < count; i++) {
            a--;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        //统计耗时
        long end = System.nanoTime();
        double ms = (end - begin) *1.0/1000/100;
        System.out.printf("串行:%f 毫秒%n",ms);
    }
}