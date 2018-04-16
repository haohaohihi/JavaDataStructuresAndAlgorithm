package Chapter4.Tree;

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
    使用递归进行 中序遍历
     */
    public static void midOrder(BinaryNode<Integer> t) {
        if (t == null) return;
        midOrder(t.left);
        System.out.print(t.element + " ");
        midOrder(t.right);
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

        System.out.println("使用递归进行中序遍历");
        midOrder(root);
        System.out.println();

        System.out.println("使用递归进行后序遍历");
        posOrder(root);
        System.out.println();

        System.out.println(depth(root));

        System.out.println("使用递归进行层序遍历");
        levelOrder(root);
        System.out.println();
    }
}
