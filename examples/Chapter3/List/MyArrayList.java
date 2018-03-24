package Chapter3.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by haohao on 2018/3/24.
 */

public class MyArrayList<E> implements Iterable<E>{
    private static final int DEFAULT_CAPACITY = 10;
    private E[] theItems;
    private int theSize;

    public MyArrayList(){
        doClear();
    }

    public int size(){
        return theSize;
    }

    public Boolean isEmpty(){
        return theSize == 0;
    }

    public E get(int idx){
        if(idx < 0 || idx >= size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[idx];
    }

    public E set(int idx, E newVal){
        if(idx < 0 || idx >= size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        E old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    public boolean add(E val){
        add(theSize, val);
        return true;
    }

    /**
     * 在指定的index处插入新的对象，要考虑数组空间用光情况，对数组进行扩容
     * @param idx 插入id
     * @param val 插入对象
     */
    public void add(int idx, E val){
        if(theItems.length == theSize){     //数组空间全被占用
            ensureCapacity(theSize * 2 + 1);
        }
        for(int i=theSize; i > idx; i--){   //依次向后挪动，
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = val;
        theSize++;
    }


    public E remove(int idx){
        E removedItem = theItems[idx];
        for(int i=idx; i < theSize; i++){   //依次向前挪动
            theItems[i] = theItems[i + 1];
        }
        theSize--;
        return removedItem;
    }

    /**
     * 初始化数组，设置默认容量
     */
    private void doClear(){
        this.theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    /**
     * 修改List的容量，只在新容量大于旧容量时处理
     * 无法直接创建一个泛型数组，只能通过创建泛型边界类型数组，然后强制转换
     * @param newCapacity
     */
    public void ensureCapacity(int newCapacity){
        if(newCapacity < theSize)
            return;

        E[] old = theItems;
        theItems = (E[]) new Object[newCapacity];   //无法直接创建一个泛型数组，只能通过创建泛型边界类型数组，然后强制转换
        for(int i=0; i < theSize; i++){
            theItems[i] = old[i];
        }
    }

    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        for(E s: this){
            stringBuffer.append(s + ",");
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }
    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E>{
        private int current;
        @Override
        public boolean hasNext() {
            return current < MyArrayList.this.size();
        }

        @Override
        public E next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return MyArrayList.this.theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}
