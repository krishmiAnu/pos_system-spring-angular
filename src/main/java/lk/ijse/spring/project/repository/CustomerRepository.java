package lk.ijse.spring.project.repository;

import lk.ijse.spring.project.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
