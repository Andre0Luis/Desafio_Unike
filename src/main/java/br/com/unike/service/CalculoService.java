package br.com.unike.service;

import br.com.unike.controller.dto.CalculoDTO;
import br.com.unike.controller.dto.CalculoResponseDTO;
import br.com.unike.domain.Calculo;
import br.com.unike.repository.CalculoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CalculoService {

    private CalculoRepository calculoRepository;

    public CalculoService(CalculoRepository calculoRepository) {
        this.calculoRepository = calculoRepository;
    }

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

    //Quarto Objetivo do teste prático
    public List<Integer> listaOrdenadaDB(CalculoDTO lista) {
        List<Integer> lista_unicos = new ArrayList<>();
        List<Integer> lista_repetidos = new ArrayList<>();

        for (Integer item : lista.getElementos()) {
            if (!lista_unicos.contains(item)) {
                lista_unicos.add(item);
            } else {
                lista_repetidos.add(item);

            }
        }

        Calculo calculo = new Calculo();
        calculo.setElemento(lista.getElementos().toString());
        calculo.setResultado(lista_repetidos.toString());

        calculoRepository.save(calculo);

        return lista_repetidos;
    }

    public List<Integer> listaDesordenadaDB(CalculoDTO lista) {
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

        Calculo calculo = new Calculo();
        calculo.setElemento(lista.getElementos().toString());
        calculo.setResultado(lista_repetidos.toString());

        calculoRepository.save(calculo);

        return lista_repetidos;
    }

    public List<CalculoResponseDTO> findAll(){
        return calculoRepository.findAll().stream().map(CalculoResponseDTO::new).collect(Collectors.toList());
    }

    public Optional<CalculoResponseDTO> findById(Long id){
        return calculoRepository.findById(id).map(CalculoResponseDTO::new);
    }

    public void deleteCalculo(Long id) throws Exception {
        try {
            calculoRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception();
        }
    }


}
