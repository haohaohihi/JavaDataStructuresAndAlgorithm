package Chapter4.Tree;

/**
 * Created by haohao on 2018/4/15.
 */
public class BinaryNode<T> {
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
