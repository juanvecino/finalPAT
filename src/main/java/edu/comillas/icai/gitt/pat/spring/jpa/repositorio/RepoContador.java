package edu.comillas.icai.gitt.pat.spring.jpa.repositorio;

import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Contador;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RepoContador extends CrudRepository<Contador, Long> {
    Contador findByNombre(String name);
    @Transactional
    @Modifying
    @Query("DELETE Contador c WHERE c.nombre = :nombre")
    void borraPorNombre(String nombre);
}
