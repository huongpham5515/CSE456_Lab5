package org.example.Repo;

import jakarta.persistence.EntityManager;
import org.example.Repo.entities.Invoice;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceRepo {
    public static void addInvoice(Invoice inv){
        EntityManager em = javaUtil.getEntity();
        em.getTransaction().begin();
        em.persist(inv);
        em.getTransaction().commit();;
        em.close();
    }
}
