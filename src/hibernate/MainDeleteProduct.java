package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDeleteProduct {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Product.class)
            .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int productId = 1; // example
            session.beginTransaction();

            Product product = session.get(Product.class, productId);
            if (product != null) {
                session.delete(product);
            }

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
