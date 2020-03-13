package fr.imie.productmanager.dao;

import fr.imie.productmanager.entity.Product;

import java.util.List;

public interface ProductDao {
    void persistProduct(Product product);
    void removeProduct(Product product);
    void removeProduct(Long id);
    Product findById(Long id);
    List<Product> findByCategory(Long categoryId);
    List<Product> findAllProducts();
}
