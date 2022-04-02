package Lab5;

public class GenerateGraph {
    private final static int minLengthEdge = 1;
    private final static int maxLengthEdge = 20;
    public static int INFINITY = 1_000_000_000;

    public static int[][] generateGraph(int ver) {
        return directedGraph(ver);
    }

    // направленный граф
    private static int[][] directedGraph(int rndVer) {
        int[] rndCountEdge = new int[]{3, 4, 10, 20};
        int[][] myGraph = new int[rndVer][rndVer];
        for (int i = 0; i < rndVer; i++) {
            //количество ребер
            int countEdge = (int) (Math.random() * (rndCountEdge.length));
            for (int j = 0; j < rndCountEdge[countEdge]; ) {
                // в какую конкретно вершину будет ребро
                int inputVer = (int) (Math.random() * (rndVer));
                // Длина ребра
                int lengthEdge = (int) (Math.random() * (maxLengthEdge - minLengthEdge) + minLengthEdge);
                if (i == inputVer) continue;
                myGraph[i][inputVer] = lengthEdge;
                myGraph[inputVer][i] = INFINITY;
                j++;
            }
        }
        return myGraph;
    }
}
