package lk.ijse.spring.project.repository;

import lk.ijse.spring.project.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
