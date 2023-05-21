package edu.comillas.icai.gitt.pat.spring.jpa.repositorio;

import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Usuario;
import org.springframework.data.repository.CrudRepository;


public interface RepoUsuario extends CrudRepository<Usuario, Long> {
    Usuario findByCredenciales(String credenciales);

    Usuario findByEmail(String email);


}
