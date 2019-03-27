package lk.ijse.spring.project.entity;

import javax.persistence.*;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int quantity;
    private double unitPrice;
    private  String product_id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Orders order;

    public OrderDetail() {
    }

    public OrderDetail(int quantity, double unitPrice, double price, String product_id, Orders order) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.product_id = product_id;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", product_id='" + product_id + '\'' +
                ", order=" + order +
                '}';
    }
}
