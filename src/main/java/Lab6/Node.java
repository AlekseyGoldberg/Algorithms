package Lab6;


import java.util.Objects;

public class Node<T> implements Comparable<T> {
    private Node<T> parent;
    private Node<T> left;
    private Node<T> right;
    private final T content;

    public Node(T content) {
        this.content = content;
    }

    public Node<T> getParent() {
        return parent;
    }

    public T getContent() {
        return content;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(content, node.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public int compareTo(T o) {
        return this.getContent().hashCode() - o.hashCode();
    }

    @Override
    public String toString() {
        return "content=" + content;
    }
}
