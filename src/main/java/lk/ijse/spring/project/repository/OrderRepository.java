package lk.ijse.spring.project.repository;

import lk.ijse.spring.project.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Integer>{
}
