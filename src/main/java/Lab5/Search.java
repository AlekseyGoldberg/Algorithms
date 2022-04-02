package Lab5;

public class Search {

    public static int[][] floydWarshall(int[][] graph) {
        // создаем матрицу ходов. из какой вершины в какую пойдем
        int[][] H = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] != GenerateGraph.INFINITY && graph[i][j] != 0)
                    // Записываем в ячейку номер вершины +1(тк нумерация с 0)
                    H[i][j] = j + 1;
            }
        }
        // Проходимся по каждой вершине, если длина AB>AC+CB, то в матрицу H[A][B]=H[B][С] записываем
        for (int k = 0; k < graph.length; k++) {
            for (int j = 0; j < graph.length; j++) {
                for (int i = 0; i < graph.length; i++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                        H[i][j] = H[i][k];
                    }
                }
            }
        }
        return H;
    }

}
