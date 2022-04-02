package Lab5;

public class Main {
    private static int[] Ver = {100, 200, 400, 600, 800, 1000};

    public static void main(String[] args) {
        for (int i = 0; i < Ver.length; i++) {
            Graph graph = new Graph(GenerateGraph.generateGraph(Ver[i]));
            long start = System.currentTimeMillis();
            Search.floydWarshall(graph.getGraph());
            long stop = System.currentTimeMillis();
            System.out.println("Для текста [" + (i + 1) + "] с [" + Ver[i] + " элементов] потребовалось " + (stop - start) + " мс");
        }
        int[][] graph = GenerateGraph.generateGraph(5);
        System.out.println("Пример вывода матрицы кратчайших дорог:");
        print(Search.floydWarshall(graph));
    }

    public static void print(int[][] mass) {
        for (int i = 0; i < mass.length; i++) {
            System.out.print("\t" + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < mass.length; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < mass[i].length; j++) {
                System.out.print(mass[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("======================================");
    }

}
