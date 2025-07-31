package org.example.Repo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "invoices")
@Entity
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceId;
    private double total;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "invoice_product",
            joinColumns = @JoinColumn(name = "invoiceId"),
            inverseJoinColumns = @JoinColumn(name = "productId"))
    private List<Product> products = new ArrayList<>();

    public Invoice(Customer customer, List<Product> products) {
        this.total = calculatePrice(products);
        this.customer = customer;
        this.products = products;
    }

    public double calculatePrice(List<Product> pros){
        for(Product p: pros){
            this.total += p.getPrice();
        }
        return this.total;
    }
}
