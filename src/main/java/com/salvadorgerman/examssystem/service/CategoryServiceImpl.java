package com.salvadorgerman.examssystem.service;

import com.salvadorgerman.examssystem.persistence.entity.Category;
import com.salvadorgerman.examssystem.persistence.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Set<Category> getAllCategories() {
        return new LinkedHashSet<>(categoryRepository.findAll());
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = new Category();
        category.setId(id);
        categoryRepository.delete(category);
    }
}
