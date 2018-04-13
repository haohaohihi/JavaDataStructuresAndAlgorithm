package Chapter4.Tree;

/**
 * Created by haohao on 2018/4/13.
 */

class BinaryNode<T> {
    BinaryNode(T theElement) {
        this(theElement, null, null);
    }

    BinaryNode(T theElement, BinaryNode<T> left, BinaryNode<T> right) {
        this.element = theElement;
        this.left = left;
        this.right = right;
    }

    T element;
    BinaryNode<T> left;
    BinaryNode<T> right;
}

public class BinarySearchTree<T extends Comparable<? super T>> {
    private BinaryNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void makeEmpty() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean contains(T x) {
        return contains(x, this.root);
    }

    public T findMin() {
        if (isEmpty()) {
            throw new NullPointerException();
        } else {
            return findMin(this.root).element;
        }
    }

    public T findMax() {
        if (isEmpty()) {
            throw new NullPointerException();
        } else {
            return findMax(this.root).element;
        }
    }

    public void insert(T x) {
        this.root = insert(x, this.root);
    }

    public void remove(T x) {
        this.root = remove(x, this.root);
    }

    public void printTree() {
        printTree(this.root);
    }


    private boolean contains(T x, BinaryNode<T> t) {
        return false;
    }

    private BinaryNode<T> findMin(BinaryNode<T> t) {
        return null;
    }

    private BinaryNode<T> findMax(BinaryNode<T> t) {
        return null;
    }

    private BinaryNode<T> insert(T x, BinaryNode<T> t) {
        return null;
    }

    private BinaryNode<T> remove(T x, BinaryNode<T> t) {
        return null;
    }

    private void printTree(BinaryNode<T> t) {

    }
}
