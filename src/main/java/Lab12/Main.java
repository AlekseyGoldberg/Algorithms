package Lab12;

public class Main {
    public static void main(String[] args) {
        CircleBuffer<String> stringCircleBuffer = new CircleBuffer<>();
        CircleBuffer<Integer> integerCircleBuffer = new CircleBuffer<>(4);

        System.out.println("Test1:");
        stringCircleBuffer.add("Hello");
        integerCircleBuffer.add(12);
        stringCircleBuffer.print();
        integerCircleBuffer.print();
        System.out.println("----------------------");

        System.out.println("Test2:");
        stringCircleBuffer.add("Aleksey");
        integerCircleBuffer.add(34);
        stringCircleBuffer.print();
        integerCircleBuffer.print();
        System.out.println("----------------------");

        System.out.println("Test3:");
        stringCircleBuffer.add("!!!");
        integerCircleBuffer.add(56);
        stringCircleBuffer.print();
        integerCircleBuffer.print();

    }

}
