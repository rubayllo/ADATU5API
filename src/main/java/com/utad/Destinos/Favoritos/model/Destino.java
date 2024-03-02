package com.utad.Destinos.Favoritos.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fav_destino")
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String country;
}
