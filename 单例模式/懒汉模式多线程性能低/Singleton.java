package 单例模式.懒汉模式多线程性能低;

public class Singleton {
    private static Singleton instance = null;
    private Singleton() {}
    public synchronized static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
