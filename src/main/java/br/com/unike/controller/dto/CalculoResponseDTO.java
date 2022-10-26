package br.com.unike.controller.dto;

import br.com.unike.domain.Calculo;

public class CalculoResponseDTO {

    private Long id;
    private String elemento;
    private String resultado;

    public CalculoResponseDTO() {

    }

    public CalculoResponseDTO(Long id, String elemento, String resultado) {
        this.id = id;
        this.elemento = elemento;
        this.resultado = resultado;
    }

    public CalculoResponseDTO(Calculo calculo) {
        this.id = calculo.getId();
        this.elemento = calculo.getElemento();
        this.resultado = calculo.getResultado();
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
        return "CalculoResponseDTO{" +
                "id=" + id +
                ", elemento='" + elemento + '\'' +
                ", resultado='" + resultado + '\'' +
                '}';
    }
}
