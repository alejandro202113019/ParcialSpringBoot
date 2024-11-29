package co.edu.uptc.ParcialSpringAlejandroMesa.Repository;

import co.edu.uptc.ParcialSpringAlejandroMesa.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {}
