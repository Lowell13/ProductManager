package fr.imie.productmanager.dao.jpa;

import fr.imie.productmanager.dao.CategoryDao;
import fr.imie.productmanager.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JpaCategoryDao implements CategoryDao {

    private EntityManagerFactory emf;


    public JpaCategoryDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void persistCategory(Category category) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            em.persist(category);
            t.commit();
        } finally {
            if (t.isActive()) {
                t.rollback();
            }
            em.close();
        }
    }

    @Override
    public void removeCategory(Category category) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            em.remove(category);
            t.commit();
        } finally {
            if (t.isActive()) {
                t.rollback();
            }
            em.close();
        }
    }

    @Override
    public Category findCategoryByName(String name) {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createNamedQuery("categoryByName");
        query.setParameter("categoryName", name);

        return (Category)query.getSingleResult();
    }

    @Override
    public Category findCategoryById(Long id) {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createNamedQuery("categoryById");
        query.setParameter("categoryId", id);
        return (Category)query.getSingleResult();
    }

    @Override
    public List<Category> findAllCategory() {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createNamedQuery("listCategory");

        return (List<Category>)query.getResultList();
    }
}
