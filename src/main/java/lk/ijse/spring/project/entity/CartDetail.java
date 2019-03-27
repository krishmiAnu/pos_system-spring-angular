package lk.ijse.spring.project.entity;

import javax.persistence.*;

@Entity
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int quantity;
    private String product_id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Cart cart;

    public CartDetail(int id, int quantity, String product_id, Cart carts) {
    }

    public CartDetail(int quantity, String product_id) {
        this.quantity = quantity;
        this.product_id = product_id;
    }

    public CartDetail(int quantity, String product_id, Cart cart) {
        this.quantity = quantity;
        this.product_id = product_id;
        this.cart = cart;
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

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "CartDetail{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", product_id='" + product_id + '\'' +
                ", cart=" + cart +
                '}';
    }
}
