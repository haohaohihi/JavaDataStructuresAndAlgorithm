package Chapter3.List;

import java.util.Iterator;

/**
 * Created by haohao on 2018/3/24.
 */
public class TestMyArrayList {
    public static void main(String[] args) {
        MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add("hello");
        stringList.add("world");
        stringList.add(1, "Java");
        System.out.println("Size: " + stringList.size());
        System.out.println("Index 1 is: " + stringList.get(1));
        System.out.println(stringList.remove(0));
        System.out.println("Is empty? " + stringList.isEmpty());
        System.out.println(stringList);
        Iterator it = stringList.iterator();
        while(it.hasNext()){
            System.out.println("print: " + it.next());
        }
    }
}
