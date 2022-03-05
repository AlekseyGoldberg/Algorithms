package Lab3;

public class Node<T> {
    private Node<T> next;
    private Node<T> last;
    private T content;


    public Node(Node<T> next, Node<T> last, T content) {
        this.next = next;
        this.last = last;
        this.content = content;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getLast() {
        return last;
    }


    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }

    public T getContent() {
        return content;
    }

    public String toString() {
        return content.toString();
    }
}
