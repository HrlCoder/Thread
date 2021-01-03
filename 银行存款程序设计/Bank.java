package ThreadExample.银行存款程序设计;

public class Bank {
    private int sum;
    public void add(int num) {
        synchronized (this) {
            sum = sum + num;
            System.out.println(Thread.currentThread().getName()+"账户的余额为："+sum);
        }
    }
}
