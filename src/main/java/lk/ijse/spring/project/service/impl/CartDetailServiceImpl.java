package lk.ijse.spring.project.service.impl;

import lk.ijse.spring.project.dto.CartDTO;
import lk.ijse.spring.project.repository.CartDetailRepository;
import lk.ijse.spring.project.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public class CartDetailServiceImpl implements CartService{
    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Override
    public ArrayList<CartDTO> getAllCarts() {
        return null;
    }

    @Override
    public CartDTO getCart(int id) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteCart(int id) {
        return false;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveCart(CartDTO cartDTO) {
        return false;
    }

    @Override
    public int getAllCartsCount() {
        return 0;
    }
}
