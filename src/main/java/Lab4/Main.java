package Lab4;

import javax.crypto.spec.PSource;

public class Main {
    private static int[] massMin = new int[]{500, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000};
    private static int[] massMax = new int[]{1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10_000};

    public static void main(String[] args) {
        GenerateGraph generate = new GenerateGraph();
        for (int i = 0; i < massMax.length; i++) {
            int min = massMin[i];
            int max = massMax[i];
            boolean focus = 1 == (int) (Math.random() * (2));
            Graph graph = new Graph(generate.generateGraph(min, max, focus));
            int rnd = (int) (Math.random() * (graph.getGraph().length));
            DFS dfs = new DFS(graph, (char) rnd);
            BFS bfs = new BFS(graph, (char) rnd);
            startDFS(dfs, focus);
            startBFS(bfs, focus);
        }
    }

    public static void startDFS(DFS dfs, boolean focus) {
        System.out.println("===================================================\nПоиск в глубину работает");
        System.out.println("Ориентированный граф? " + focus);
        System.out.println("Количество вершин в графе: " + dfs.getGraph().length);
        System.out.println("время потраченное на поиск: " + dfs.searchDFS());
        System.out.println("Нашли элемент? " + dfs.isFoundElement());
//        dfs.printLogs();
    }

    public static void startBFS(BFS bfs, boolean focus) {
        System.out.println("===================================================\nПоиск в ширину работает");
        System.out.println("Ориентированный граф? " + focus);
        System.out.println("Количество вершин в графе: " + bfs.getGraph().length);
        System.out.println("время потраченное на поиск: " + bfs.searchBFS());
        System.out.println("Нашли элемент? " + bfs.isFoundElement());
//        bfs.printLogs();
    }


}
