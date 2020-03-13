package fr.imie.productmanager.rest;

import fr.imie.productmanager.dao.CategoryDao;
import fr.imie.productmanager.dao.DaoFactory;
import fr.imie.productmanager.dao.ProductDao;
import fr.imie.productmanager.entity.Category;
import fr.imie.productmanager.entity.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/category")
public class CategoryResource {

    @GET @Path("/{id}") @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getCategory(@PathParam("id") Long categoryId) {
        ProductDao productDao = DaoFactory.getProductDao();

        return productDao.findByCategory(categoryId);
    }

    @POST @Consumes(MediaType.APPLICATION_JSON)
    public void addCategory(Category category) {
        CategoryDao categoryDao = DaoFactory.getCategoryDao();
        categoryDao.persistCategory(category);
    }

    @PUT @Consumes(MediaType.APPLICATION_JSON)
    public void updateCategory(Category category) {
        CategoryDao categoryDao = DaoFactory.getCategoryDao();
        categoryDao.persistCategory(category);
    }
}
