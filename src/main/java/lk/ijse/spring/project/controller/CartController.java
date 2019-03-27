package lk.ijse.spring.project.controller;

import lk.ijse.spring.project.dto.CartDTO;
import lk.ijse.spring.project.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private ArrayList<CartDTO> getAllCarts(){
        return cartService.getAllCarts();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
    private CartDTO getCart(@PathVariable int id){
        return cartService.getCart(id);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
    private boolean deleteCart(@PathVariable int id) {
        return cartService.deleteCart(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private boolean saveCart(@RequestBody CartDTO cartDTO){
        return cartService.saveCart(cartDTO);
    }

    @GetMapping(value = "count", produces = MediaType.APPLICATION_JSON_VALUE)
    private int getAllCartsCount() {
        return cartService.getAllCartsCount();
    }

}
