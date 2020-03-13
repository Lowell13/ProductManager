package fr.imie.productmanager.servlet;

import fr.imie.productmanager.dao.CategoryDao;
import fr.imie.productmanager.dao.DaoFactory;
import fr.imie.productmanager.entity.Category;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AddCategoryServlet", urlPatterns = "/auth/addCategory")
public class AddCategoryServlet extends HttpServlet {

    private EntityManagerFactory emf;

    @Override
    public void init() {
        emf = Persistence.createEntityManagerFactory("ProductManagerPersistenceUnit");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Category toAdd = new Category();
        String categoryName = request.getParameter("category");

        toAdd.setName(categoryName);

        CategoryDao jpaCategoryDao = DaoFactory.getCategoryDao();
        jpaCategoryDao.persistCategory(toAdd);

        response.sendRedirect("/listProduct");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/auth/addCategory.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
