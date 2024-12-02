package com.example.ex_jpa.Service;

import com.example.ex_jpa.Model.Category;
import com.example.ex_jpa.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List findAll() {
        return categoryRepository.findAll();
    }
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public Boolean updateCategory(int id ,Category category) {
        Category oldCategory = categoryRepository.findById(id).get();
        if(oldCategory != null) {
            oldCategory.setCategoryName(category.getCategoryName());
            categoryRepository.save(oldCategory);
            return true;
        }
        return false;
    }
    public Boolean deleteCategory(int id) {
        Category category = categoryRepository.findById(id).get();
        if(category != null) {
            categoryRepository.delete(category);
            return true;
        }
        return false;
    }
}
