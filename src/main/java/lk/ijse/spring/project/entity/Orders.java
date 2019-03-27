package lk.ijse.spring.project.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<OrderDetail> orderDetail;

    public Orders() {
    }

    public Orders(int id, Date date, Customer customer) {
        this.id = id;
        this.date = date;
        this.customer = customer;
    }

    public Orders(int id, Date date, Customer customer, List<OrderDetail> orderDetail) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.orderDetail = orderDetail;
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

    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", date=" + date +
                ", customer=" + customer +
                ", orderDetail=" + orderDetail +
                '}';
    }
}
