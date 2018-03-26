package Chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by haohao on 2018/3/26.
 */
public class Ex5 {
    public static <E extends Comparable<? super E>> void getUnionOfSortedList(List<E> l1, List<E> l2, List<E> result){
        Iterator<E> iter1 = l1.iterator();
        Iterator<E> iter2 = l2.iterator();
        E item1 = null, item2 = null;
        if(iter1.hasNext())     item1 = iter1.next();
        if(iter2.hasNext())     item2 = iter2.next();

        while(item1 != null && item2 != null){
            int compareResult = item1.compareTo(item2);
            if(compareResult == 0){
                result.add(item1);
                item1 = iter1.hasNext() ? iter1.next() : null;
                item2 = iter2.hasNext() ? iter2.next() : null;
            }
            else if (compareResult < 0) {
                result.add(item1);
                item1 = iter1.hasNext() ? iter1.next() : null;
            }
            else{
                result.add(item2);
                item2 = iter2.hasNext() ? iter2.next() : null;
            }
        }
        // 这里比求交集多了一步，要加上把较长的List放入结果中
        while(item1 != null){
            result.add(item1);
            item1 = iter1.hasNext() ? iter1.next() : null;
        }
        while(item2 != null){
            result.add(item2);
            item2 = iter2.hasNext() ? iter2.next() : null;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> L1 = new ArrayList<>(Arrays.asList(  2, 7, 9, 10, 14));
        ArrayList<Integer> L2 = new ArrayList<>(Arrays.asList(0, 2, 4, 7, 8, 10, 14));
        ArrayList<Integer> result = new ArrayList<>();
        getUnionOfSortedList(L1, L2, result);
        System.out.println(result);
    }
}
