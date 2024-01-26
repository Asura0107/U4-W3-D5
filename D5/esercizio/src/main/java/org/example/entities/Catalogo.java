package org.example.entities;

import javax.persistence.*;
import java.util.Random;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQuery(name="findanno", query="SELECT c FROM Catalogo c WHERE c.anno=:anno")
@NamedQuery(name="findtitle", query="SELECT a FROM Catalogo a WHERE LOWER(a.title) LIKE LOWER(:title)")
public abstract class  Catalogo {
    @Id
    @GeneratedValue
    private long  Codice;
    private String title;
    private int anno;
    private int pagine;
    public Catalogo(){}

    public Catalogo( String title, int pagine) {
        Random r=new Random();
        this.title = title;
        this.anno = r.nextInt(1998,2024);
        this.pagine =pagine;
    }

    public Catalogo( String title, int anno, int pagine) {
        this.title = title;
        this.anno = anno;
        this.pagine = pagine;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "Codice=" + Codice +
                ", title='" + title + '\'' +
                ", anno=" + anno +
                ", pagine=" + pagine +
                '}';
    }

    public long getCodice() {
        return Codice;
    }


    public String getTitle() {
        return title;
    }


    public int getAnno() {
        return anno;
    }


    public int getPagine() {
        return pagine;
    }

}
