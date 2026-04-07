import java.util.*;

public class Problem5 {

    // Linear Search
    static int linearSearch(String[] arr, String target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear first " + target + ": index " + i + " (" + comparisons + " comparisons)");
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    static void binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                int count = 1;

                // count duplicates
                int left = mid - 1;
                while (left >= 0 && arr[left].equals(target)) {
                    count++;
                    left--;
                }

                int right = mid + 1;
                while (right < arr.length && arr[right].equals(target)) {
                    count++;
                    right++;
                }

                System.out.println("Binary " + target + ": index " + mid + " (" + comparisons + " comparisons), count=" + count);
                return;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }

    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        System.out.println("Sorted logs: [accB, accA, accB, accC]");

        linearSearch(logs, "accB");

        Arrays.sort(logs); // required for binary
        binarySearch(logs, "accB");
    }
}
