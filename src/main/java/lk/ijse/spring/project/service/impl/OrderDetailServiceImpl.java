package lk.ijse.spring.project.service.impl;

import lk.ijse.spring.project.dto.OrderDetailDTO;
import lk.ijse.spring.project.repository.OrderDetailRepository;
import lk.ijse.spring.project.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public ArrayList<OrderDetailDTO> getAllOrderDetails() {
        return null;
    }

    @Override
    public OrderDetailDTO getOrderDetail(int id) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteOrderDetail(int id) {
        return false;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addOrderDetail(OrderDetailDTO orderDetailDTO) {
        return false;
    }
}