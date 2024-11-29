package co.edu.uptc.ParcialSpringAlejandroMesa.Service;

import co.edu.uptc.ParcialSpringAlejandroMesa.Entities.Customer;
import co.edu.uptc.ParcialSpringAlejandroMesa.Entities.Product;
import co.edu.uptc.ParcialSpringAlejandroMesa.Entities.Sale;
import co.edu.uptc.ParcialSpringAlejandroMesa.Repository.CustomerRepository;
import co.edu.uptc.ParcialSpringAlejandroMesa.Repository.ProductRepository;
import co.edu.uptc.ParcialSpringAlejandroMesa.Repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    public Sale registerSale(Long customerId, List<Long> productIds) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        List<Product> products = productRepository.findProductsByIds(productIds);

        if (products.size() != productIds.size()) {
            throw new RuntimeException("Some products were not found");
        }

        Sale sale = new Sale();
        sale.setCustomer(customer);
        sale.setProducts(products);
        sale.setDate(LocalDate.now());
        return saleRepository.save(sale);
    }

}
