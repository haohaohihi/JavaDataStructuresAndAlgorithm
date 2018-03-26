package Chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 求两个有序列表的交集
 * Created by haohao on 2018/3/25.
 */

public class Ex4 {
    public static <E extends Comparable<? super E>> void getIntersectionOfSortedList(List<E> L1, List<E> L2, List<E> result){
        Iterator<E> iter1 = L1.iterator();
        Iterator<E> iter2 = L2.iterator();
        E item1 = null, item2 = null;
        // 先求第一个值
        if(iter1.hasNext())     item1 = iter1.next();
        if(iter2.hasNext())     item2 = iter2.next();
        // 使用值判断而不是iter.hasNext()，因为不能保证hasNext都为true，这样第一个就无法判断了。
        while(item1 != null && item2 != null){
            int compareResult = item1.compareTo(item2);     //暂存结果，而不是每次计算，因为前后会有影响导致if的重复判断
            if(compareResult < 0){
                item1 = iter1.hasNext() ? iter1.next() : null;
            }
            else if(compareResult > 0){
                item2 = iter2.hasNext() ? iter2.next() : null;
            }
            else{
                result.add(item1);
                item1 = iter1.hasNext() ? iter1.next() : null;
                item2 = iter2.hasNext() ? iter2.next() : null;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> L1 = new ArrayList<>(Arrays.asList(  2, 7, 9, 10));
        ArrayList<Integer> L2 = new ArrayList<>(Arrays.asList(0, 2, 4, 7, 8, 10, 14));
        ArrayList<Integer> result = new ArrayList<>();
        getIntersectionOfSortedList(L1, L2, result);
        System.out.println(result);
    }
}
