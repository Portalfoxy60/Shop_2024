package org.example.helpers;

import org.example.input.Input;
import org.example.model.Category;

import java.util.List;

public class AppHelperCategory implements AppHelper<Category> {
    private final Input input;

    public AppHelperCategory(Input input) {
        this.input = input;
    }

    @Override
    public Category create() {
        try {
            System.out.println("===== Новая категория =====");
            Category category = new Category();
            System.out.print("Название категории: ");
            category.setName(input.nextLine());
            return category;
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.toString());
            return null;
        }
    }

    @Override
    public boolean printList(List<Category> categories) {
        if (categories == null || categories.isEmpty()) {
            System.out.println(" --- Список категорий пуст --- ");
            return false;
        } else {
            System.out.println(" --- Список категорий --- ");
            for (int i = 0; i < categories.size(); i++) {
                System.out.printf("%d. %s%n",
                        i + 1,
                        categories.get(i).getName());
            }
            System.out.println(" --- Конец списка --- ");
            return true;
        }
    }

    @Override
    public List<Category> editEntities(List<Category> entities) {
        printList(entities);
        System.out.println("Выберите номер категории для редактирования: ");
        int numberCategory = Integer.parseInt(input.nextLine());
        Category category = entities.get(numberCategory - 1);

        System.out.println("Изменить название категории (y/n): ");
        String changeName = input.nextLine();
        if (changeName.equals("y")) {
            System.out.println("Новое название категории: ");
            category.setName(input.nextLine());
        }

        return entities;
    }
}
