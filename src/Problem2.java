import java.util.*;

class Client {
    String name;
    int riskScore;

    Client(String name, int riskScore) {
        this.name = name;
        this.riskScore = riskScore;
    }
}

public class Problem2 {

    static void bubbleSort(Client[] arr) {
        int swaps = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
        }

        System.out.print("Bubble (asc): [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].name.charAt(arr[i].name.length()-1) + ":" + arr[i].riskScore);
            if (i != arr.length - 1) System.out.print(", ");
        }
        System.out.println("] // Swaps: " + swaps);
    }

    static void insertionSort(Client[] arr) {

        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].riskScore < key.riskScore) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        System.out.print("Insertion (desc): [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].name.charAt(arr[i].name.length()-1) + ":" + arr[i].riskScore);
            if (i != arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        // 🔹 Input (PRINT EXACTLY like doc)
        System.out.println("Input: [clientC:80, clientA:20, clientB:50]");

        Client[] clients = {
                new Client("clientC", 80),
                new Client("clientA", 20),
                new Client("clientB", 50)
        };

        bubbleSort(clients);
        insertionSort(clients);

        System.out.print("Top 3 risks: ");
        for (int i = 0; i < clients.length; i++) {
            System.out.print(clients[i].name.charAt(clients[i].name.length()-1)
                    + "(" + clients[i].riskScore + ")");
            if (i != clients.length - 1) System.out.print(", ");
        }
    }
}
