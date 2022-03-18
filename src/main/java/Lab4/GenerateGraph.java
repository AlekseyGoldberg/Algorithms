package Lab4;

public class GenerateGraph {
    public int[][] generateGraph(int minVer, int maxVer, boolean focus) {
        int rndVer = (int) (Math.random() * (maxVer - minVer)) + minVer;
        return focus ? directedGraph(rndVer) : undirectedGraph(rndVer);
    }

    // направленный граф
    private int[][] directedGraph(int rndVer) {
        int[][] myGraph = new int[rndVer][rndVer];
        for (int i = 0; i < rndVer; i++) {
            //количество ребер
            int countEdge = (int) (Math.random() * (rndVer - 1) + 1);
            for (int j = 0; j < countEdge; ) {
                // в какую конкретно вершину будет ребро
                int inputVer = (int) (Math.random() * (rndVer));
                if (i == inputVer)
                    continue;
                myGraph[i][inputVer] = 1;
                myGraph[inputVer][i] = -1;
                j++;
            }
        }
        return myGraph;
    }

    // ненаправленный граф
    private int[][] undirectedGraph(int rndVer) {
        int[][] myGraph = new int[rndVer][rndVer];
        for (int i = 0; i < rndVer; i++) {
            //Количество ребер
            int countEdge = (int) (Math.random() * (rndVer - 1) + 1);
            for (int j = 0; j < countEdge; ) {
                // в какую конкретно вершину будет ребро
                int inputVer = (int) (Math.random() * (rndVer));
                if (i == inputVer)
                    continue;
                myGraph[i][inputVer] = 1;
                myGraph[inputVer][i] = 1;
                j++;
            }
        }
        return myGraph;
    }
}
