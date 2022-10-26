package br.com.unike.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Calculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String elemento;
    @Column
    private String resultado;

    public Calculo() {
    }

    public Calculo(Long id, String elemento, String resultado) {
        this.id = id;
        this.elemento = elemento;
        this.resultado = resultado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Calculo{" +
                "id=" + id +
                ", elemento=" + elemento +
                ", resultado=" + resultado +
                '}';
    }
}
