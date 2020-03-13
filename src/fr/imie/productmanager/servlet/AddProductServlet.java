package fr.imie.productmanager.servlet;

import fr.imie.productmanager.dao.CategoryDao;
import fr.imie.productmanager.dao.DaoFactory;
import fr.imie.productmanager.dao.ProductDao;
import fr.imie.productmanager.entity.Category;
import fr.imie.productmanager.entity.Product;

import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddProduct", urlPatterns="/auth/addProduct")
public class AddProductServlet extends HttpServlet {

    private EntityManagerFactory emf;

    @Override
    public void init() {
        emf = Persistence.createEntityManagerFactory("ProductManagerPersistenceUnit");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product toAdd = new Product();
        CategoryDao categoryDao = DaoFactory.getCategoryDao();
        ProductDao productDao = DaoFactory.getProductDao();

        String categoryName = request.getParameter("categoryName");
        Category category = categoryDao.findCategoryByName(categoryName);

        toAdd.setName(request.getParameter("produit"));
        toAdd.setDescription(request.getParameter("description"));
        toAdd.setPrice(Float.parseFloat(request.getParameter("price")));
        toAdd.setCategory(category);

        productDao.persistProduct(toAdd);

        response.sendRedirect("/showProduct?id=" + toAdd.getId());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDao categoryDao = DaoFactory.getCategoryDao();
        List<Category> categoryList = categoryDao.findAllCategory();

        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("/jsp/auth/addProduct.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
