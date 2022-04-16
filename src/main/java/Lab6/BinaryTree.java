package Lab6;

import java.util.Iterator;
import java.util.Stack;

public class BinaryTree<T> implements Iterable<T> {
    private Node<T> root;
    private int length;

    private Node<T> searchInTree(T value) {
        Node<T> current = root;
        while (true) {
            if (current.compareTo(value) > 0)
                if (current.getLeft() != null) {
                    current = current.getLeft();
                } else {
                    return current;
                }
            else {
                if (current.getRight() != null) {
                    current = current.getRight();
                } else {
                    return current;
                }
            }
        }

    }

    public void add(T value) {
        if (length == 0) {
            root = new Node<>(value);
            length++;
        } else {
            Node<T> parentNode = searchInTree(value);
            if (parentNode.compareTo(value) != 0) {
                Node<T> newNode = new Node<>(value);
                newNode.setParent(parentNode);
                if (parentNode.compareTo(value) > 0)
                    parentNode.setLeft(newNode);
                else
                    parentNode.setRight(newNode);
                newNode.setLeft(null);
                newNode.setRight(null);
            }
        }
    }

    public void remove(T value) {
        Node<T> searchNode = searchInTree(value);
        Node<T> parentNode = searchNode.getParent();
        //Проверка найденный элемент является левым или правым потомков своего родителя
        // если нет, переопределяем ссылки левого потомка на родителя и родителю на левого потомка
        if (searchNode.getLeft() != null) {
            // посмотреть еще раз что и как должно переопределяться, надо у родителя найти searchNode
            Node<T> newNode = getFarRightNode(searchNode.getLeft());
            parentNode.setLeft(newNode);
            newNode.setParent(parentNode);
            newNode.setLeft(searchNode.getLeft());
            searchNode.getLeft().setParent(newNode);
        } else if (searchNode.getRight()!=null){
            Node<T> newNode = getFarLeftNode(searchNode.getRight());
            parentNode.setRight(newNode);
            newNode.setParent(parentNode);
            newNode.setRight(searchNode.getRight());
            searchNode.getRight().setParent(newNode);
        }else {
            if (parentNode.getLeft().equals(searchNode))
                parentNode.setLeft(null);
            else
                parentNode.setRight(null);
        }
    }

    private Node<T> getFarRightNode(Node<T> node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
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
}
