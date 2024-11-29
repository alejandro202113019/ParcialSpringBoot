package co.edu.uptc.ParcialSpringAlejandroMesa.Repository;

import co.edu.uptc.ParcialSpringAlejandroMesa.Entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {}
