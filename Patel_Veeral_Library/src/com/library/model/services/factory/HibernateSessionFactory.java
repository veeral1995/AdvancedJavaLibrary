package com.library.model.services.factory;
import com.library.model.domain.Book;
import com.library.model.domain.CD;
import com.library.model.domain.Movie;
import static com.library.model.services.factory.HibernateSessionFactory.log;
import java.io.File;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author vpatel48
 */
public class HibernateSessionFactory {

    static Logger log = Logger.getLogger("com.library.model.services.factory.HibernateSessionFactory");
    
    //log.info("Inside HibernateSessionFactory");

    private static final ThreadLocal threadLocal = new ThreadLocal();
    private static ServiceRegistry serviceRegistry;
    private static org.hibernate.SessionFactory sessionFactory;

    public static Session currentSession() throws HibernateException {
        
       Session session = (Session) threadLocal.get();
       String hibernatePropsFilePath = "/Users/vpatel48/Downloads/Patel_Veeral_Library/src/resources/hibernate.cfg.xml";
       File hibernatePropsFile = new File(hibernatePropsFilePath);

        if (session == null || !session.isOpen()) {
            log.info("Inside HibernateSessionFactory Session");
            if (sessionFactory == null) {
                try {
                            Configuration configuration = new Configuration();
                            Properties settings = new Properties();
                            settings.put(Environment.DRIVER , "com.mysql.jdbc.Driver");
                            settings.put(Environment.URL , "jdbc:mysql://localhost:3306/sys?autoReconnect=true&useSSL=false");
                            settings.put(Environment.USER , "root");
                            settings.put(Environment.PASS , "V33ralp,1997");
                            settings.put(Environment.DIALECT , "org.hibernate.dialect.MySQL5Dialect");
                            settings.put(Environment.SHOW_SQL , "true");
                            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS , "thread");
                            settings.put(Environment.HBM2DDL_AUTO , "update");
                            
                            //c3p0 config
                            settings.put(Environment.C3P0_MIN_SIZE, 5);
                            settings.put(Environment.C3P0_MAX_SIZE , 20);
                            settings.put(Environment.C3P0_ACQUIRE_INCREMENT , 1);
                            settings.put(Environment.C3P0_TIMEOUT , 1800);
                            settings.put(Environment.C3P0_MAX_STATEMENTS , 150);
                            settings.put(Environment.C3P0_CONFIG_PREFIX+".initialPoolSize", 5);
                            
                            configuration.setProperties(settings);
                            configuration.addAnnotatedClass(Book.class);
                            configuration.addAnnotatedClass(CD.class);
                            configuration.addAnnotatedClass(Movie.class);
                            
                            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                            
                            log.info(sessionFactory.toString());
                    
                } catch (Exception e) {
                    log.error("%%%% Error Creating SessionFactory %%%%", e);
                }
            }
            session = (sessionFactory != null) ? sessionFactory.openSession() : null;
            threadLocal.set(session);
        }
        
        if(session == null){
         log.debug("SESSION NULL ERROR");
        }
        return session;
    }

    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }

    public static void closeFactory() throws HibernateException {
        closeSessionAndFactory();
    }
    
    public static void closeSessionAndFactory() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }

        if (sessionFactory != null) {
            sessionFactory.close();
            sessionFactory = null;
        }
    }
    private HibernateSessionFactory() {
    }
}