package org.example.helpers;

import org.example.model.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ProductFileWriterHelper {

    public static void writeProductsToFile(List<Product> products, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Product product : products) {
                writer.write(product.getId() + "," + product.getName() + "," + product.getPrice() + "," + product.getCategory().getName() + "\n");
            }
            System.out.println("Products have been written to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing products to file: " + e.getMessage());
        }
    }
}
