package hibernate;

import javax.persistence.*;

@Entity
@Table(name = "`Order`") // 'Order' is an SQL keyword; use backticks or rename table
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String date;

    // Constructors
    public Order() {}

    public Order(String date) {
        this.date = date;
    }

    // Getters and setters
    public int getId() { return id; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}
