package org.example.Service;

import org.example.Repo.CustomerRepo;
import org.example.Repo.entities.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    public void createCustomer(Customer cus){
        CustomerRepo.addCustomer(cus);
    }
}
