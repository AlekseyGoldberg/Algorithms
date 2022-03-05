package Lab3;

public class Soreted {
    public void myQuickSort(Integer[] mass, int L, int R) {

        int l = L;
        int r = R;
        Integer pivot = mass[(l + r) / 2];
        do {
            while (mass[l].compareTo(pivot) < 0) {
                l++;
            }
            while (mass[r].compareTo(pivot) > 0) {
                r--;
            }
            if (l <= r) {
                Integer tmp = mass[l];
                mass[l] = mass[r];
                mass[r] = tmp;

                l++;
                r--;
            }
        } while (l <= r);

        if (l < R) {
            myQuickSort(mass, l, R);
        }
        if (L < r) {
            myQuickSort(mass, L, r);
        }
    }


}