package lk.ijse.spring.project.service;

import lk.ijse.spring.project.dto.CartDetailDTO;

import java.util.ArrayList;

public interface CartDetailService {
    public ArrayList<CartDetailDTO> getAllCartDetails();

    public CartDetailDTO getCartDetail(int id);

    public boolean deleteCartDetail(int id);

    public boolean addCartDetail(CartDetailDTO cartDetailDTO);
}
