package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDelete {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Customer.class)
            .addAnnotatedClass(Professor.class)
            .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int customerId = 1; // example ID
            Customer customer = session.get(Customer.class, customerId);

            if (customer != null) {
                session.delete(customer); // professor deleted via CascadeType.ALL
            }

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
