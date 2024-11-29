package co.edu.uptc.ParcialSpringAlejandroMesa.Controller;

import co.edu.uptc.ParcialSpringAlejandroMesa.DTOs.SaleRequest;
import co.edu.uptc.ParcialSpringAlejandroMesa.Entities.Sale;
import co.edu.uptc.ParcialSpringAlejandroMesa.Handling.ResponseHandler;
import co.edu.uptc.ParcialSpringAlejandroMesa.Service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @PostMapping
    public ResponseEntity<Object> registerSale(@RequestBody SaleRequest saleRequest) {
        try {
            Sale sale = saleService.registerSale(saleRequest.getCustomerId(), saleRequest.getProductIds());
            return ResponseHandler.generateResponse("Sale registered successfully", HttpStatus.CREATED, sale);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error registering sale", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
