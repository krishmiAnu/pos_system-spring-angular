package lk.ijse.spring.project.service;

import lk.ijse.spring.project.dto.OrderDetailDTO;

import java.util.ArrayList;

public interface OrderDetailService {

    public ArrayList<OrderDetailDTO> getAllOrderDetails();

    public OrderDetailDTO getOrderDetail(int id);

    public boolean deleteOrderDetail(int id);

    public boolean addOrderDetail(OrderDetailDTO orderDetailDTO);

}
