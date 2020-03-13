package fr.imie.productmanager.rest;

import fr.imie.productmanager.dao.DaoFactory;
import fr.imie.productmanager.dao.ProductDao;
import fr.imie.productmanager.entity.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/product")
public class ProductResource {

    @GET @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProducts() {
        ProductDao productDao = DaoFactory.getProductDao();
        System.out.println("I was here !");
        return productDao.findAllProducts();
    }

    @GET @Path("/search/{id}") @Produces(MediaType.APPLICATION_JSON)
    public Product findProductById(@PathParam("id") Long productId) {
        ProductDao productDao = DaoFactory.getProductDao();
        return productDao.findById(productId);

    }

    @DELETE @Path("/remove/{id}")
    public void removeProduct(@PathParam("id") Long productId) {
        ProductDao productDao = DaoFactory.getProductDao();
        productDao.removeProduct(productId);
    }

    @POST @Path("/add") @Consumes(MediaType.APPLICATION_JSON)
    public void addProduct(Product product) {
        ProductDao productDao = DaoFactory.getProductDao();
        productDao.persistProduct(product);
    }

}
