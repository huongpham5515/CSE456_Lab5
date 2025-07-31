package org.example;

import org.example.Repo.config.AppConfig;
import org.example.Repo.entities.Customer;
import org.example.Repo.entities.Invoice;
import org.example.Repo.entities.Product;
import org.example.Service.CustomerService;
import org.example.Service.InvoiceService;
import org.example.Service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerService cs = appContext.getBean(CustomerService.class);
        InvoiceService is = appContext.getBean(InvoiceService.class);
        ProductService ps = appContext.getBean(ProductService.class);

        Customer cus = new Customer("John Doe", "john.doe@example.com", "09997612", "New York");
        cs.createCustomer(cus);

        Product p1 = new Product("Laptop", 1200.00);
        Product p2 = new Product("Smartphone", 800.00);
        Product p3 = new Product("Tablet", 500.20);

        List<Product> prods = new ArrayList<>();
        prods.add(p1);
        prods.add(p2);
        prods.add(p3);

        Invoice inv = new Invoice(cus, prods);
        is.createInvoice(inv, "InvoiceProduct", LocalDate.now());

    }
}