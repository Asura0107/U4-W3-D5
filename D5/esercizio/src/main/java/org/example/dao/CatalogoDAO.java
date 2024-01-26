package org.example.dao;

import org.example.entities.Catalogo;
import org.example.entities.Libri;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class CatalogoDAO {
    private final EntityManager em;

    public CatalogoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Catalogo ev) {
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

    public Catalogo findCodice(long Codice){
        return em.find(Catalogo.class,Codice);
    }
    public void delete(long Codice){
        Catalogo found=this.findCodice(Codice);
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

    public List<Catalogo> findanno(int anno){
        TypedQuery<Catalogo>  query= em.createNamedQuery("findanno", Catalogo.class);
        query.setParameter("anno", anno);
        return query.getResultList();
    }

    public List<Libri> findautore(String autore) {
        TypedQuery<Libri> query = em.createNamedQuery("findautore", Libri.class);
        query.setParameter("autore", autore);
        return query.getResultList();

    }
    public List<Catalogo> findtitle(String title){
        TypedQuery<Catalogo>  query= em.createNamedQuery("findtitle", Catalogo.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

}
