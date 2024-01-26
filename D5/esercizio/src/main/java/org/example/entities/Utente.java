package org.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Utente {

    @Id
    @GeneratedValue
    private long Numerotessera;
    private String Nome;
    private String Cognome;
    private LocalDate Datanascita;

    public Utente() {
    }

    public Utente(String nome, String cognome, LocalDate datanascita) {
        Nome = nome;
        Cognome = cognome;
        Datanascita = datanascita;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public LocalDate getDatanascita() {
        return Datanascita;
    }

    public void setDatanascita(LocalDate datanascita) {
        Datanascita = datanascita;
    }

    public long getNumerotessera() {
        return Numerotessera;
    }

    public void setNumerotessera(long numerotessera) {
        Numerotessera = numerotessera;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "Nome='" + Nome + '\'' +
                ", Cognome='" + Cognome + '\'' +
                ", Datanascita=" + Datanascita +
                ", Numerotessera=" + Numerotessera +
                '}';
    }
}
