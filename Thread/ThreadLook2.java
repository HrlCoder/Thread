package Thread;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author： 浪漫不死
 * @Date： 2020/12/13
 * @description：
 * @version: 1.0
 */
public class ThreadLook2 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {

                }
            }
        };
        t.start();
        //和上面run方法并发执行
        while (true) {

        }
    }
}
