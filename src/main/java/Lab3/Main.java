package Lab3;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }


    public static void task1() {
        System.out.println("Задание 1");
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 1000; i++) {
            int rnd = (int) (Math.random() * ((1000 + 1000))) - 1000;
            list.add(rnd);
        }
        Integer min = list.getFirst().getContent();
        Integer max = list.getFirst().getContent();
        Integer sum = 0;
        for (Integer node : list) {
            sum += node;
            if (node < min)
                min = node;
            if (node > max)
                max = node;
        }
        System.out.format("Общая сумма %d, Минимальное значение %d, " +
                        "Максимальное значение %d, среднее значение %f" +
                        "\n-----------------------------------------------------------------------",
                sum, min, max, (double) 1000 / sum);

    }

    public static void task2() {
        System.out.println("\nЗадание 2:");
        MyLinkedList<String> list = new MyLinkedList<>();
        for (int i = 0; i < 10; i++)
            list.add(Integer.toString(i));
        System.out.println("Заполненный массив строками");
        for (String str : list)
            System.out.print(str + " ");

        System.out.println("\nбыл удален 4-ый элемент, его значение " + list.remove(4));
        System.out.println("Массив после удаления");
        for (String str : list)
            System.out.print(str + " ");
        System.out.println("\n-----------------------------------------------------------------------");

    }

    public static void task3() {
        System.out.println("Задание 3:");
        String[] names = new String[]{
                "AER", "DES", "REC", "GHY", "OPT", "SXC", "EWW", "HBH", "POI", "NNH", "HYR", "QAE", "ARY", "ERQ", "IOP", "OPW", "ZXC"
        };
        int[] yearOfBirth = new int[43];
        for (int i = 0; i <= 42; i++)
            yearOfBirth[i] = i + 1980;

        MyLinkedList<Human> list = new MyLinkedList<>();
        for (int i = 0; i < 100; i++) {
            int rndNames = (int) (Math.random() * names.length);
            int rndYear = (int) (Math.random() * yearOfBirth.length);
            Human human = new Human(names[rndNames], yearOfBirth[rndYear]);
            list.add(human);
        }

        MyLinkedList<Human> youngPeople = new MyLinkedList<>();
        MyLinkedList<Human> olderPeople = new MyLinkedList<>();
        for (Human human : list) {
            if (2022 - human.getYearOfBirth() < 20) {
                youngPeople.add(human);
            }
            if (2022 - human.getYearOfBirth() > 30) {
                olderPeople.add(human);
            }
        }

        int countFilter = 0;
        for (Human human : youngPeople) {
            if (human.getYearOfBirth() < 2002)
                countFilter++;
        }
        for (Human human : olderPeople) {
            if (human.getYearOfBirth() > 1992)
                countFilter++;
        }
        System.out.println("Количество неверных результатов равно: " + countFilter);
        System.out.println("-----------------------------------------------------------------------");

    }

    public static void task4() {
        System.out.println("Задание 4:");
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Soreted quickSorted = new Soreted();

        for (int i = 0; i < 1_000; i++) {
            int rnd = (int) (Math.random() * ((1000 + 1000))) - 1000;
            myList.add(rnd);
            linkedList.add(rnd);
        }
        long startLinkedList = System.currentTimeMillis();
        quickSorted.myQuickSort(linkedList.toArray(new Integer[0]), 0, linkedList.size() - 1);
        long stopLinkedList = System.currentTimeMillis();

        long startMyList = System.currentTimeMillis();
        quickSorted.myQuickSort(myList.toArray(), 0, linkedList.size() - 1);
        long stopMyList = System.currentTimeMillis();

        System.out.println("Сортировка LinkedList заняла " + (stopLinkedList - startLinkedList));
        System.out.println("Сортировка MyLinkedList заняла " + (stopMyList - startMyList));
    }
}
