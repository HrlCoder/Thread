package HMThread.Lambda;

public class DemoInvokeCalc {
    public static void main(String[] args) {
        invokeCalc(5, 4, new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a+b;
            }
        });

        invokeCalc(4,3,(int a,int b)->{
            return a+b;
        });

        invokeCalc(4,3,(int a,int b)->a+b);
    }

    private static void invokeCalc(int a,int b,Calculator calculator) {
        int result = calculator.calc(a,b);
        System.out.println("结果是："+result);
    }
}
