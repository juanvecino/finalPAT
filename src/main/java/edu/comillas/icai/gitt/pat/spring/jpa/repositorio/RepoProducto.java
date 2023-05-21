package edu.comillas.icai.gitt.pat.spring.jpa.repositorio;

import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Producto;
import org.springframework.data.repository.CrudRepository;

public interface RepoProducto extends CrudRepository<Producto, Long> {
}
