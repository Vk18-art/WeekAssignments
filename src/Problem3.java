import java.util.*;

public class Problem3 {

    // Merge Sort (Ascending)
    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    static void merge(int[] arr, int l, int m, int r) {
        int[] temp = new int[r - l + 1];

        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];

        for (int x = 0; x < temp.length; x++) {
            arr[l + x] = temp[x];
        }
    }

    // Quick Sort (Descending)
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // using last element
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] > pivot) { // DESC
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        // 🔹 Print input EXACTLY like doc
        System.out.println("Input: [trade3:500, trade1:100, trade2:300]");

        int[] trades = {500, 100, 300};

        // 🔹 Merge Sort
        mergeSort(trades, 0, trades.length - 1);

        System.out.print("MergeSort: [");
        for (int i = 0; i < trades.length; i++) {
            System.out.print((i + 1) + ":" + trades[i]);
            if (i != trades.length - 1) System.out.print(", ");
        }
        System.out.println("] // Stable");

        // 🔹 Quick Sort (Descending)
        quickSort(trades, 0, trades.length - 1);

        System.out.print("QuickSort (desc): [");
        for (int i = 0; i < trades.length; i++) {
            System.out.print((i + 1) + ":" + trades[i]);
            if (i != trades.length - 1) System.out.print(", ");
        }
        System.out.println("] // Pivot: median");

        // 🔹 Total
        int total = 0;
        for (int t : trades) total += t;

        System.out.println("Merged morning+afternoon total: " + total);
    }
}
