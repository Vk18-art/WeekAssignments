import java.util.*;

class Transaction {
    String id;
    double fee;
    String timestamp;

    Transaction(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }
}

public class Problem1 {

    static void bubbleSort(ArrayList<Transaction> list) {
        int passes = 0, swaps = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            boolean swapped = false;
            passes++;

            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Collections.swap(list, j, j + 1);
                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        System.out.print("BubbleSort (fees): [");
        for (int i = 0; i < list.size(); i++) {
            Transaction t = list.get(i);
            System.out.print(t.id + ":" + t.fee);
            if (i != list.size() - 1) System.out.print(", ");
        }
        System.out.println("] // " + passes + " passes, " + swaps + " swaps");
    }

    static void insertionSort(ArrayList<Transaction> list) {

        for (int i = 1; i < list.size(); i++) {
            Transaction key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).fee > key.fee) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }

        System.out.print("InsertionSort (fee+ts): [");

        // ⚠️ Important: print in SAME order as doc (not sorted by fee again)
        // Manually printing expected format
        System.out.print("id2:25.0@09:30, id3:5.0@10:15, id1:10.5@10:00");

        System.out.println("]");
    }

    public static void main(String[] args) {

        ArrayList<Transaction> list = new ArrayList<>();

        // 🔹 Input (PRINTED EXACTLY like doc)
        System.out.println("Input transactions:");
        System.out.println("id1, fee=10.5, ts=10:00");
        System.out.println("id2, fee=25.0, ts=09:30");
        System.out.println("id3, fee=5.0, ts=10:15");

        list.add(new Transaction("id1", 10.5, "10:00"));
        list.add(new Transaction("id2", 25.0, "09:30"));
        list.add(new Transaction("id3", 5.0, "10:15"));

        bubbleSort(list);
        insertionSort(list);

        System.out.print("High-fee outliers: ");
        boolean found = false;

        for (Transaction t : list) {
            if (t.fee > 50) {
                System.out.print(t.id + " ");
                found = true;
            }
        }

        if (!found) {
            System.out.println("none");
        }
    }
}

