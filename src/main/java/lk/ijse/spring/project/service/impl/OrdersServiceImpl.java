package lk.ijse.spring.project.service.impl;

import lk.ijse.spring.project.dto.CustomerDTO;
import lk.ijse.spring.project.dto.OrderDTO;
import lk.ijse.spring.project.dto.OrderDetailDTO;
import lk.ijse.spring.project.entity.OrderDetail;
import lk.ijse.spring.project.entity.Orders;
import lk.ijse.spring.project.repository.CustomerRepository;
import lk.ijse.spring.project.repository.OrderRepository;
import lk.ijse.spring.project.repository.ProductRepository;
import lk.ijse.spring.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OrdersServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ArrayList<OrderDTO> getAllOrders() {
        List<Orders> ordersList = orderRepository.findAll();

        ArrayList<OrderDTO> ordersDTOS = new ArrayList<>();
        for (Orders orders: ordersList) {
            List<OrderDetailDTO> orderDetailDTOS = new ArrayList<>();
            for (OrderDetail orderDetail: orders.getOrderDetail()) {
                OrderDetailDTO orderDetailDTO = new OrderDetailDTO(
                        orderDetail.getId(),
                        orderDetail.getQuantity(),
                        orderDetail.getUnitPrice(),
                        orderDetail.getProduct_id());
                orderDetailDTOS.add(orderDetailDTO);
            }
            OrderDTO ordersDTO = new OrderDTO(
                    orders.getId(),
                    orders.getDate(),
                    new CustomerDTO(
                            orders.getCustomer().getCust_id(),
                            orders.getCustomer().getFullname(),
                            orders.getCustomer().getAddress(),
                            orders.getCustomer().getCity(),
                            orders.getCustomer().getEmail(),
                            orders.getCustomer().getPhone_no(),
                            orders.getCustomer().getUsername(),
                            orders.getCustomer().getPassword()),
                    orderDetailDTOS);
            ordersDTOS.add(ordersDTO);
        }
        return ordersDTOS;
    }

    @Override
    public OrderDTO getOrder(int id) {
        Orders orders = orderRepository.findById(id).get();
        List<OrderDetailDTO> orderDetailDTOS = new ArrayList<>();
        for (OrderDetail orderDetail: orders.getOrderDetail()) {
            OrderDetailDTO orderDetailDTO = new OrderDetailDTO(
                    orderDetail.getId(),
                    orderDetail.getQuantity(),
                    orderDetail.getUnitPrice(),
                    orderDetail.getProduct_id());
            orderDetailDTOS.add(orderDetailDTO);
        }
        return new OrderDTO(orders.getId(), orders.getDate(),
                new CustomerDTO(orders.getCustomer().getCust_id(), orders.getCustomer().getFullname(), orders.getCustomer().getAddress(), orders.getCustomer().getCity(), orders.getCustomer().getEmail(), orders.getCustomer().getPhone_no(), orders.getCustomer().getUsername(), orders.getCustomer().getPassword()),
                orderDetailDTOS);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteOrder(int id) {
        orderRepository.deleteById(id);

        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addOrder(OrderDTO ordersDTO) {
        Orders orders = new Orders(ordersDTO.getid(), ordersDTO.getDate(), customerRepository.findById(ordersDTO.getCustomerDTO().getCust_id()).get());

        List<OrderDetail> orderDetails = new ArrayList<>();
        for (OrderDetailDTO orderDetailDTO:ordersDTO.getOrderDetailDTOS()) {
            OrderDetail orderDetail = new OrderDetail(
                    orderDetailDTO.getId(),
                    orderDetailDTO.getQuantity(),
                    orderDetailDTO.getUnitPrice(),
                    orderDetailDTO.getProduct_id(),
                    orders);
            orderDetails.add(orderDetail);
        }

        orders.setOrderDetail(orderDetails);

        orderRepository.save(orders);

        return true;
    }

    @Override
    public int getAllOrdersCount() {
        return (int) orderRepository.count();
    }

}
