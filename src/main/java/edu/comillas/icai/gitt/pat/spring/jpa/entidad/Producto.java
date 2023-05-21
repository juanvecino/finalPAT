package edu.comillas.icai.gitt.pat.spring.jpa.entidad;

import jakarta.persistence.*;


@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) public Long id;
    @Column(nullable = false, unique = true) public String id_product;
    @Column(nullable = false) public String nombre;
    @Column public String descripcion;
    @Column(nullable = false) public Float price;
    @Column(nullable = false) public String url;
    @Column(nullable = false) public Float valoracion;
}