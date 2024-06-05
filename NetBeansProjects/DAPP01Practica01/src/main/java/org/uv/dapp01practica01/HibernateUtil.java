package org.uv.dapp01practica01;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    
    static {
        try{
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildsessionFactory();
            
        }catch (Throwable ex){
            System.err.println("Initial SessionFactory creation Failed" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getsessionFactory() {
        return sessionFactory;
    }
}
