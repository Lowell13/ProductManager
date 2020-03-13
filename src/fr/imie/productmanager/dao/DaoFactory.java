package fr.imie.productmanager.dao;

import fr.imie.productmanager.dao.jpa.JpaCategoryDao;
import fr.imie.productmanager.dao.jpa.JpaProductDao;
import fr.imie.productmanager.utils.PersistenceManager;

public class DaoFactory {

    private DaoFactory() {}

    public static ProductDao getProductDao() {
        return new JpaProductDao(PersistenceManager.getEmf());
    }

    public static CategoryDao getCategoryDao() {
        return new JpaCategoryDao(PersistenceManager.getEmf());
    }
}
