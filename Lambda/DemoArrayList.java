package HMThread.Lambda;

import java.util.ArrayList;

public class DemoArrayList {
    public static void main(String[] args) {
        //JDK1.7版本之前，创建集合对象必须把前后的泛型都写上
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        //JDK1.7版本之后，=后面的泛型可以省略，后边的泛型可以根据前边的泛型推导出来
        ArrayList<Integer> list2 = new ArrayList<>();
    }
}
