package org.example.services;

import org.example.model.Cart;
import org.example.model.Product;
import java.util.List;

public class CartService {

    private Cart cart;

    public CartService(Cart cart) {
        this.cart = cart;
    }
    public List<Cart.CartItem> getCartItems() {
        return cart.getItems();
    }
    public void addProductToCart(Product product, int quantity) {
        cart.addProduct(product, quantity);
    }
    public void clearCart() {
        cart.getItems().clear();
    }
    public Cart getCart() {
        return cart;
    }
    public void removeProductFromCart(Product product) {
        cart.removeProduct(product);
    }
}
