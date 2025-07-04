import java.util.*;

public class ShippingService {
    public static void shipItems(List<Shippable> items) {
        System.out.println("** Shipment notice **");

        // Use LinkedHashMap to preserve order
        Map<String, Integer> counted = new LinkedHashMap<>();
        Map<String, Double> weightPerItem = new LinkedHashMap<>();

        for (Shippable item : items) {
            String name = item.getName();
            counted.put(name, counted.getOrDefault(name, 0) + 1);
            weightPerItem.put(name, item.getWeight()); // assume all items of same name have same weight
        }

        double totalWeight = 0.0;

        for (String name : counted.keySet()) {
            int quantity = counted.get(name);
            double singleWeight = weightPerItem.get(name);
            double totalItemWeight = quantity * singleWeight;
            totalWeight += totalItemWeight;

            // ✅ Now we print one line per product with total quantity and total weight
            System.out.printf("%dx %-12s %.0fg\n", quantity, name, totalItemWeight * 1000);
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}
