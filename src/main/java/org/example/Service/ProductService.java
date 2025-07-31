package org.example.Service;

import org.example.Repo.ProductRepo;
import org.example.Repo.entities.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public void createProduct(Product prod){
        ProductRepo.addProduct(prod);
    }
}
