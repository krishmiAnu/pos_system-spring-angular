package lk.ijse.spring.project.service;

import lk.ijse.spring.project.dto.OrderDTO;

import java.util.ArrayList;

public interface OrderService {

    public ArrayList<OrderDTO> getAllOrders();

    public OrderDTO getOrder(int id);

    public boolean deleteOrder(int id);

    public boolean addOrder(OrderDTO ordersDTO);

    public int getAllOrdersCount();
}
