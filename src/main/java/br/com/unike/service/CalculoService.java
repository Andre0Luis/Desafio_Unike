package br.com.unike.service;

import br.com.unike.controller.dto.CalculoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CalculoService {


    //Terceiro Objetivo do teste prático
    public List<Integer> listaOrdenada(CalculoDTO lista) {
        List<Integer> lista_unicos = new ArrayList<>();
        List<Integer> lista_repetidos = new ArrayList<>();

        for (Integer item : lista.getElementos()) {
            if (!lista_unicos.contains(item)) {
                lista_unicos.add(item);
            } else {
                lista_repetidos.add(item);

            }
        }
        return lista_repetidos;
    }

    public List<Integer> listaDesordenada(CalculoDTO lista) {
        Collections.sort(lista.getElementos());
        List<Integer> lista_unicos = new ArrayList<>();
        List<Integer> lista_repetidos = new ArrayList<>();

        for (int item : lista.getElementos()) {
            if (!lista_unicos.contains(item)) {
                lista_unicos.add(item);
            } else {
                lista_repetidos.add(item);
            }
        }
        return lista_repetidos;
    }

}
