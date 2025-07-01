package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreate {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Customer.class)
            .addAnnotatedClass(Professor.class)
            .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // create objects
            Professor professor = new Professor();
            professor.setDepartment("Computer Science");

            Customer customer = new Customer();
            customer.setName("Alice");
            customer.setProfessor(professor);

            // start transaction
            session.beginTransaction();

            // save customer (professor auto-saved due to CascadeType.ALL)
            session.save(customer);

            // commit transaction
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
