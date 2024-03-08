package com.utad.Destinos.Favoritos.service;

import com.utad.Destinos.Favoritos.model.Destino;
import com.utad.Destinos.Favoritos.repositoy.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinoService {

    private final DestinoRepository destinoRepository;

    @Autowired
    public DestinoService(DestinoRepository destinoRepository) {
        this.destinoRepository = destinoRepository;
    }

    public List<Destino> getDestinos(){
        return destinoRepository.findAll();
    }


    public Destino getDestinoById(Long id){
        return destinoRepository.findById(id).orElse(null);
    }

    public Destino addOrUpdateDestino(Destino destino){
        return destinoRepository.save(destino);
    }

    public void deleteDestino(Long id){
        destinoRepository.deleteById(id);
    }

    public List<Destino> getDestinosByCity(String city){
        return destinoRepository.findByCityContainingIgnoreCase(city);
    }

    public List<Destino> getDestinosByCountry(String country) {
        return destinoRepository.findByCountryContainingIgnoreCase(country);
    }

}
