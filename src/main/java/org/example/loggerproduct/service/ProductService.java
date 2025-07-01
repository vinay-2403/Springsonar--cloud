package org.example.loggerproduct.service;

import lombok.extern.slf4j.Slf4j;
import org.example.loggerproduct.model.Product;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductService {

    public void validateAndAddProduct() {
        log.trace("TRACE: Entered validateAndAddProduct()");

        Product product = new Product(101, "Laptop", 0.0);
        log.debug("DEBUG: Created Product: {}", product);

        if (product.getPrice() <= 0) {
            log.warn("WARN: Product price is invalid: {}", product.getPrice());
        }

        try {
            simulateDatabaseSave(product);
        } catch (Exception e) {
            log.error("ERROR: Failed to save product: {}", e.getMessage());
        }

        log.info("INFO: Product process completed for {}", product.getName());
        log.trace("TRACE: Exiting validateAndAddProduct()");
    }

    public void simulateDatabaseSave(Product product) throws Exception {
        if (product.getPrice() <= 0) {
            throw new Exception("Price must be greater than 0");
        }
        log.debug("DEBUG: Saving product to database...");
    }
}
