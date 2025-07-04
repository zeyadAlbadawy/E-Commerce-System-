public class CartItem {
    protected Products product;
    protected int quantity;

    CartItem(Products product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Products getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return product.calcPrice() * quantity;
    }

}
