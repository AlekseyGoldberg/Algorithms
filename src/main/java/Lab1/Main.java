package Lab1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] countN={1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};
    static int count=20;
    public static void main(String[] args) throws IOException {
        FileWriter file=new FileWriter("/Users/alekseyzhizhin/IdeaProjects/Algorithms/src/main/java/Lab1/Result.txt");
        for (int i=0;i<countN.length;i++){
            int summ=0;
            file.write(countN[i]+":\t");
            for (int j=0;j<count;j++){
                Double[]mass=generateMass(countN[i],-1,1);
                long time=selectSort(mass);
                summ+=time;
                file.write(time+" \t");
            }
            file.write("среднее значение "+(double)summ/count);
            file.write("\n");
        }
        file.flush();
        file.close();

    }

    public static long selectSort(Double[] mass){
        long start=System.currentTimeMillis();
        for (int i = 0; i < mass.length - 1; ++i) {
            int minPos = i;
            for (int j = i + 1; j < mass.length; ++j) {
                if (mass[j]< mass[minPos]) {
                    minPos = j;
                }
            }
            Double saveValue = mass[minPos];
            mass[minPos] = mass[i];
            mass[i] = saveValue;
        }
        long finish=System.currentTimeMillis();
        return finish-start;
    }

    public static Double[] generateMass(int N,double a, double b){
        List<Double> mass=new ArrayList<>();
        for (int i=0;i<N;i++){
            double rnd=(Math.random()*(b-a))+a;
            mass.add(rnd);
        }
        return mass.toArray(new Double[0]);
    }


}
