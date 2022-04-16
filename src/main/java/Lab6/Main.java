package Lab6;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer > tree=new BinaryTree<>();
        Node<Integer>node=new Node<>(5);
//        System.out.println(node.equals(node.getRight()));
        tree.add(3);
        tree.add(8);
        tree.add(7);
        tree.add(2);
        tree.add(9);

        tree.remove(8);
        for (Integer i:tree)
            System.out.print(i+" ");

    }
}
