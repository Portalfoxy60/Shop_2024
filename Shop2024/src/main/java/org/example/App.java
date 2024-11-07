package org.example;

import org.example.input.ConsoleInput;
import org.example.input.Input;
import org.example.services.CartService;
import org.example.services.ProductService;
import org.example.repository.Storage;
import org.example.model.Cart;
import org.example.model.Product;

class Main {

    public static void main(String[] args) {

        Input input = new ConsoleInput();
        Storage productStorage = new Storage<>("products.txt");
        ProductService productService = new ProductService(productStorage);
        Cart cart = new Cart();
        CartService cartService = new CartService(cart);
        App app = new App(input, productService, cartService);

        app.run();
    }
}
