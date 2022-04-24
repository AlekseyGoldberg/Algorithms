package Lab7;

import Lab6.AVLTree;
import Lab6.BST_class;

class Main {
    private static int min=10;
    private static  int max=20;

    public static void main(String[] args) {
        for (int i=0;i<20;i++){
            test(i);
        }
    }
    public static void test(int count) {
        System.out.println("==========================================\nTest " + count + ":");
        // Заполнение неотсортированными элементами
        for (int i = 0; i < 10; i++) {
            Integer[] ourMass = new Integer[(int) Math.pow(2, 10 + i)];
            for (int j = 0; j < ourMass.length; j++) {
                int rnd = (int) ((Math.random() * (max - min)) + min);
                ourMass[j] = rnd;
            }
            BST_class<Integer> binaryTree = new BST_class<>(ourMass);
            AVLTree<Integer> avlTree = new AVLTree<>(ourMass);

            long start = System.currentTimeMillis();

            for (int j = 0; j < 1000; j++) {
                Integer found = (int) ((Math.random() * (max - min)) + min);
                binaryTree.found(found);
            }
            long end = System.currentTimeMillis();
            System.out.println("Поиск 1000 элементов в неотсортированном бинарном дереве прошел за " + (end - start) + " мс");

            int found = (int) ((Math.random() * (max - min)) + min);
            start = System.currentTimeMillis();
            binaryTree.found(found);
            end = System.currentTimeMillis();
            System.out.println("Поиск 1 элемента в неотсортированном бинарном дереве прошел за " + (end - start) + " мс");

            start = System.currentTimeMillis();
            for (int j = 0; j < 1000; j++) {
                found = (int) ((Math.random() * (max - min)) + min);
                avlTree.found(found);
            }
            end = System.currentTimeMillis();
            System.out.println("Поиск 1000 элементов в неотсортированном AVL дереве прошел за " + (end - start) + " мс");
            found = (int) ((Math.random() * (max - min)) + min);
            start = System.currentTimeMillis();
            avlTree.found(found);
            end = System.currentTimeMillis();
            System.out.println("Поиск 1 элемента в неотсортированном AVL дереве прошел за " + (end - start) + " мс");

            start = System.currentTimeMillis();
            for (int j = 0; j < 1000; j++) {
                found = (int) ((Math.random() * (max - min)) + min);
                for (Integer mass : ourMass) {
                    if (mass.equals(found))
                        break;
                }
            }
            end = System.currentTimeMillis();
            System.out.println("Поиск 1000 элементов в неотсортированном массиве прошел за " + (end - start) + " мс");

            found = (int) ((Math.random() * (max - min)) + min);
            start = System.currentTimeMillis();
            for (int k = 0; k < ourMass.length; k++) {
                if (ourMass[k].equals(found))
                    break;
            }
            end = System.currentTimeMillis();
            System.out.println("Поиск 1 элемента в неотсортированном массиве прошел за " + (end - start) + " мс");
        }
        // Заполнение отсортированными элементами
        for (int i = 0; i < 10; i++) {
            Integer[] ourMass = new Integer[(int) Math.pow(2, 10 + i)];
            for (int j = 0; j < ourMass.length; j++) {
                ourMass[j] = j;
            }
            BST_class<Integer> binaryTree = new BST_class<>(ourMass);
            AVLTree<Integer> avlTree = new AVLTree<>(ourMass);

            long start = System.currentTimeMillis();

            for (int j = 0; j < 1000; j++) {
                Integer found = (int) ((Math.random() * (max - min)) + min);
                binaryTree.found(found);
            }
            long end = System.currentTimeMillis();
            System.out.println("Поиск 1000 отсортированных элементов в бинарном дереве прошел за " + (end - start) + " мс");

            int found = (int) ((Math.random() * (max - min)) + min);
            start = System.currentTimeMillis();
            binaryTree.found(found);
            end = System.currentTimeMillis();
            System.out.println("Поиск 1 элемента в отсортированном бинарном дереве прошел за " + (end - start) + " мс");

            start = System.currentTimeMillis();
            for (int j = 0; j < 1000; j++) {
                found = (int) ((Math.random() * (max - min)) + min);
                avlTree.found(found);
            }
            end = System.currentTimeMillis();
            System.out.println("Поиск 1000 отсортированных элементов в AVL дереве прошел за " + (end - start) + " мс");

            found = (int) ((Math.random() * (max - min)) + min);
            start = System.currentTimeMillis();
            avlTree.found(found);
            end = System.currentTimeMillis();
            System.out.println("Поиск 1 элемента в отсортированном AVL дереве прошел за " + (end - start) + " мс");

            start = System.currentTimeMillis();
            for (int j = 0; j < 1000; j++) {
                found = (int) ((Math.random() * (max - min)) + min);
                for (Integer mass : ourMass) {
                    if (mass.equals(found))
                        break;
                }
            }
            end = System.currentTimeMillis();
            System.out.println("Поиск 1000 элементов в отсортированном массиве прошел за " + (end - start) + " мс");

            found = (int) ((Math.random() * (max - min)) + min);
            start = System.currentTimeMillis();
            for (int k = 0; k < ourMass.length; k++) {
                if (ourMass[k].equals(found))
                    break;
            }
            end = System.currentTimeMillis();
            System.out.println("Поиск 1 элемента в отсортированном массиве прошел за " + (end - start) + " мс");
        }
    }
}