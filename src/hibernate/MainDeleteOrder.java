package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDeleteOrder {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Order.class)
            .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int orderId = 1; // replace with the actual order ID you want to delete

            // start transaction
            session.beginTransaction();

            // retrieve order
            Order order = session.get(Order.class, orderId);

            if (order != null) {
                // delete the order
                session.delete(order);
                System.out.println("Order deleted successfully!");
            } else {
                System.out.println("Order with ID " + orderId + " not found.");
            }

            // commit transaction
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
