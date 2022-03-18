package Lab4;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int[][] graph;

    public Graph(int[][] graph) {
        this.graph = graph;
    }

    // Возвращает матрицу
    public int[][] getGraph() {
        return graph;
    }

    //Возвращает список смежности
    public List<List<Integer>> getListAdjacency() {
        List<List<Integer>> listAdjacency = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            List<Integer> localList = new ArrayList<>();
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 0 || graph[i][j] == -1)
                    continue;
                else {
                    localList.add(j);
                }
            }
            listAdjacency.add(localList);
        }
        return listAdjacency;
    }


    public void printGraphMatrix() {
        System.out.println("Вывод графа в виде матрицы:");
        System.out.print("\t");
        for (int i = 0; i < graph.length; i++) {
            System.out.print((char) (i + 65) + "\t");
        }
        System.out.println();
        for (int i = 0; i < graph.length; i++) {
            System.out.print((char) (i + 65) + "\t");
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("=======================================================");
    }

    // Печатает список смежности
    public void printGraphAdjacency() {
        System.out.println("Вывод списка смежности:");
        for (int i = 0; i < graph.length; i++) {
            StringBuilder str = new StringBuilder();
            char letter = (char) (i + 65);
            str.append(letter).append(": ");
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 0 || graph[i][j] == -1)
                    continue;
                else {
                    str.append((char) (j + 65)).append(",");
                }
            }
            System.out.println(str);
        }
        System.out.println("=======================================================");
    }


//    //Список ребер
//    public void printListEdge() {
//        System.out.print("Список ребер:");
//        int max = GenerateGraph.getMax();
//        List<List<String>> listEdge = new ArrayList<>(max);
//        for (int i = 0; i < max; i++) {
//            listEdge.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < graph.length; i++) {
//            for (int j = 0; j < graph.length; j++) {
//                if (i == j)
//                    continue;
//                int edge = graph[i][j];
//                listEdge.get(edge).add((char) (i + 65) + "-" + (char) (j + 65));
//            }
//        }
//        // подумать над выводом, неправильные числа выводит
//        for (int i=0;i< listEdge.size();i++) {
//            if (!listEdge.get(i).isEmpty()&&i!=0)
//                System.out.print("\n"+i+": ");
//            for (int j=0;j<listEdge.get(i).size();j++){
//                if (!(i==0||listEdge.get(i).size()==0))
//                    System.out.print(listEdge.get(i).get(j)+", ");
//            }
//
//        }
//        System.out.println("\n=======================================================");
//    }
}
