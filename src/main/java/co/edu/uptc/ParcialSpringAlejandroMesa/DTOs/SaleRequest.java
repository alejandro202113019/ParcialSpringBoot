package co.edu.uptc.ParcialSpringAlejandroMesa.DTOs;

import java.util.List;

public class SaleRequest {

    private Long customerId;
    private List<Long> productIds;

    // Constructor
    public SaleRequest(Long customerId, List<Long> productIds) {
        this.customerId = customerId;
        this.productIds = productIds;
    }

    // Getters y setters
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }
}
