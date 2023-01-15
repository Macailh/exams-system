package com.salvadorgerman.examssystem.service;

import com.salvadorgerman.examssystem.persistence.entity.Category;

import java.util.Set;

public interface CategoryService {

    Category addCategory(Category category);

    Category getCategory(Long id);

    Set<Category> getAllCategories();

    Category updateCategory(Category category);

    void deleteCategory(Long id);
}
