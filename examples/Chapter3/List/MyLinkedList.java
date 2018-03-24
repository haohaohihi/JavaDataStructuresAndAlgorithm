package Chapter3.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by haohao on 2018/3/24.
 */
public class MyLinkedList<E> implements Iterable<E> {
    private static class Node<E>{
        public Node(E d, Node<E> p, Node<E> n){
            this.data = d;
            this.prev = p;
            this.next = n;
        }
        public E data;
        public Node<E> prev;
        public Node<E> next;
    }

    private int theSize;
    private Node<E> beginMarker;
    private Node<E> endMarker;

    public MyLinkedList(){
        doClear();
    }

    public int size(){
        return theSize;
    }

    public boolean isEmpty(){
        return theSize == 0;
    }

    public E get(int idx){
        return getNode(idx).data;
    }

    /**
     * 获取指定index的节点，这里根据长度与idx的大小，从两端开始寻找，降低了寻找时间，但还是O(n)
     * @param idx
     * @return
     */
    public Node<E> getNode(int idx){
        Node<E> p;
        if(idx < 0 || idx > theSize){
            throw new IndexOutOfBoundsException();
        }
        if(idx < theSize / 2){
            p = beginMarker.next;
            for(int i=0; i < idx; i++){
                p = p.next;
            }
        }
        else{
            p = endMarker;  //这里是从theSize开始，若idx就是theSize，则返回endMarker
            for(int i=theSize; i > idx; i--){
                p = p.prev;
            }
        }
        return p;
    }

    public E set(int idx, E newData){
        Node<E> oldNode = getNode(idx);
        E oldData = oldNode.data;
        oldNode.data = newData;
        return oldData;
    }

    public boolean add(E newData){
        add(theSize, newData);
        return true;
    }

    public void add(int idx, E newData){
        Node<E> oldNode = getNode(idx);
        Node<E> newNode = new Node<>(newData, oldNode.prev, oldNode);
        newNode.prev.next = newNode.next.prev = newNode;
        theSize++;
    }

    /**
     * 删除指定index的节点
     * @param idx
     * @return
     */
    public E remove(int idx){
        return remove(getNode(idx));
    }

    /**
     * 删除一个节点
     * @param node
     * @return
     */
    public E remove(Node<E> node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        theSize--;
        return node.data;
    }

    /**
     * 初始化List，创建头结点和尾节点，size置零
     */
    public void doClear(){
        beginMarker = new Node<>(null, null, null);
        endMarker = new Node<>(null, beginMarker, null);
        beginMarker.next = endMarker;
        theSize = 0;
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
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E>{
        private Node<E> current = MyLinkedList.this.beginMarker.next;

        @Override
        public boolean hasNext() {
            return current != MyLinkedList.this.endMarker;
        }

        @Override
        public E next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            return data;
        }

        @Override
        public void remove() {
            MyLinkedList.this.remove(current.prev);
        }
    }
}
