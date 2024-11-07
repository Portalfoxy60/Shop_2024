package org.example.helpers;

import org.example.model.Cart;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CartFileWriterHelper {

    private static Cart cart;

    public static void writeCartToFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            List<Cart.CartItem> items = cart.getItems();  // Получаем все товары в корзине
            for (Cart.CartItem item : items) {
                writer.write(item.getProduct().getId() + "," + item.getQuantity() + "\n");
            }
            System.out.println("Cart has been written to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing cart to file: " + e.getMessage());
        }
    }
}
