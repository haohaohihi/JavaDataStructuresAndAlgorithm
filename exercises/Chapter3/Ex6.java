package Chapter3;

/**
 * Josephus problem 约瑟夫问题
 * Created by haohao on 2018/3/26.
 */
public class Ex6 {
    //递归方法1、2，仅是实现方式不同，原理一样：f(n) = (f(n-1) + m) mod n， 时间复杂度O(n)，仅能求出最后留下的序号
    public static int Josephus1(int n, int m){
        if(n == 1)  return 0;
        else {
            return  (Josephus1(n - 1, m) + m) % n;
        }
    }
    //递归方法2
    public static int Josephus2(int n, int m){
        int s = 0;
        for(int i=2; i <= n; i++){
            s = (s + m) % i;
        }
        return s;
    }

    // 使用循环单链表模拟实现，时间复杂度O(m*n)
    static class Node{
        int id;
        Node next;
        Node(int i){
            this.id = i;
        }
    }

    public static int Josephus3(int n, int m){
        // 建链
        Node head = new Node(0);
        head.next = null;
        Node cur = head;
        for(int i = 1; i < n; i++){
            cur.next = new Node(i);
            cur.next.next = null;
            cur = cur.next;
        }
        cur.next = head;

        Node pre = cur;
        cur = head;

        // m=1单独处理，依次输出即可
        if(m == 1){
            while(cur.next != head){
                System.out.print(cur.id + ", ");
                cur = cur.next;
            }
            System.out.println();
            return cur.id;
        }

        while(cur.next != cur){
            for(int i=0; i < m-1; i++){
                pre = cur;
                cur = cur.next;
            }
            pre.next = cur.next;
            System.out.print(cur.id + ", ");
            cur.next = null;
            cur = pre.next;
        }
        System.out.println();
        return cur.id;
    }

    public static void main(String[] args) {
        System.out.println(Josephus1(140, 4));
        System.out.println(Josephus2(5, 2));
        System.out.println(Josephus3(5, 2));
    }
}
