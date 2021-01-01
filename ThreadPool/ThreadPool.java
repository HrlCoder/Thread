package HMThread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        //使用线程池的工厂类Executors里边提供的静态方法newFixedThreadPool生产一个指定线程数量的线程池
        ExecutorService es = Executors.newFixedThreadPool(2);

        //创建一个类，实现Runnable接口，设置线程任务

        //调用ExecutorService中的方法submit，传递线程任务（实现类），开启线程，执行run方法
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        //调用ExecutorService中的方法shutdown销毁线程池（不建议执行）
        es.shutdown();
    }
}
