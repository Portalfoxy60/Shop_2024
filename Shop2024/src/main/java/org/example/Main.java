package org.example;

import org.example.helpers.CartFileWriterHelper;
import org.example.helpers.ProductFileWriterHelper;
import org.example.input.ConsoleInput;
import org.example.input.Input;
import org.example.services.CartService;
import org.example.services.ProductService;
import org.example.repository.Storage;
import org.example.model.Cart;
import org.example.model.Product;

class App {

    private final Input input;
    private final ProductService productService;
    private final CartService cartService;

    public App(Input input, ProductService productService, CartService cartService) {
        this.input = input;
        this.productService = productService;
        this.cartService = cartService;
    }

    public void run() {
        boolean repeat = true;
        System.out.println("--------------- Shop 2024 --------------");

        while (repeat) {
            System.out.println("1. See products");
            System.out.println("2. Add product to cart");
            System.out.println("3. View cart");
            System.out.println("4. Checkout");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1:
                    productService.printProducts();
                    break;
                case 2:
                    System.out.print("Enter product ID to add to cart: ");
                    int productId = Integer.parseInt(input.nextLine());
                    Product product = productService.getProductById(productId);
                    if (product != null) {
                        cartService.addProductToCart(product, 1);
                        System.out.println("Product added to cart.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    System.out.println("Your cart: ");
                    cartService.getCartItems().forEach(item ->
                            System.out.println(item.getProduct().getName() + " - " + item.getQuantity()));
                    break;
                case 4:
                    System.out.print("Enter your card number: ");
                    String cardNumber = input.nextLine();
                    System.out.println("Payment successful!");
                    cartService.clearCart();

                    CartFileWriterHelper.writeCartToFile("cart.txt");

                    ProductFileWriterHelper.writeProductsToFile(productService.getAllProducts(), "products.txt");
                    break;
                case 0:
                    repeat = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        System.out.println("Goodbye!");
    }
}
