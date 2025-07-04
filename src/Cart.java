import java.util.*;

public class Cart {
    // 1) Create Arraylist of all cartItems That is created from the cartItem Class
    // 2) Check if the entered Quantity is greater than the quantity already exists
    // in the products class
    // -- if that happpend throw an error tells that the amount is not enough
    // -- otherwise add this item to the totalCartItems List
    // 3) Apply getter for getItems
    // 4) add checker to check if the list is empty or not
    // 5) add method to get the total price

    private List<CartItem> totalCartItems = new ArrayList<>();

    public void add(Products product, int quantity) {
        if (product.getQuantity() < quantity) {
            throw new IllegalArgumentException("There is no enough quantity for " + product.getName());
        }
        totalCartItems.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return totalCartItems;
    }

    public boolean IsEmptyList() {
        return totalCartItems.isEmpty();
    }

    public double getTotal() {
        double subTotal = 0;
        for (CartItem item : totalCartItems) {
            subTotal += item.getTotalPrice();
        }
        return subTotal;
    }

    // Get The Shippable items by the help of shippable interface

    public List<Shippable> getShippableItems() {
        List<Shippable> shippables = new ArrayList<>();
        for (CartItem item : totalCartItems) {
            // Check if this item is shippable or not!
            if (item.getProduct() instanceof Shippable) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    // Casting from CartItem To Shippable to be able to store them in shippables
                    shippables.add((Shippable) (item.getProduct()));
                }
            }
        }
        return shippables;
    }
}
