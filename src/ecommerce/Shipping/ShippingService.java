package ecommerce.Shipping;

import java.util.List;

public class ShippingService {
    public void shipItems(List<ShippableItem> items) {
        System.out.println("\n** Shipment notice **");

        double totalWeight = 0;
        for (ShippableItem item : items) {
            System.out.println(item.getName());
            totalWeight += item.getWeight();
        }

        System.out.printf("Total package weight: %.1fkg%n", totalWeight);
    }
}
