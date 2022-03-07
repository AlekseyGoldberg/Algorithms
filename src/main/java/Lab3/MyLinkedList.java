package Lab3;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MyLinkedList<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int length;


    public Integer[] toArray() {
        Integer[] array = new Integer[length];
        Node<T> node = first;
        for (int i = 0; i < length; i++) {
            array[i] = (Integer) node.getContent();
            node = node.getNext();
        }
        return array;
    }

    public void add(T content) {
        Node<T> node;
        if (length == 0) {
            node = new Node<>(null, null, content);
            this.first = node;
        } else {
            node = new Node<>(null, last, content);
            this.last.setNext(node);
        }
        this.last = node;
        length++;
    }

    public void add(int index, T content) {
        if (index == 0) {
            Node<T> newNode = new Node<>(first, null, content);
            first.setLast(newNode);
            first = newNode;
            length++;

        } else if (index == length - 1) {
            Node<T> newNode = new Node<>(null, last, content);
            last.setNext(newNode);
            last = newNode;
            length++;

        } else {
            Node<T> element = getIndex(index);
            Node<T> newNode = new Node<>(element, element.getLast(), content);
            element.getLast().setNext(newNode);
            element.setLast(newNode);
            length++;
        }

    }

    public T remove(int index) {
        Node<T> element;
        if (index == 0) {
            element = first;
            first = first.getNext();
            first.setLast(null);
            length--;
        } else if (index == length - 1) {
            element = last;
            last = last.getLast();
            last.setNext(null);
            length--;
        } else {
            element = getIndex(index);
            element.getLast().setNext(element.getNext());
            element.getNext().setLast(element.getLast());
            length--;
        }
        return element.getContent();
    }

    public Node<T> getIndex(int index) {
        Node<T> element = first;
        for (int i = 0; i < index; i++) {
            element = element.getNext();
        }
        return element;
    }


    public int size() {
        return length;
    }

    public Node<T> getLast() {
        return last;
    }

    public Node<T> getFirst() {
        return first;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int i = 0;
            Node<T> element = first;

            @Override
            public boolean hasNext() {
                return i < length;
            }

            @Override
            public T next() {
                Node<T> myElement = element;
                element = element.getNext();
                i++;
                return myElement.getContent();
            }
        };
    }
}
