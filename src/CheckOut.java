public class CheckOut {
    /*
     * 1=> Check if the Cart Is Empty Or Not
     * 2=> Check if the item is expired
     * 3=> check if the user holds a quanity in the cart that is greater than the
     * availabe amount
     * 4 => Get the Subtotal and shipping fees for shippable products
     * 5=> total amount will be the sum of both of them
     * 6=> Check if the customer has enough amount of money for total fees
     * 
     */

    public static void checkout(Customers customer, Cart cart) {
        if (cart.IsEmptyList()) {
            System.out.println("Error:The Cart Is Empty");
            return;
        }

        for (CartItem item : cart.getItems()) {
            if (item.getProduct().isExpired()) {
                System.out.println("Error:The Product " + item.getProduct().getName() + " Is Expired");
                return;
            }

            if (item.getQuantity() > item.getProduct().getQuantity()) {
                System.out.println("Error: The Product " + item.getProduct().getName() + "Doesn't have enough amount!");
                return;
            }

        }

        double subtotal = cart.getTotal();
        double shipping = cart.getShippableItems().isEmpty() ? 0 : 30;
        double total = subtotal + shipping;

        if (!customer.canBeAffordable(total)) {
            System.out.println("Error: You Don't have Enought balance in your account!");
            return;
        }

        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        customer.deductAmount(total);

        if (shipping > 0) {
            ShippingService.shipItems(cart.getShippableItems());
        }

        System.out.println("\n** Checkout receipt **");

        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %-12s %.0f\n", item.getQuantity(), item.getProduct().getName(),
                    item.getProduct().calcPrice() * item.getQuantity());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal         %.0f\n", subtotal);
        System.out.printf("Shipping         %.0f\n", shipping);
        System.out.printf("Amount           %.0f\n", total);
        System.out.printf("Balance left     %.0f\n", (double) customer.getBalance());
    }

}
