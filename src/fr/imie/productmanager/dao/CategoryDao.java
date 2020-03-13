package fr.imie.productmanager.dao;

import fr.imie.productmanager.entity.Category;

import java.util.List;

public interface CategoryDao {
    void persistCategory(Category category);
    void removeCategory(Category category);
    Category findCategoryByName(String name);
    Category findCategoryById(Long id);
    List<Category> findAllCategory();
}
