package fr.imie.productmanager.dao.jpa;

import fr.imie.productmanager.dao.ProductDao;
import fr.imie.productmanager.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JpaProductDao implements ProductDao {

    private EntityManagerFactory emf;

    public JpaProductDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void persistProduct(Product product) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            em.persist(product);
            t.commit();
        } finally {
            if (t.isActive()) {
                t.rollback();
            }
            em.close();
        }
    }

    @Override
    public void removeProduct(Product product) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        try {
            t.begin();
            em.remove(product);
            t.commit();
        } finally {
            if (t.isActive()) {
                t.rollback();
            }
            em.close();
        }
    }

    @Override
    public void removeProduct(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        Product product = this.findById(id);
        this.removeProduct(product);
    }

    @Override
    public Product findById(Long id) {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createNamedQuery("productById");
        query.setParameter("productId", id);

        return (Product)query.getSingleResult();
    }

    @Override
    public List<Product> findByCategory(Long categoryId) {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createNamedQuery("productByCategory");
        query.setParameter("categoryId", categoryId);

        return (List<Product>)query.getResultList();
    }

    @Override
    public List<Product> findAllProducts() {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createNamedQuery("listProduct");

        return (List<Product>)query.getResultList();
    }
}
