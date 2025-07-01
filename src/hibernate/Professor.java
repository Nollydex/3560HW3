package hibernate;

import javax.persistence.*;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String department;

    // Constructors
    public Professor() {}

    public Professor(String department) {
        this.department = department;
    }

    // Getters and setters
    public int getId() { return id; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}
