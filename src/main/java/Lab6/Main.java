package Lab6;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(3);
        tree.add(8);
        tree.add(7);
        tree.add(2);
        tree.add(10);
        tree.add(9);

        for (Integer i : tree)
            System.out.print(i + " ");
        System.out.println();
        tree.remove(8);
        for (Integer i : tree)
            System.out.print(i + " ");
        System.out.println();
    }
}
