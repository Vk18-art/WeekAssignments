import java.util.*;

class Asset {
    String name;
    double returnRate;
    double volatility;

    Asset(String name, double returnRate, double volatility) {
        this.name = name;
        this.returnRate = returnRate;
        this.volatility = volatility;
    }
}

public class Problem4 {

    // Merge Sort (Ascending returnRate)
    static void mergeSort(List<Asset> list) {
        list.sort(Comparator.comparingDouble(a -> a.returnRate));
    }

    // Quick Sort logic using Comparator
    static void quickSort(List<Asset> list) {
        list.sort((a, b) -> {
            if (b.returnRate != a.returnRate)
                return Double.compare(b.returnRate, a.returnRate); // DESC return
            return Double.compare(a.volatility, b.volatility); // ASC volatility
        });
    }

    public static void main(String[] args) {

        System.out.println("Input: [AAPL:12%, TSLA:8%, GOOG:15%]");

        List<Asset> assets = new ArrayList<>();
        assets.add(new Asset("AAPL", 12, 0.3));
        assets.add(new Asset("TSLA", 8, 0.5));
        assets.add(new Asset("GOOG", 15, 0.2));

        // Merge Sort
        mergeSort(assets);
        System.out.print("Merge: [");
        for (int i = 0; i < assets.size(); i++) {
            System.out.print(assets.get(i).name + ":" + assets.get(i).returnRate + "%");
            if (i != assets.size() - 1) System.out.print(", ");
        }
        System.out.println("]");

        // Quick Sort
        quickSort(assets);
        System.out.print("Quick (desc): [");
        for (int i = 0; i < assets.size(); i++) {
            System.out.print(assets.get(i).name + ":" + assets.get(i).returnRate + "%");
            if (i != assets.size() - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
