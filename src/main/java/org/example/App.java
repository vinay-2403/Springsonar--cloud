package org.example;

import org.example.loggerproduct.AppConfig;
import org.example.loggerproduct.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService service = context.getBean(ProductService.class);
        service.validateAndAddProduct();

        System.out.println("Check logs for output.");
    }
}
