package edu.comillas.icai.gitt.pat.spring.jpa.controlador;

import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Carrito;
import edu.comillas.icai.gitt.pat.spring.jpa.repositorio.RepoCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ControladorCarrito {

    @Autowired
    RepoCarrito repoCarrito;

    @PostMapping("/api/carrito")
    @ResponseStatus(HttpStatus.CREATED)
    public Carrito crea(@RequestBody Carrito carrito) {
        // Esta funcion toma un carrito como entrada y crea en la base de datos una nuevo carrito
        return repoCarrito.save(carrito);
    }

    @GetMapping("/api/carrito/{id_usuario}")
    @ResponseStatus(HttpStatus.OK)
    public List<Carrito> lee(@PathVariable("id_usuario") String id_usuario) {
        // Paso el ID del usuario y me devuelve el carrito de ese usuario
        List<Carrito> carritos = repoCarrito.findByIdusuario(id_usuario);
        return carritos;
    }

    @DeleteMapping("/api/carrito/del/{id_carrito}")
    @ResponseStatus(HttpStatus.OK)
    public void borra(@PathVariable("id_carrito") Long id_carrito) {
        // Paso el ID del carrito y me lo elimina de la página
        repoCarrito.deleteById(id_carrito);
    }
}
