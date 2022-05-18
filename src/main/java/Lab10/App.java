package Lab10;

import java.util.Random;

public class App {
    private static double T0;
    public static Random rand = new Random();

    public static void main(String[] args) throws Exception {
        System.out.println(Annealing(-100, 0.5));
    }

    public static double Func(double x) {
        return Math.pow(x, 2) + 10 - 10 * Math.cos(2 * Math.PI * x);
    }

    public static double T(double k) {
        return T0 / k;
    }

    public static double A(double x, double T) {
        return x + T * Cauchy(-1, 1);
    }

    public static double NextDouble(double minimum, double maximum) {
        double temp = rand.nextDouble();
        return temp * (maximum - minimum) + minimum;
    }

    public static double Cauchy(double min, double max) {
        double x1, x2, temp;
        double x0 = min + (max - min) / 2;
        do {
            x1 = NextDouble(-1, 1);
            x2 = NextDouble(-1, 1);
            temp = x0 + Math.tan(Math.PI * (x1 / x2 - 0.5));
        } while (temp < min || temp > max);
        return temp;
    }

    public static double P(double dF, double Tcur) {
        if (dF < 0) {
            return 1;
        }
        return Math.exp(-dF / Tcur);
    }


    public static double Annealing(double x0, double Tend) {
        T0 = 10;
        double xprev = x0;
        int k = 1;
        double globalMin = Func(x0);
        long startTime = System.currentTimeMillis();
        do {
            if (Func(xprev) < globalMin) {
                globalMin = Func(xprev);
            }
            double xcur = A(xprev, T(k));
            System.out.println(T(k));
            double dF = Func(xcur) - Func(xprev);
            if (NextDouble(0, 1) < P(dF, T(k))) {
                //System.out.printf("%-10s\t%-10s", xprev, Func(xprev));

                xprev = xcur;
                k++;
            }
            System.out.println();
            long endTime = System.currentTimeMillis();
            System.out.println((endTime - startTime) + " ms");
        }
        while (T(k) > Tend);
        System.out.println();
        return globalMin;
    }
}