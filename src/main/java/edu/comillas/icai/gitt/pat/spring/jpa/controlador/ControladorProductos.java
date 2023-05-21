package edu.comillas.icai.gitt.pat.spring.jpa.controlador;

import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Contador;
import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Producto;
import edu.comillas.icai.gitt.pat.spring.jpa.repositorio.RepoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControladorProductos {

    @Autowired
    RepoProducto repoProducto;


    @GetMapping("/api/productos")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Producto> getProductos() {
        return repoProducto.findAll();
    }

    @GetMapping("/api/productos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Producto getProducto(@PathVariable("id") Long id) {
        Optional<Producto> productOptional = repoProducto.findById(id);
        if (productOptional.isPresent()) {
            Producto product = productOptional.get();
            // Hacer algo con el producto encontrado
            return product;
        } else {
            throw new RuntimeException("No se encontró ningún producto con el ID " + id);
        }
    }
}
