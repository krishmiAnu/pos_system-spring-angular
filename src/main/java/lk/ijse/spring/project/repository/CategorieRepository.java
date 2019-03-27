package lk.ijse.spring.project.repository;

import lk.ijse.spring.project.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategorieRepository extends JpaRepository<Categorie , String>{

    @Query("SELECT count (c.id)FROM Categorie c")
    long getTotalCategories();

}
