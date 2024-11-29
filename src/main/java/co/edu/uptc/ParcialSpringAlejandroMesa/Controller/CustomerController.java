package co.edu.uptc.ParcialSpringAlejandroMesa.Controller;
import co.edu.uptc.ParcialSpringAlejandroMesa.Entities.Customer;
import co.edu.uptc.ParcialSpringAlejandroMesa.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.uptc.ParcialSpringAlejandroMesa.Handling.ResponseHandler;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<Object> getAllCustomers() {
        try {
            List<Customer> customers = customerService.getAllCustomers();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, customers);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error retrieving customers", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {
        try {
            Customer newCustomer = customerService.addCustomer(customer);
            return ResponseHandler.generateResponse("Customer created successfully", HttpStatus.CREATED, newCustomer);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error creating customer", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable Long customerId) {
        try {
            customerService.deleteCustomer(customerId);
            return ResponseHandler.generateResponse("Customer deleted successfully", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error deleting customer", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}

