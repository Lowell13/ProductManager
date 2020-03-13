package fr.imie.productmanager.servlet;

import fr.imie.productmanager.entity.TestEntity;

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

@WebServlet(name = "TestJPAServlet", urlPatterns = "/testjpa")
public class TestJPAServlet extends HttpServlet {

    private EntityManagerFactory emf;

    @Override
    public void init() {
        emf = Persistence.createEntityManagerFactory("ProductManagerPersistenceUnit");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TestEntity testEntity = new TestEntity("Hello from code");

        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            em.persist(testEntity);
            t.commit();
        } finally {
            if (t.isActive()) {
                t.rollback();
            }
            em.close();
        }
        response.getWriter().println("TestEntity inserted with id : " + testEntity.getId());
    }

    @Override
    public void destroy() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
