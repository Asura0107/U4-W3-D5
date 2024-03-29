package org.example.dao;

import org.example.entities.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class PrestitoDAO {
    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito ev) {
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
    public Prestito findid(long Codice){
        return em.find(Prestito.class,Codice);
    }

    public void delete(long Codice){
        Prestito found=this.findid(Codice);
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

    public List<Prestito> findtessera(long numero) {
        TypedQuery<Prestito> query = em.createNamedQuery("findtessera", Prestito.class);
        query.setParameter("numero", numero);
        return query.getResultList();

    }
    public List<Prestito> findscaduti() {
        TypedQuery<Prestito> query = em.createNamedQuery("findscaduti", Prestito.class);
        return query.getResultList();

    }




}
