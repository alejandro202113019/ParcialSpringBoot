package co.edu.uptc.ParcialSpringAlejandroMesa.Service;

import co.edu.uptc.ParcialSpringAlejandroMesa.Entities.Customer;
import co.edu.uptc.ParcialSpringAlejandroMesa.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long customerId) {
        // Verificar si el customer existe antes de eliminarlo
        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
        } else {
            throw new RuntimeException("Customer not found with id: " + customerId);
        }
    }
}
