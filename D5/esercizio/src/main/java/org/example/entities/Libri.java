package org.example.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="findautore",query="SELECT l FROM Libri l WHERE l.autore=:autore" )
public class Libri extends Catalogo {
    private String autore;
    private String genere;
    public Libri(){

    }

    public Libri(  String title, int pagine, String autore, String genere) {
        super(  title, pagine);
        this.autore=autore;
        this.genere=genere;
    }

    public Libri( String title, int anno, int pagine, String autore, String genere) {
        super( title, anno, pagine);
        this.autore = autore;
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libri{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                ", Codice=" + getCodice() +
                ", title='" + getTitle() + '\'' +
                ", anno=" + getAnno() +
                ", pagine=" + getPagine() +
                '}';
    }

    public String getAutore() {
        return autore;
    }


    @Override
    public long getCodice() {
        return super.getCodice();
    }


    @Override
    public String getTitle() {
        return super.getTitle();
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public int getAnno() {
        return super.getAnno();
    }


    @Override
    public int getPagine() {
        return super.getPagine();
    }


}
