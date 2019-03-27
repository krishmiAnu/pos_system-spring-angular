package lk.ijse.spring.project.service;

import lk.ijse.spring.project.dto.CartDTO;

import java.util.ArrayList;

public interface CartService {
    public ArrayList<CartDTO> getAllCarts();

    public CartDTO getCart(int id);

    public boolean deleteCart(int id);

    public boolean saveCart(CartDTO cartDTO);

    public int getAllCartsCount();
}
