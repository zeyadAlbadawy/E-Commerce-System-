public class Main {
    public static void main(String[] args) {
        Products cheese = new ShippableProduct("Cheese", 100, 5, false, 0.2);
        Products biscuits = new ShippableProduct("Biscuits", 150, 3, false, 0.7);
        Products tv = new ShippableProduct("TV", 2000, 200, false, 10);
        Products scratchCard = new NonShippableProduct("Scratch Card", 50, 10, false);

        Customers customer = new Customers("Zeyad", 500);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);
        // cart.add(tv, 1);
        CheckOut.checkout(customer, cart);
    }
}
