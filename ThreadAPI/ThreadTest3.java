package ThreadAPI;

public class ThreadTest3 {
    public static void main(String[] args) {
        //main主线程和子线程同时并发并行执行，但main线程正在运行态执行代码
        //很快执行main和Thread，本该是乱序随机，但是先打印main概率上非常高
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //内部类使用外边的变量必须是final修饰的
                System.out.println("Thread");
            }
        });//申请系统创建线程t
        t.start();//申请系统执行线程t：创建态转变为就绪态，由系统决定什么时候转变为运行态
        System.out.println("main");
    }
}
