package fr.imie.productmanager.dao;

import fr.imie.productmanager.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class OLD_ProductDao {
    private static List<Product> productList = new ArrayList<>();
    private static Long count = 0L;

    public static List<Product> getAllProducts() {
        return productList;
    }

    public static void addProduct(Product p) {
        count++;
        p.setId(count);
        productList.add(p);
    }

    public static Product findProduct(Long id) {
        Product product = null;

        for (Product p: productList) {
            if (p.getId().equals(id))
                product = p;
        }

        return product;
    }

    public static void removeProduct(Long id) {
        productList.removeIf(product -> product.getId().equals(id));
    }
}
