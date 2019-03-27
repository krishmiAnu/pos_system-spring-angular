package lk.ijse.spring.project.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<CartDetail> cartDetail;

    public Cart(int id, Date date, Customer customer) {
    }

    public Cart(Date date, Customer customer) {
        this.date = date;
        this.customer = customer;
    }

    public Cart(Date date, Customer customer, List<CartDetail> cartDetail) {
        this.date = date;
        this.customer = customer;
        this.cartDetail = cartDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<CartDetail> getCartDetail() {
        return cartDetail;
    }

    public void setCartDetail(List<CartDetail> cartDetail) {
        this.cartDetail = cartDetail;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", date=" + date +
                ", customer=" + customer +
                ", cartDetail=" + cartDetail +
                '}';
    }
}
