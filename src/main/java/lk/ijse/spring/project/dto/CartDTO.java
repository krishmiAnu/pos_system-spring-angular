package lk.ijse.spring.project.dto;

import java.util.Date;
import java.util.List;

public class CartDTO {
    private int id;
    private Date date;
    private CustomerDTO customerDTO;
    List<CartDetailDTO> cartDetailDTOS;

    public CartDTO() {
    }

    public CartDTO(int id, Date date, CustomerDTO customerDTO) {
        this.id = id;
        this.date = date;
        this.customerDTO = customerDTO;
    }

    public CartDTO(int id, Date date, CustomerDTO customerDTO, List<CartDetailDTO> cartDetailDTOS) {
        this.id = id;
        this.date = date;
        this.customerDTO = customerDTO;
        this.cartDetailDTOS = cartDetailDTOS;
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

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public List<CartDetailDTO> getCartDetailDTOS() {
        return cartDetailDTOS;
    }

    public void setCartDetailDTOS(List<CartDetailDTO> cartDetailDTOS) {
        this.cartDetailDTOS = cartDetailDTOS;
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "id=" + id +
                ", date=" + date +
                ", customerDTO=" + customerDTO +
                ", cartDetailDTOS=" + cartDetailDTOS +
                '}';
    }
}
