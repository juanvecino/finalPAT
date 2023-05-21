package edu.comillas.icai.gitt.pat.spring.jpa.controlador;

import edu.comillas.icai.gitt.pat.spring.jpa.repositorio.RepoOperacion;
import edu.comillas.icai.gitt.pat.spring.jpa.repositorio.RepoProducto;
import edu.comillas.icai.gitt.pat.spring.jpa.servicio.ServicioOperaciones;
import edu.comillas.icai.gitt.pat.spring.jpa.servicio.ServicioOperacionesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorOperacion {

    @Autowired
    ServicioOperaciones servicioOperaciones;


    @PostMapping("/operacion/{id_usuario}")
    @ResponseStatus(HttpStatus.OK)
    public void insertarOperacion(@PathVariable("id_usuario") String id_usuario) {
        servicioOperaciones.insertarOperacion(id_usuario);
    }

}
