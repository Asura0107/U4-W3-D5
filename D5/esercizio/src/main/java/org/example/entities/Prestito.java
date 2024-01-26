package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@NamedQuery(name="findtessera", query = "SELECT p FROM Prestito p WHERE p.utente.Numerotessera = :numero")
@NamedQuery(name="findscaduti", query = "SELECT t FROM Prestito t WHERE t.Resteffettiva IS NULL OR t.Resteffettiva > t.Dataprevistarest ")
public class Prestito {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="utente_id")
    private Utente utente;
    private LocalDate Datainizioprestito;
    private LocalDate Dataprevistarest ;

    private LocalDate Resteffettiva;
    @OneToOne
    @JoinColumn(name="catalogo_id")
    private Catalogo catalogo;

    public Prestito(Utente utente, LocalDate datainizioprestito, LocalDate resteffettiva, Catalogo catalogo) {
        this.utente = utente;
        this.Datainizioprestito = datainizioprestito;
        this.Dataprevistarest=datainizioprestito.plusDays(30);

        this.Resteffettiva = resteffettiva;
        this.catalogo = catalogo;
    }
    public Prestito(){}

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public LocalDate getDatainizioprestito() {
        return Datainizioprestito;
    }

    public void setDatainizioprestito(LocalDate datainizioprestito) {
        Datainizioprestito = datainizioprestito;
    }

    public LocalDate getDataprevistarest() {
        return Dataprevistarest;
    }

    public void setDataprevistarest(LocalDate dataprevistarest) {
        Dataprevistarest = dataprevistarest;
    }

    public LocalDate getResteffettiva() {
        return Resteffettiva;
    }

    public void setResteffettiva(LocalDate resteffettiva) {
        Resteffettiva = resteffettiva;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", Datainizioprestito=" + Datainizioprestito +
                ", Dataprevistarest=" + Dataprevistarest +
                ", Resteffettiva=" + Resteffettiva +
                ", catalogo=" + catalogo +
                '}';
    }
}
