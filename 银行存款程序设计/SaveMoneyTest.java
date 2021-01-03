package ThreadExample.银行存款程序设计;

public class SaveMoneyTest {
    public static void main(String[] args) {
        new Thread(new Customer()).start();
        new Thread(new Customer()).start();
    }
}
