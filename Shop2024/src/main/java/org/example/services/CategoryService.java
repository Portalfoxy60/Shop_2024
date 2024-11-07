package org.example.services;

import org.example.model.Category;
import org.example.repository.Repository;

import java.util.List;

public class CategoryService implements Service<Category> {
    private final Repository<Category> repository;

    public CategoryService(Repository<Category> repository) {
        this.repository = repository;
    }

    @Override
    public Category create() {
        System.out.println("===== Создание новой категории =====");
        Category category = new Category();
        return category;
    }

    @Override
    public List<Category> getAll() {
        return repository.load();
    }

    @Override
    public Category getById(Long id) {
        return repository.load().stream()
                .filter(category -> category.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(Long id) {
        List<Category> categories = repository.load();
        categories.removeIf(category -> category.getId().equals(id));
        repository.saveAll(categories);
    }

    @Override
    public void update(Category category) {
        List<Category> categories = repository.load();
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId().equals(category.getId())) {
                categories.set(i, category);
                break;
            }
        }
        repository.saveAll(categories);
    }
}
