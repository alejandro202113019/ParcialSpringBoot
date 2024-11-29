package co.edu.uptc.ParcialSpringAlejandroMesa.Controller;

import co.edu.uptc.ParcialSpringAlejandroMesa.Entities.Product;
import co.edu.uptc.ParcialSpringAlejandroMesa.Handling.ResponseHandler;
import co.edu.uptc.ParcialSpringAlejandroMesa.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Object> getAllProducts() {
        try {
            List<Product> products = productService.getAllProducts();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, products);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error retrieving products", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
        try {
            Product newProduct = productService.addProduct(product);
            return ResponseHandler.generateResponse("Product created successfully", HttpStatus.CREATED, newProduct);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error creating product", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Método para obtener un producto por ID
    @GetMapping("/{productId}")
    public ResponseEntity<Object> getProductById(@PathVariable Long productId) {
        try {
            Product product = productService.getProductById(productId);
            return ResponseHandler.generateResponse("Product retrieved successfully", HttpStatus.OK, product);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error retrieving product", HttpStatus.NOT_FOUND, null);
        }
    }

    // Método para actualizar un producto
    @PutMapping("/{productId}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long productId, @RequestBody Product productDetails) {
        try {
            Product updatedProduct = productService.updateProduct(productId, productDetails);
            return ResponseHandler.generateResponse("Product updated successfully", HttpStatus.OK, updatedProduct);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error updating product", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Método para actualizar el stock de un producto
    @PatchMapping("/{productId}/stock")
    public ResponseEntity<Object> updateProductStock(@PathVariable Long productId, @RequestParam int quantity) {
        try {
            Product updatedProduct = productService.updateProductStock(productId, quantity);
            return ResponseHandler.generateResponse("Product stock updated successfully", HttpStatus.OK, updatedProduct);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error updating product stock", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}