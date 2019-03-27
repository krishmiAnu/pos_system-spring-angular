package lk.ijse.spring.project.repository;

import lk.ijse.spring.project.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("SELECT count (p.id)FROM Product p")
    long getTotalProducts();
}
