package lk.ijse.spring.project.dto;

import java.util.Date;
import java.util.List;

public class OrderDTO {
    private int id;
//    private String delivery_add_id;
//    private String payment_method;
//    private int total_quantity;
//    private double total_price;
    private Date date;
    private CustomerDTO customerDTO;
    List<OrderDetailDTO> orderDetailDTOS;

    public OrderDTO() {
    }

    public OrderDTO(int id, Date date, CustomerDTO customerDTO) {
        this.id = id;
        this.date = date;
        this.customerDTO = customerDTO;
    }

    public OrderDTO(int id, Date date, CustomerDTO customerDTO, List<OrderDetailDTO> orderDetailDTOS) {
        this.id = id;
        this.date = date;
        this.customerDTO = customerDTO;
        this.orderDetailDTOS = orderDetailDTOS;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
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

    public List<OrderDetailDTO> getOrderDetailDTOS() {
        return orderDetailDTOS;
    }

    public void setOrderDetailDTOS(List<OrderDetailDTO> orderDetailDTOS) {
        this.orderDetailDTOS = orderDetailDTOS;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", date=" + date +
                ", customerDTO=" + customerDTO +
                ", orderDetailDTOS=" + orderDetailDTOS +
                '}';
    }
}
