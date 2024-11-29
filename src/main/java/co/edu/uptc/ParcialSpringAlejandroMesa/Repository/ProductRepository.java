package co.edu.uptc.ParcialSpringAlejandroMesa.Repository;

import co.edu.uptc.ParcialSpringAlejandroMesa.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.productId IN :productIds")
    List<Product> findProductsByIds(@Param("productIds") List<Long> productIds);
}
