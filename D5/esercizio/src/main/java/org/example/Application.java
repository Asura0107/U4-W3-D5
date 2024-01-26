package org.example;

import com.github.javafaker.Faker;
import org.example.dao.CatalogoDAO;
import org.example.dao.PrestitoDAO;
import org.example.dao.UtenteDAO;
import org.example.entities.Libri;
import org.example.entities.Prestito;
import org.example.entities.Riviste;
import org.example.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Random;

public class Application {
    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("test4");


    public static void main(String[] args) {
        EntityManager em=emf.createEntityManager();
        CatalogoDAO cd= new CatalogoDAO(em);
        UtenteDAO ud=new UtenteDAO(em);
        PrestitoDAO pd=new PrestitoDAO(em);
        Faker faker=new Faker();
        Random r= new Random();

        Libri libri=new Libri(faker.book().title(), r.nextInt(100,300),faker.book().author(),faker.book().genre() );
        cd.save(libri);

        Riviste riviste=new Riviste(r.nextInt(20,50),faker.book().title(), Riviste.periodicità.SETTIMANALE );
        cd.save(riviste);

        Utente utente1=new Utente(faker.name().firstName(), faker.name().lastName(), LocalDate.of(1999,1,1));
        Utente utente2=new Utente(faker.name().firstName(), faker.name().lastName(), LocalDate.of(2003,4,26));
        ud.save(utente1);
        ud.save(utente2);

        Prestito prestito1=new Prestito(utente1,LocalDate.now().minusDays(2),null,libri);
        pd.save(prestito1);
        Prestito prestito2=new Prestito(utente1,LocalDate.now().minusDays(2),LocalDate.now().plusDays(10),riviste);
        pd.save(prestito2);

        //-------------find codice--------------
        System.out.println("---------------codice---------------");
        if (cd.findCodice(2)!=null) {
            System.out.println(cd.findCodice(2));
        } else {
            System.out.println("not found");
        }


       // ----------------find anno-----------------------
        System.out.println("----------anno----------------");
        if (!cd.findanno(2018).isEmpty()) {
            cd.findanno(2018).forEach(System.out::println);
        } else {
            System.out.println("not found");
        }



       //------------------find autore-----------------------
        System.out.println("--------------------autore---------------");
        if (!cd.findautore("Keenan Johnston").isEmpty()) {
            cd.findautore("Keenan Johnston").forEach(System.out::println);
        } else {
            System.out.println("not found");
        }


        //------------------------find title--------------------
        System.out.println("-----------------title----------------");
        if (!cd.findtitle("pale kings and Princes").isEmpty()) {
            cd.findtitle("pale kings and Princes").forEach(System.out::println);
        } else {
            System.out.println("not found");
        }

        //-------------find in prestito-------------
        System.out.println("-----------------prestito----------------");
        if (!pd.findtessera(3).isEmpty()) {
            pd.findtessera(3).forEach(System.out::println);
        } else {
            System.out.println("not found");
        }

        //---------------find scaduti----------------
        System.out.println("--------------------scaduti---------------");
        if (! pd.findscaduti().isEmpty()) {
            pd.findscaduti().forEach(System.out::println);
        } else {
            System.out.println("not found");
        }

        em.close();
        emf.close();




    }
}
