package org.example.helpers;

import org.example.services.CartService;
import org.example.model.Cart;
import org.example.model.Product;

public class AppHelperCart {

    public static void showCart(CartService cartService) {
        System.out.println("Your cart: ");
        cartService.getCartItems().forEach(item ->
                System.out.println(item.getProduct().getName() + " - " + item.getQuantity())
        );
        System.out.println("Total Price: " + cartService.getCart().calculateTotalPrice());
    }

    public static void removeProductFromCart(CartService cartService, Product product) {
        cartService.removeProductFromCart(product);
        System.out.println("Product removed from cart");
    }
}
