package lk.ijse.spring.project.controller;

import lk.ijse.spring.project.dto.OrderDTO;
import lk.ijse.spring.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private ArrayList<OrderDTO> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
    private OrderDTO getOrder(@PathVariable int id){
        return orderService.getOrder(id);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
    private boolean deleteOrder(@PathVariable int id) {
        return orderService.deleteOrder(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private boolean addOrder(@RequestBody OrderDTO ordersDTO){
        return orderService.addOrder(ordersDTO);
    }

    @GetMapping(value = "count", produces = MediaType.APPLICATION_JSON_VALUE)
    private int getAllOrdersCount() {
        return orderService.getAllOrdersCount();
    }
}
