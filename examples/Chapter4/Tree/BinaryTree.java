package Chapter4.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by haohao on 2018/4/15.
 */
public class BinaryTree {
    /*
    使用递归进行 前序遍历
     */
    public static void preOrder(BinaryNode<Integer> t) {
        if (t == null) return;
        System.out.print(t.element + " ");
        preOrder(t.left);
        preOrder(t.right);
    }

    /*
    使用非递归进行 前序遍历
     */
    public static void preOrder1(BinaryNode<Integer> t) {
        Stack<BinaryNode<Integer>> stack = new Stack<>();
        while (t != null || !stack.isEmpty()) {
            while (t != null) {
                System.out.print(t.element + " ");
                stack.push(t);
                t = t.left;
            }
            if (!stack.isEmpty()) {
                t = stack.pop();
                t = t.right;
            }
        }
    }

    /*
    使用递归进行 中序遍历
     */
    public static void midOrder(BinaryNode<Integer> t) {
        if (t == null) return;
        midOrder(t.left);
        System.out.print(t.element + " ");
        midOrder(t.right);
    }

    /*
    使用非递归进行 中序遍历
     */
    public static void midOrder1(BinaryNode<Integer> t) {
        Stack<BinaryNode<Integer>> stack = new Stack<>();
        while (t != null || !stack.empty()) {
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
            if (!stack.empty()) {
                t = stack.pop();
                System.out.print(t.element + " ");
                t = t.right;
            }
        }
    }

    /*
    使用递归进行 后序遍历
     */
    public static void posOrder(BinaryNode<Integer> t) {
        if (t == null) return;
        posOrder(t.left);
        posOrder(t.right);
        System.out.print(t.element + " ");
    }

    /*
    使用非递归进行后序遍历
     */
    public static void posOrder1(BinaryNode<Integer> t) {
        Stack<BinaryNode<Integer>> stack = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        int i = 1;
        while (t != null || !stack.empty()) {
            while (t != null) {
                stack.push(t);
                temp.push(0);
                t = t.left;
            }
            while (!stack.empty() && temp.peek() == i) {
                temp.pop();
                System.out.print(stack.pop().element + " ");
            }
            if (!stack.empty()) {
                temp.pop();
                temp.push(i);
                t = stack.peek().right;
            }
        }
    }

    /*
    使用递归进行 层序遍历
     */
    public static void levelOrder(BinaryNode<Integer> t) {
        if (t == null)  return;
        int depth = depth(t);
        for (int i = 1; i <= depth; i++) {
            levelOrder(t, i);
        }
    }

    public static void levelOrder(BinaryNode<Integer> t, int level) {
        if (t == null || level < 1)     return;
        if (level == 1) {
            System.out.print(t.element + " ");
            return;
        }
        levelOrder(t.left, level - 1);
        levelOrder(t.right, level - 1);
    }

    /*
    使用递归获取树的高度
     */
    public static int depth(BinaryNode<Integer> t) {
        if (t == null) {
            return 0;
        }
        int l = depth(t.left);
        int r = depth(t.right);
        return Math.max(l, r) + 1;
    }

    public static void levelOrder1(BinaryNode<Integer> t) {
        if (t == null) {
            return;
        }
        BinaryNode<Integer> node;
        Queue<BinaryNode<Integer>> queue = new LinkedList<>();
        queue.offer(t);
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.element + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryNode<Integer> root = new BinaryNode<Integer>(1, null, null);
        root.left = new BinaryNode<Integer>(
                2,
                new BinaryNode<Integer>(4,
                                        new BinaryNode<Integer>(8, null, null),
                                        null),
                new BinaryNode<Integer>(5, null, null)
        );
        root.right = new BinaryNode<Integer>(
                3,
                new BinaryNode<Integer>(6, null, null),
                new BinaryNode<Integer>(7, null, null)
        );

        System.out.println("使用递归进行前序遍历");
        preOrder(root);
        System.out.println();
        System.out.println("使用非递归进行前序遍历");
        preOrder1(root);
        System.out.println();
        System.out.println("---------------------------------------------------");

        System.out.println("使用递归进行中序遍历");
        midOrder(root);
        System.out.println();
        System.out.println("使用非递归进行中序遍历");
        midOrder1(root);
        System.out.println();
        System.out.println("---------------------------------------------------");


        System.out.println("使用递归进行后序遍历");
        posOrder(root);
        System.out.println();
        System.out.println("使用非递归进行后序遍历");
        posOrder1(root);
        System.out.println();
        System.out.println("---------------------------------------------------");

        System.out.println(depth(root));

        System.out.println("使用递归进行层序遍历");
        levelOrder(root);
        System.out.println();

        System.out.println("使用非递归进行层序遍历");
        levelOrder1(root);
        System.out.println();
    }
}
