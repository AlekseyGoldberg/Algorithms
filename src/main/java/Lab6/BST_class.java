package Lab6;

import java.util.Iterator;
import java.util.Stack;

public class BinaryTree<T> implements Iterable<T> {
    private Node<T> root;
    private int length;

    public BinaryTree(T[]mass){
        length=0;
        for (T t : mass) {
            add(t);
        }
    }
    public BinaryTree(){length=0;}

    public Node<T> found(T value)  {
        Node<T> foundNode=searchInTree(value);
        if (foundNode.getContent().equals(value))
            return foundNode;
        return null;
    }
    private Node<T> searchInTree(T value) {
        Node<T> current = root;
        while (true) {
            if (current.getContent().equals(value)) {
                return current;
            }
            if (current.compareTo(value) > 0)
                if (current.getLeft() == null) {
                    return current;
                } else {
                    current = current.getLeft();
                }
            else {
                if (current.getRight() == null) {
                    return current;
                } else {
                    current = current.getRight();
                }
            }
        }
    }

    public void add(T value) {
        if (length == 0) {
            root = new Node<>(value);
            root.setRight(null);
            root.setLeft(null);
            length++;
        } else {
            Node<T> parentNode = searchInTree(value);
            if (!parentNode.getContent().equals(value)) {
                Node<T> newNode = new Node<>(value);
                newNode.setParent(parentNode);
                if (parentNode.compareTo(value) > 0)
                    parentNode.setLeft(newNode);
                else
                    parentNode.setRight(newNode);
                newNode.setLeft(null);
                newNode.setRight(null);
                length++;
            }
        }
    }

    public void remove(T value) {
        Node<T> deleteNode = searchInTree(value);
        Node<T> parentDeleteNode = deleteNode.getParent();
        boolean left = parentDeleteNode.getLeft().equals(deleteNode);
        if (deleteNode.getLeft() == null && deleteNode.getRight() == null) {
            if (left)
                parentDeleteNode.setLeft(null);
            else
                parentDeleteNode.setRight(null);
        } else if (deleteNode.getRight() == null) {
            //Если удаляемый узел имеет только левых потомков
            Node<T> newNode = deleteNode.getLeft();
            if (left)
                parentDeleteNode.setLeft(newNode);
            else
                parentDeleteNode.setRight(newNode);
            newNode.setParent(parentDeleteNode);
        } else {
            // если удаляемый узел имеет правых потомков
            Node<T> newNode = getFarLeftNode(deleteNode.getRight());
            if (left)
                parentDeleteNode.setLeft(newNode);
            else
                parentDeleteNode.setRight(newNode);
            // если минимальное значение в правом поддереве равно правому потомку удаляемого узла
            if (newNode.equals(deleteNode.getRight())) {
                newNode.setParent(parentDeleteNode);
            } else {
                // указываем, что родитель новой ноды не ссылается больше на нее
                if (newNode.getParent().getLeft().equals(newNode))
                    newNode.getParent().setLeft(null);
                else
                    newNode.getParent().setRight(null);
                // задаем новой ноде нового родителя
                newNode.setParent(parentDeleteNode);
                newNode.setRight(deleteNode.getRight());
                deleteNode.getRight().setParent(newNode);
            }
            //задаем новой ноде левого потомка
            newNode.setLeft(deleteNode.getLeft());
            deleteNode.getLeft().setParent(newNode);
        }
    }

    //Крайнее левое положение левой ноды
    private Node<T> getFarLeftNode(Node<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    @Override
    public Iterator<T> iterator() {
        return new BSTIterator(root);
    }


    public class BSTIterator implements Iterator<T> {
        Stack<Node<T>> stack;

        public BSTIterator(Node<T> root) {
            stack = new Stack<Node<T>>();
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public T next() {
            Node<T> node = stack.pop();
            T result = node.getContent();
            if (node.getRight() != null) {
                node = node.getRight();
                while (node != null) {
                    stack.push(node);
                    node = node.getLeft();
                }
            }
            return result;
        }
    }

    public int getLength() {
        return length;
    }
}
