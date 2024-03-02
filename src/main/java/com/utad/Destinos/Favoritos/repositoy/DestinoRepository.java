package com.utad.Destinos.Favoritos.repositoy;

import com.utad.Destinos.Favoritos.model.Destino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long> {

    List<Destino> findByCityContainingIgnoreCase(String city);

    List<Destino> findByCountryContainingIgnoreCase(String country);
}