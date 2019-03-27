package lk.ijse.spring.project.service.impl;

import lk.ijse.spring.project.dto.CartDTO;
import lk.ijse.spring.project.dto.CartDetailDTO;
import lk.ijse.spring.project.dto.CustomerDTO;
import lk.ijse.spring.project.entity.Cart;
import lk.ijse.spring.project.entity.CartDetail;
import lk.ijse.spring.project.repository.CartRepository;
import lk.ijse.spring.project.repository.CustomerRepository;
import lk.ijse.spring.project.repository.ProductRepository;
import lk.ijse.spring.project.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ArrayList<CartDTO> getAllCarts() {
        List<Cart> cartsList = cartRepository.findAll();

        ArrayList<CartDTO> cartsDTOS = new ArrayList<>();
        for (Cart carts: cartsList) {
            List<CartDetailDTO> cartDetailDTOS = new ArrayList<>();
            for (CartDetail cartDetail: carts.getCartDetail()) {
                CartDetailDTO cartDetailDTO = new CartDetailDTO(
                        cartDetail.getId(),
                        cartDetail.getQuantity(),
                        cartDetail.getProduct_id());
                cartDetailDTOS.add(cartDetailDTO);
            }
            CartDTO cartsDTO = new CartDTO(
                    carts.getId(),
                    carts.getDate(),

                    new CustomerDTO(
                            carts.getCustomer().getCust_id(),
                            carts.getCustomer().getFullname(),
                            carts.getCustomer().getAddress(),
                            carts.getCustomer().getCity(),
                            carts.getCustomer().getEmail(),
                            carts.getCustomer().getPhone_no(),
                            carts.getCustomer().getUsername(),
                            carts.getCustomer().getPassword()
                    ),
                    cartDetailDTOS);
            cartsDTOS.add(cartsDTO);
        }
        return cartsDTOS;
    }

    @Override
    public CartDTO getCart(int id) {
        Cart carts = cartRepository.findById(id).get();
        List<CartDetailDTO> cartDetailDTOS = new ArrayList<>();
        for (CartDetail cartDetail: carts.getCartDetail()) {
            CartDetailDTO cartDetailDTO = new CartDetailDTO(
                    cartDetail.getId(),
                    cartDetail.getQuantity(),
                    cartDetail.getProduct_id());
            cartDetailDTOS.add(cartDetailDTO);
        }
        return new CartDTO(carts.getId(), carts.getDate(),
                new CustomerDTO(carts.getCustomer().getCust_id(), carts.getCustomer().getFullname(), carts.getCustomer().getAddress(), carts.getCustomer().getCity(), carts.getCustomer().getEmail(), carts.getCustomer().getPhone_no(), carts.getCustomer().getUsername(),carts.getCustomer().getPassword()),
                cartDetailDTOS);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteCart(int id) {
        cartRepository.deleteById(id);

        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveCart(CartDTO cartDTO) {
        Cart carts = new Cart(cartDTO.getId(),cartDTO.getDate(),customerRepository.findById(cartDTO.getCustomerDTO().getCust_id()).get());

        List<CartDetail> cartDetails = new ArrayList<>();
        for (CartDetailDTO cartDetailDTO:cartDTO.getCartDetailDTOS()) {
            CartDetail cartDetail = new CartDetail(
                    cartDetailDTO.getId(),
                    cartDetailDTO.getQuantity(),
                    cartDetailDTO.getProduct_id(),
                    carts);
            cartDetails.add(cartDetail);
        }

        carts.setCartDetail(cartDetails);

        cartRepository.save(carts);

        return true;
    }

    @Override
    public int getAllCartsCount() {
        return 0;
    }
}
