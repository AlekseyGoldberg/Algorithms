package Lab4;

import java.util.*;

// Поиск в ширину
public class BFS {
    private int[][] graph;
    private boolean[] visited;
    private List<Integer> logs;
    private int searchSymbol;
    private boolean foundElement;
    private Queue<Integer> queue;

    public BFS(Graph graph, char searchSymbol) {
        this.graph = graph.getGraph();
        this.searchSymbol = (int) searchSymbol - 65;
        logs = new ArrayList<>();
        visited = new boolean[this.graph.length];
        queue = new ArrayDeque<>();
    }

    public long searchBFS() {
        long start = System.currentTimeMillis();
        queue.add(0);
        visited[0] = true;
        loop:
        while (!queue.isEmpty()) {
            int element = queue.poll();
            if (element == searchSymbol) {
                foundElement = true;
                break loop;
            }
            logs.add(element);
            for (int i = 0; i < graph[element].length; i++) {
                if (graph[element][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        long stop = System.currentTimeMillis();
        return stop - start;
    }

    public int[][] getGraph() {
        return graph;
    }

    public void printLogs() {
        for (Integer i : logs)
            System.out.print(i + ", ");
    }

    public boolean isFoundElement() {
        return foundElement;
    }
}
