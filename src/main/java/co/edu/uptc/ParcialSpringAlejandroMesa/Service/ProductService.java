package co.edu.uptc.ParcialSpringAlejandroMesa.Service;

import co.edu.uptc.ParcialSpringAlejandroMesa.Entities.Product;
import co.edu.uptc.ParcialSpringAlejandroMesa.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        // Validar que el stock no sea negativo
        if (product.getStock() < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        return productRepository.save(product);
    }

    // Método para obtener un producto por ID
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
    }

    // Método para actualizar un producto
    public Product updateProduct(Long productId, Product productDetails) {
        Product existingProduct = getProductById(productId);

        // Actualizar campos que pueden ser modificados
        existingProduct.setName(productDetails.getName());
        existingProduct.setPrice(productDetails.getPrice());

        return productRepository.save(existingProduct);
    }

    // Método para validar y actualizar stock
    public Product updateProductStock(Long productId, int quantity) {
        Product product = getProductById(productId);

        // Validar si hay suficiente stock para una reducción
        if (product.getStock() + quantity < 0) {
            throw new IllegalArgumentException("Insufficient stock");
        }

        product.setStock(product.getStock() + quantity);
        return productRepository.save(product);
    }

    // Método para validar stock
    public boolean validateStock(Long productId) {
        Product product = getProductById(productId);
        return product.getStock() > 0;
    }
}
