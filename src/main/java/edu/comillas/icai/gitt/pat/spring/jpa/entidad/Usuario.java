package edu.comillas.icai.gitt.pat.spring.jpa.entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) public Long id;
    @Column(nullable = false, unique = true) public String email;
    @Column(nullable = false) public String usuario;
    @Column(nullable = false) public String credenciales;
    @Column(nullable = false) public String rol;
    @Column(nullable = false) public String domicilio;
}