package lk.ijse.spring.project.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class Product {
    @Id
    private String product_id;
    private String product_name;
    private String description;
    private String product_image;
    private int quantity;
    private double unitPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    private Categorie categorie;

    public Product() {
    }

    public Product(String product_id, String product_name, String description, String product_image, int quantity, double unitPrice) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.description = description;
        this.product_image = product_image;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Product(String product_id, String product_name, String description, String product_image, int quantity, double unitPrice, Categorie categorie) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.description = description;
        this.product_image = product_image;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.categorie = categorie;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
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


    @Override
    public String toString() {
        return "Product{" +
                ", product_id='" + product_id + '\'' +
                ", product_name='" + product_name + '\'' +
                ", description='" + description + '\'' +
                ", product_image=" + product_image +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
