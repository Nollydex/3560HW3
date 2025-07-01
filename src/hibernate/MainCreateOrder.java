package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreateOrder {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Order.class)
            .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // create an order
            Order order = new Order();
            order.setDate("2025-06-30"); // example date

            // start transaction
            session.beginTransaction();

            // save the order
            session.save(order);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Order saved successfully!");
        } finally {
            factory.close();
        }
    }
}
