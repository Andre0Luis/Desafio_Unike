package br.com.unike.controller;

import br.com.unike.controller.dto.CalculoDTO;
import br.com.unike.controller.dto.CalculoResponseDTO;
import br.com.unike.service.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/calculo")
public class CalculoController {

    @Autowired
    private final CalculoService calculoService;

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

    //Quarto Objetivo do teste prático
    @PostMapping(path = "/db/listaOrdenada")
    public ResponseEntity<List<Integer>> listaOrdenadaDB(@RequestBody CalculoDTO dto) {

        try {
            if (!dto.getElementos().isEmpty()){
                List<Integer> result = calculoService.listaOrdenadaDB(dto);
                return ResponseEntity.ok().body(result);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping(path = "/db/listaDesordenada")
    public ResponseEntity<List<Integer>> listaDesordenadaDB(@RequestBody CalculoDTO lista) {

         try {
             if (!lista.getElementos().isEmpty()){
                 List<Integer> result = calculoService.listaDesordenadaDB(lista);
                 return ResponseEntity.ok().body(result);
             } else {
                 return ResponseEntity.noContent(   ).build();
             }
         } catch (Exception e) {
             return ResponseEntity.badRequest().build();
         }

    }

    @GetMapping(path = "/db")
    public ResponseEntity<List<CalculoResponseDTO>> buscarTodos(){

        try {
            List<CalculoResponseDTO> result = calculoService.findAll();
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping(path = "db/{id}")
    public ResponseEntity<CalculoResponseDTO> buscarPorId(@PathVariable Long id){

        try{
            Optional<CalculoResponseDTO> result = calculoService.findById(id);

            if (result.isPresent()) {
                return ResponseEntity.ok().body(result.get());
            } else {
                return ResponseEntity.notFound().build();
            }

        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "db/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) throws Exception {

        try {
            calculoService.deleteCalculo(id);
            return ResponseEntity.accepted().body("Calculo de id " + id + " Apagado com Sucesso!");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao deletar Calculo de id " + id);
        }
    }

}
