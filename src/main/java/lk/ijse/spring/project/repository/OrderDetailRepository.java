package lk.ijse.spring.project.repository;

import lk.ijse.spring.project.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>{
}
