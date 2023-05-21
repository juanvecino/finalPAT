package edu.comillas.icai.gitt.pat.spring.jpa.repositorio;

import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Formulario;
import org.springframework.data.repository.CrudRepository;

public interface RepoFormulario extends CrudRepository<Formulario, Long> {
    Formulario findByEmail(String email);
}
