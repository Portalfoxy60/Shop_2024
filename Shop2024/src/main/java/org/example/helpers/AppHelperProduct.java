package org.example.helpers;

import org.example.input.Input;
import org.example.model.Product;
import org.example.model.Category;

import java.util.List;

public class AppHelperProduct implements AppHelper<Product> {
    private final Input input;

    public AppHelperProduct(Input input) {
        this.input = input;
    }

    @Override
    public Product create() {
        try {
            System.out.println("===== Новый продукт =====");
            Product product = new Product();
            System.out.print("Название продукта: ");
            product.setName(input.nextLine());
            System.out.print("Цена продукта: ");
            product.setPrice(input.nextDouble());
            input.nextLine();
            System.out.print("Выберите категорию продукта: ");
            String categoryName = input.nextLine();
            Category category = new Category(categoryName);
            product.setCategory(category);

            return product;
        } catch (Exception e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean printList(List<Product> products) {
        if (products == null || products.isEmpty()) {
            System.out.println(" --- Список продуктов пуст --- ");
            return false;
        } else {
            System.out.println(" --- Список продуктов --- ");
            for (int i = 0; i < products.size(); i++) {
                System.out.printf("%d. %s - %.2f - Категория: %s%n",
                        i + 1,
                        products.get(i).getName(),
                        products.get(i).getPrice(),
                        products.get(i).getCategory().getName());
            }
            System.out.println(" --- Конец списка --- ");
            return true;
        }
    }

    @Override
    public List<Product> editEntities(List<Product> entities) {
        return entities;
    }
}
