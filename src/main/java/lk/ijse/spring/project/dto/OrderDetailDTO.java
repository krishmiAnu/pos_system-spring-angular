package lk.ijse.spring.project.dto;

public class OrderDetailDTO {
    private int id;
    private int quantity;
    private double unitPrice;
    private  String product_id;
    private OrderDTO orderDTO;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int id, int quantity, double unitPrice, String product_id) {
        this.id = id;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.product_id = product_id;
    }

    public OrderDetailDTO(int id, int quantity, double unitPrice, String product_id, OrderDTO orderDTO) {
        this.id = id;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.product_id = product_id;
        this.orderDTO = orderDTO;
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

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", product_id='" + product_id + '\'' +
                ", orderDTO=" + orderDTO +
                '}';
    }
}
