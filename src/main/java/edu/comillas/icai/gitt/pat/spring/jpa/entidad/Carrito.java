package edu.comillas.icai.gitt.pat.spring.jpa.entidad;

import jakarta.persistence.*;

@Entity
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) public Long id;
    @Column(nullable = false) public String idusuario;
    @Column(nullable = false) public String idproducto;

    @Column(nullable = false, columnDefinition = "bigint default 1")
    public Long unidades;
}
