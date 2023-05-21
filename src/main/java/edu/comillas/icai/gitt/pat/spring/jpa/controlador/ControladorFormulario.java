package edu.comillas.icai.gitt.pat.spring.jpa.controlador;

import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Formulario;
import edu.comillas.icai.gitt.pat.spring.jpa.repositorio.RepoFormulario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ControladorFormulario{
    @Autowired
    RepoFormulario repoFormulario;

    @PostMapping("/api/formulario")
    @ResponseStatus(HttpStatus.CREATED)
    public Formulario registrar_mensaje(@RequestBody Formulario formulario) {
        Formulario form_existente = repoFormulario.findByEmail(formulario.email);
        if (form_existente != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El mensaje ya ha sido enviado!");
        }
        // Si no existe, guardar el nuevo usuario
        return repoFormulario.save(formulario);
    }
}
