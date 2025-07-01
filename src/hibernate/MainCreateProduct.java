package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreateProduct {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Product.class)
            .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Product product = new Product();
            product.setName("Large Pizza");
            product.setPrice(12.99);

            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
