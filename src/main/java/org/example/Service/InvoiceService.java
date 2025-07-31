package org.example.Service;

import org.example.Repo.InvoiceRepo;
import org.example.Repo.PdfGenerator;
import org.example.Repo.entities.Invoice;
import org.example.Repo.entities.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
public class InvoiceService {
    public PdfGenerator pdf;
    public InvoiceService(PdfGenerator pdf){
        this.pdf = pdf;
    }
    public void createInvoice(Invoice inv, String pdfName, LocalDate date){
        InvoiceRepo.addInvoice(inv);
        System.out.println("#" + inv.getInvoiceId());
        System.out.println("Customer: " + inv.getCustomer().getFullName());
        System.out.println("Products: ");
        for(Product p : inv.getProducts()){
            System.out.println(p.getProductName() + " - $" + p.getPrice());
        }
        System.out.println("Total: $" + inv.getTotal());
        String filename = "Invoice_" + pdfName + "_" + date + ".pdf";
        pdf.generatePdf(filename);
    }
    public void removeInvoice(Invoice inv){
        InvoiceRepo.removeInvoice(inv.getInvoiceId());
    }
}
