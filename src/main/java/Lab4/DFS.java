package Lab4;

import java.util.ArrayList;
import java.util.List;

// Поиск в глубину
public class DFS {
    private int[][] graph;
    private boolean[] visited;
    private List<Integer> logs;
    private int searchSymbol;
    private boolean foundElement;

    public DFS(Graph graph, char searchSymbol) {
        logs = new ArrayList<>();
        this.graph = graph.getGraph();
        visited = new boolean[this.graph.length];
        this.searchSymbol = (int) searchSymbol - 65;
    }

    public long searchDFS() {
        long start = System.currentTimeMillis();
        DFS(0);
        long stop = System.currentTimeMillis();
        return stop - start;
    }

    private void DFS(int element) {
        logs.add(element);
        visited[element] = true;
        for (int i = 0; i < graph.length; i++) {
            if ((graph[element][i] == 1) && (!visited[i])) {
                if (searchSymbol == i) {
                    this.foundElement = true;
                    break;
                } else
                    DFS(i);
            }
        }
    }

    public void printLogs() {
        for (Integer i : logs)
            System.out.print(i + ", ");
    }

    public int[][] getGraph() {
        return graph;
    }

    public boolean isFoundElement() {
        return foundElement;
    }
}
