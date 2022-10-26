package br.com.unike.controller;

import br.com.unike.controller.dto.CalculoDTO;
import br.com.unike.service.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/calculo")
public class CalculoController {

    @Autowired
    private CalculoService calculoService;

    public CalculoController(CalculoService calculoService) {
        this.calculoService = calculoService;
    }

    //Terceiro Objetivo do teste prático
    @PostMapping(path = "/listaOrdenada")
    public ResponseEntity<List<Integer>> listaOrdenada(@RequestBody CalculoDTO dto) {

        List<Integer> result = calculoService.listaOrdenada(dto);

        return ResponseEntity.ok().body(result);
    }

    @PostMapping(path = "/listaDesordenada")
    public ResponseEntity<List<Integer>> listaDesordenada(@RequestBody CalculoDTO lista) {

        List<Integer> result = calculoService.listaDesordenada(lista);

        return ResponseEntity.ok().body(result);
    }
}
