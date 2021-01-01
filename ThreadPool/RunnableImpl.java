package HMThread.ThreadPool;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author： 浪漫不死
 * @Date： 2021/1/1
 * @description：
 * @version: 1.0
 */
public class RunnableImpl implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"创建了一个新的线程执行");
    }
}
