import java.util.*;

public class Problem6 {

    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100};
        int target = 30;

        System.out.println("Sorted risks: [10, 25, 50, 100]");

        // Linear Search
        int comparisons = 0;
        boolean found = false;

        for (int r : risks) {
            comparisons++;
            if (r == target) {
                found = true;
                break;
            }
        }

        System.out.println("Linear: threshold=30 → " + (found ? "found" : "not found") + " (" + comparisons + " comps)");

        // Binary Search for floor & ceiling
        int low = 0, high = risks.length - 1;
        int floor = -1, ceil = -1;
        int comps = 0;

        while (low <= high) {
            comps++;
            int mid = (low + high) / 2;

            if (risks[mid] == target) {
                floor = ceil = risks[mid];
                break;
            } else if (risks[mid] < target) {
                floor = risks[mid];
                low = mid + 1;
            } else {
                ceil = risks[mid];
                high = mid - 1;
            }
        }

        System.out.println("Binary floor(30): " + floor + ", ceiling: " + ceil + " (" + comps + " comps)");
    }
}
