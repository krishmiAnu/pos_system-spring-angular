package lk.ijse.spring.project.dto;

public class CartDetailDTO {
    private int id;
    private int quantity;
    private String product_id;
    private CartDTO cartDTO;

    public CartDetailDTO() {
    }

    public CartDetailDTO(int id, int quantity, String product_id) {
        this.id = id;
        this.quantity = quantity;
        this.product_id = product_id;
    }

    public CartDetailDTO(int id, int quantity, String product_id, CartDTO cartDTO) {
        this.id = id;
        this.quantity = quantity;
        this.product_id = product_id;
        this.cartDTO = cartDTO;
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

    public CartDTO getCartDTO() {
        return cartDTO;
    }

    public void setCartDTO(CartDTO cartDTO) {
        this.cartDTO = cartDTO;
    }

    @Override
    public String toString() {
        return "CartDetailDTO{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", product_id='" + product_id + '\'' +
                ", cartDTO=" + cartDTO +
                '}';
    }
}
