package fr.imie.productmanager.listener;

import fr.imie.productmanager.utils.PersistenceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class PersistenceAppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("PersistenceAppListener - contextInitialized");
        PersistenceManager.getEmf();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("PersistenceAppListener - contextDestroyed");
        PersistenceManager.closeEmf();
    }
}
