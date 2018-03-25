package Chapter3;

import java.util.*;

/**
 * 练习对iterator的理解和使用
 * 由于参数是List，不确定实际实现方式，故用get(idx)方法无法保证效率
 * iterator能避免链表反复从头开始查找的问题
 * Created by haohao on 2018/3/25.
 */

public class Ex1 {
    public static <E> void printLots(List<E> L, List<Integer> P){
        Iterator<E> iterL = L.iterator();
        Iterator<Integer> iterP = P.iterator();
        int tempIdx = 0;
        int itemP;
        E itemL = null;
        while(iterL.hasNext() && iterP.hasNext()){
            itemP = iterP.next();
            while(tempIdx < itemP && iterL.hasNext()){      //若使用<=，则是使用1开始的index
                itemL = iterL.next();
                tempIdx++;
            }
            System.out.println(itemL);
        }
    }

    public static void main(String[] args) {
        LinkedList<String> LL = new LinkedList<>(Arrays.asList("aa", "bb", "cc", "dd", "ee", "ff", "gg"));
        ArrayList<Integer> P = new ArrayList<>(Arrays.asList(1, 3, 6));
        printLots(LL, P);
    }
}
