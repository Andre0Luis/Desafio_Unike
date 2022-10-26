package br.com.unike.controller.dto;

import br.com.unike.domain.Calculo;

import java.util.List;

public class CalculoResponseDTO {

    private String elemento;
    private String resultado;

    public CalculoResponseDTO() {

    }

    public CalculoResponseDTO(String elemento, String resultado) {
        this.elemento = elemento;
        this.resultado = resultado;
    }

    public CalculoResponseDTO(Calculo calculo) {
        this.elemento = calculo.getElemento();
        this.resultado = calculo.getResultado();
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
                "elemento=" + elemento +
                ", resultado=" + resultado +
                '}';
    }
}
