package org.example.services;

import org.example.model.Product;
import org.example.repository.Storage;
import java.util.List;

public class ProductService {

    private final Storage<Product> productStorage;

    public ProductService(Storage<Product> productStorage) {
        this.productStorage = productStorage;
    }

    public List<Product> getAllProducts() {
        return productStorage.load();  // Загружаем все продукты
    }
    public void printProducts() {
        List<Product> products = getAllProducts();
        products.forEach(product -> System.out.println(product.getId() + ": " + product.getName() + " - $" + product.getPrice()));
    }

    public void saveProduct(Product product) {
        productStorage.save(product);  // Сохранение одного продукта
    }

    public Product getProductById(int id) {
        return productStorage.load().stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
