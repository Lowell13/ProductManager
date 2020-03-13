package fr.imie.productmanager.servlet;

import fr.imie.productmanager.dao.DaoFactory;
import fr.imie.productmanager.dao.ProductDao;
import fr.imie.productmanager.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="BasicInsert", urlPatterns="/auth/basicInsert")
public class BasicInsertServlet extends HttpServlet {

    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        emf = Persistence.createEntityManagerFactory("ProductManagerPersistenceUnit");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product("Manga", "Ceci est un BON manga.", 7.80F);
        ProductDao productDao = DaoFactory.getProductDao();

        productDao.persistProduct(product);
        response.getWriter().println("TestEntity inserted with id : " + product.getId());
    }

    @Override
    public void destroy() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
