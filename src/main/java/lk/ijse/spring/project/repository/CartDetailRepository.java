package lk.ijse.spring.project.repository;

import lk.ijse.spring.project.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDetailRepository extends JpaRepository<CartDetail, Integer> {
}
