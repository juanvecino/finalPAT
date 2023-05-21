package edu.comillas.icai.gitt.pat.spring.jpa.entidad;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Formulario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) public Long id;
    @Column(nullable = false) public String nombre;
    @Column(nullable = false) public String email;
    @Column(nullable = false) public String telefono;
    @Column(nullable = false) public String mensaje;
}
