package edu.comillas.icai.gitt.pat.spring.jpa.repositorio;

import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Carrito;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepoCarrito extends CrudRepository<Carrito, Long> {

    //Buscador por id_usuario
    List<Carrito> findByIdusuario(String id_usuario);
}
