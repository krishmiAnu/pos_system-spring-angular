package lk.ijse.spring.project.service;

import lk.ijse.spring.project.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {

    public ArrayList<CustomerDTO> getAllCustomers();

    public CustomerDTO getCustomer(String id);

    public boolean deleteCustomer(String id);

    public boolean addCustomer(CustomerDTO customerDTO);

    public int getAllCustomerCount();
}
