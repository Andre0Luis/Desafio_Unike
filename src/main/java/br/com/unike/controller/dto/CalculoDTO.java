package br.com.unike.controller.dto;

import java.util.List;

public class CalculoDTO {

    private List<Integer> elementos;

    public CalculoDTO() {
    }

    public CalculoDTO(List<Integer> elementos) {
        this.elementos = elementos;
    }

    public List<Integer> getElementos() {
        return elementos;
    }

    public void setElementos(List<Integer> elementos) {
        this.elementos = elementos;
    }

    @Override
    public String toString() {
        return "CalculoDTO{" +
                "elementos=" + elementos +
                '}';
    }
}
