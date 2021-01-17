package HMThread.Lambda;

import java.util.Arrays;
import java.util.Comparator;

public class DemoArrays {
    public static void main(String[] args) {
        Person[] arr = {
                new Person("pp",18),
                new Person("hh",19),
                new Person("ff",16),
        };

//        Arrays.sort(arr, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge()-o2.getAge();
//            }
//        });
        //使用lambda
        Arrays.sort(arr,(Person o1, Person o2)->{
            return o1.getAge()-o2.getAge();
        });

        Arrays.sort(arr,(Person o1, Person o2)->o1.getAge()-o2.getAge());

        //遍历数组
        for (Person p : arr) {
            System.out.println(p);
        }
    }
}
