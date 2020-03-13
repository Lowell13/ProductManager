package fr.imie.productmanager.servlet;

import fr.imie.productmanager.dao.DaoFactory;
import fr.imie.productmanager.dao.ProductDao;
import fr.imie.productmanager.entity.Product;

import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveProductServlet", urlPatterns = "/auth/removeProduct")
public class RemoveProductServlet extends HttpServlet {
    private EntityManagerFactory emf;

    @Override
    public void init() {
        emf = Persistence.createEntityManagerFactory("ProductManagerPersistenceUnit");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDao productDao = DaoFactory.getProductDao();
        Long productId = Long.parseLong(request.getParameter("id"));

        Product product = productDao.findById(productId);
        productDao.removeProduct(product);

        response.sendRedirect("/listProduct");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
