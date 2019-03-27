package lk.ijse.spring.project.controller;

import lk.ijse.spring.project.dto.CustomerDTO;
import lk.ijse.spring.project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<CustomerDTO> getAllCategories(){
        return customerService.getAllCustomers();
    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO getCustomer(@PathVariable("id")String cust_id){
        return customerService.getCustomer(cust_id);
    }
    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteCustomer(@PathVariable("id")String cust_id){
        return customerService.deleteCustomer(cust_id);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveCustomer(@RequestBody CustomerDTO customer){
        return customerService.addCustomer(customer);
    }
    @GetMapping(value = "/count",produces = MediaType.APPLICATION_JSON_VALUE)
    public long getCustomerCount(){
        return customerService.getAllCustomerCount();
    }
}
