package lk.ijse.spring.project.service.impl;

import lk.ijse.spring.project.dto.CustomerDTO;
import lk.ijse.spring.project.entity.Customer;
import lk.ijse.spring.project.repository.CustomerRepository;
import lk.ijse.spring.project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();;

        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
        for ( Customer customer: customers ) {
        CustomerDTO customerDTO = new CustomerDTO(customer.getCust_id(), customer.getFullname(), customer.getAddress(),customer.getCity(),customer.getEmail(),customer.getPhone_no(),customer.getUsername(),customer.getPassword());
        customerDTOS.add(customerDTO);
        }

        return customerDTOS;
        }

    @Override
    public CustomerDTO getCustomer(String id) {
        Customer customer = customerRepository.findById(id).get();
        return new CustomerDTO(customer.getCust_id(), customer.getFullname(), customer.getAddress(),customer.getCity(),customer.getEmail(),customer.getPhone_no(),customer.getUsername(),customer.getPassword());
        }

    @Override
    @Transactional(propagation = Propagation.REQUIRED) // aluthen transaction1k aarambha kranna)
    public boolean deleteCustomer(String id) {
        customerRepository.deleteById(id);
        return true;
        }

    @Override
    @Transactional(propagation = Propagation.REQUIRED) // aluthen transaction1k aarambha kranna)
    public boolean addCustomer(CustomerDTO customerDTO) {
        customerRepository.save(new Customer(customerDTO.getCust_id(), customerDTO.getFullname(), customerDTO.getAddress(),customerDTO.getCity(),customerDTO.getEmail(),customerDTO.getPhone_no(),customerDTO.getUsername(),customerDTO.getPassword()));
        return true;
        }

    @Override
    public int getAllCustomerCount() {
        return (int) customerRepository.count();
    }
}
