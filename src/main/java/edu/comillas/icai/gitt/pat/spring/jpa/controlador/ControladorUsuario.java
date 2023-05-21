package edu.comillas.icai.gitt.pat.spring.jpa.controlador;

import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Contador;
import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Usuario;
import edu.comillas.icai.gitt.pat.spring.jpa.repositorio.RepoContador;
import edu.comillas.icai.gitt.pat.spring.jpa.repositorio.RepoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ControladorUsuario {
    @Autowired
    RepoUsuario repoUsuario;

    @GetMapping("/api/usuario/login")
    @ResponseStatus(HttpStatus.OK)
    public Usuario login(@RequestHeader("Authorization") String credenciales) {
        Usuario usuario = repoUsuario.findByCredenciales(credenciales);
        if (usuario == null) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        return usuario;
    }

    @PostMapping("/api/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario registrar(@RequestBody Usuario usuario) {
        // Verificar si ya existe un usuario con el mismo email
        Usuario usuarioExistente = repoUsuario.findByEmail(usuario.email);
        if (usuarioExistente != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El correo electrónico ya está en uso");
        }
        // Si no existe, guardar el nuevo usuario
        return repoUsuario.save(usuario);
    }

    @GetMapping("/api/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario getuser(@PathVariable String email) {
        return repoUsuario.findByEmail(email);
    }
}

