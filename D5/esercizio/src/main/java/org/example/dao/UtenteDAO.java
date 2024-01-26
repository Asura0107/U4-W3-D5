package org.example.dao;

import org.example.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Utente ev) {
        try {
            EntityTransaction transaction = em.getTransaction();// mi da inizio alla transazione con il db
            transaction.begin();
            em.persist(ev);
            transaction.commit();
            System.out.println("aggiunto");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }
    public Utente findid(long Codice){
        return em.find(Utente.class,Codice);
    }

    public void delete(long Codice){
        Utente found=this.findid(Codice);
        if (found!=null){
            EntityTransaction transaction= em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("eliminato Codice: "+Codice);
        }else {
            System.out.println("non trovato");
        }
    }
}
