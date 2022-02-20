package Lab2;

import javax.crypto.spec.PSource;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int[] countN = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};
    private static int countTest = 20;

    public static void main(String[] args) {
        long tmi = System.currentTimeMillis();
        for (int i = 0; i < countN.length; i++) {
            List<Integer> listMaxMinSred = new ArrayList<>();
            List<Long> listOfTime = new ArrayList<>();

            for (int j = 0; j < countTest; j++) {
                Long start = System.currentTimeMillis();
                int count = 0;
                Double[] mass = generateMass(countN[i], -1, 1);
                count = myQuickSort(mass, 0, mass.length - 1, count);
                listMaxMinSred.add(count);
                Long stop = System.currentTimeMillis();
                listOfTime.add(stop - start);
            }
            System.out.println("Min\tMax\tSred");
            minMaxSred(listMaxMinSred);
            System.out.println("============");

        }
        System.out.println(System.currentTimeMillis() - tmi);

    }

    public static void minMaxSred(List<Integer> list) {
        Integer min = list.get(0), max = list.get(0), sred = 0, sum = 0;
        for (Integer e : list) {
            if (e < min)
                min = e;
            if (e > max)
                max = e;
            sum += e;
        }
        System.out.println(min + "\t" + max + "\t" + (double) sum / countTest);
    }


    public static Integer myQuickSort(Double[] mass, int L, int R, int count) {
        count++;
        if (mass.length == 0)
            return null;
        if (L >= R)
            return null;
        int l = L;
        int r = R;
        Double pivot = mass[(l + r) / 2];
        do {
            while (mass[l].compareTo(pivot) < 0) {
                l++;
            }
            while (mass[r].compareTo(pivot) > 0) {
                r--;
            }
            if (l <= r) {
                Double tmp = mass[l];
                mass[l] = mass[r];
                mass[r] = tmp;

                l++;
                r--;
            }
        } while (l <= r);

        if (l < R) {
            count = myQuickSort(mass, l, R, count);
        }
        if (L < r) {
            count = myQuickSort(mass, L, r, count);
        }
        return count;
    }


    public static Double[] generateMass(int N, double a, double b) {
        List<Double> mass = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            double rnd = (Math.random() * (b - a)) + a;
            mass.add(rnd);
        }
        return mass.toArray(new Double[0]);
    }


}
