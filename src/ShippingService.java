import java.util.*;

public class ShippingService {
    public static void shipItems(List<Shippable> items) {

        // Create Two maps
        // 1 => name -> weight
        // 2 => name -> quantity

        Map<String, Double> grouped = new HashMap<>();
        Map<String, Integer> counted = new HashMap<>();

        for (Shippable item : items) {
            grouped.put(item.getName(), grouped.getOrDefault(item.getName(), 0.0) + item.getWeight());
            counted.put(item.getName(), counted.getOrDefault(item.getName(), 0) + 1);
        }

        double totalWeight = 0.0;
        for (String name : grouped.keySet()) {
            int quantity = counted.get(name);
            double weight = grouped.get(name);
            totalWeight += weight;
            System.out.printf("%dx %-12s %.0fg\n", quantity, name, weight * 1000);
        }
        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}
