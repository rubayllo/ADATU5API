package com.utad.Destinos.Favoritos.controller;

import com.utad.Destinos.Favoritos.model.Destino;
import com.utad.Destinos.Favoritos.service.DestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/destinos")
public class DestinoController {
    private final DestinoService destinoService;

    @Autowired
    public DestinoController(DestinoService destinoService){
        this.destinoService = destinoService;
    }

    @GetMapping
    public ResponseEntity<List<Destino>> getAll() {
        List<Destino> list = destinoService.getDestinos();
        return ResponseEntity.ok(list);
    }


    @PostMapping
    public ResponseEntity<Destino> addOrUpdate(@RequestBody Destino destino) {
        Destino addOrUpdateDestino = destinoService.addOrUpdateDestino(destino);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(addOrUpdateDestino);
    }

    @GetMapping("/{idDestino}")
    public ResponseEntity<Optional<Destino>> getById(@PathVariable Long idDestino) {
        Optional<Destino> destino = Optional.ofNullable(destinoService.getDestinoById(idDestino));

        if(destino.isPresent()){
            return ResponseEntity.ok(destino);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<Destino>> getByCity(@PathVariable String city) {
        List<Destino> list = destinoService.getDestinosByCity(city);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<List<Destino>> getByCountry(@PathVariable String country) {
        List<Destino> list = destinoService.getDestinosByCountry(country);
        return ResponseEntity.ok(list);
    }


    @DeleteMapping("/{idDestino}")
    public ResponseEntity<Optional<Destino>> delete(@PathVariable Long idDestino) {
        destinoService.deleteDestino(idDestino);
        return ResponseEntity.ok().build();
    }

}
