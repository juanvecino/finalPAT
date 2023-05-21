package edu.comillas.icai.gitt.pat.spring.jpa.usuario;

import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureTestDatabase
public class ControladorUsuarioTest {

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    void CreaUserTest() {

        //When ...
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic anVhbjpqdWFu");

        // Crear la solicitud
        HttpEntity<String> request = new HttpEntity<>(headers);

        // Enviar la solicitud
        ResponseEntity<Usuario> response = restTemplate.exchange(
                "http://localhost:8080/api/usuario/login",
                HttpMethod.GET,
                request,
                Usuario.class
        );

        //Then ...
        Assertions.assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());

        //When ...
        Usuario usuario = new Usuario();
        usuario.email = "juan@gmail.com";
        usuario.usuario = "juan";
        usuario.rol = "USER";
        usuario.domicilio ="Mi casa";
        usuario.credenciales = "Basic anVhbjpqdWFu";

        HttpHeaders headers2 = new HttpHeaders();
        headers2.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Usuario> requestPost = new HttpEntity<>(usuario, headers2);
        ResponseEntity<Usuario> creo = restTemplate.postForEntity("http://localhost:8080/api/usuario", requestPost, Usuario.class);

        //Then ...
        Assertions.assertEquals(HttpStatus.CREATED, creo.getStatusCode());
        Assertions.assertEquals(
                usuario.email,
                creo.getBody().email
        );


        //When ...
        ResponseEntity<Usuario> creo2 = restTemplate.postForEntity("http://localhost:8080/api/usuario", requestPost, Usuario.class);

        //Then ...
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, creo2.getStatusCode());

        //When ...
        ResponseEntity<Usuario> estoy = restTemplate.exchange(
                "http://localhost:8080/api/juan@gmail.com",
                HttpMethod.GET, HttpEntity.EMPTY, Usuario.class);
        // Then ...
        Assertions.assertEquals(HttpStatus.OK, estoy.getStatusCode());
        Assertions.assertEquals(
                usuario.email,
                estoy.getBody().email
        );

        //When ...
        HttpHeaders headers3 = new HttpHeaders();
        headers.set("Authorization", "Basic anVhbjpqdWFu");

        // Crear la solicitud
        HttpEntity<String> request3 = new HttpEntity<>(headers);

        // Enviar la solicitud
        ResponseEntity<Usuario> response3 = restTemplate.exchange(
                "http://localhost:8080/api/usuario/login",
                HttpMethod.GET,
                request3,
                Usuario.class
        );

        //Then ...
        Assertions.assertEquals(HttpStatus.OK, response3.getStatusCode());
    }

    @Test
    void loginUsuarioNoExistenteTest() {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Basic anVhbjpqd756567WFu");
            HttpEntity<String> request = new HttpEntity<>(headers);
            ResponseEntity<Usuario> response = restTemplate.exchange(
                    "http://localhost:8080/api/usuario/login",
                    HttpMethod.GET,
                    request,
                    Usuario.class
            );
            Assertions.assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }

    @Test
    void registrarUsuarioTest() {
        Usuario usuario = new Usuario();
        usuario.email = "prube5@gmail.com";
        usuario.usuario = "prube5";
        usuario.rol = "USER";
        usuario.domicilio = "Mi casa";
        usuario.credenciales = "Basic cHJ1YmU1OnBydWJlNQ==";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Usuario> requestPost = new HttpEntity<>(usuario, headers);
        ResponseEntity<Usuario> creo = restTemplate.postForEntity("http://localhost:8080/api/usuario", requestPost, Usuario.class);


        Assertions.assertEquals(HttpStatus.CREATED, creo.getStatusCode());
        Assertions.assertEquals(
                usuario.email,
                creo.getBody().email
        );
    }

        @Test
        void registrarUsuarioExistenteTest() {
            Usuario usuario = new Usuario();
            usuario.email = "juanprueba@gmail.com";
            usuario.usuario = "juanprueba2";
            usuario.rol = "USER";
            usuario.domicilio ="Mi casa";
            usuario.credenciales = "Basic anVhbnBydWViYTI6anVhbnBydWViYTI=";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Usuario> requestPost = new HttpEntity<>(usuario, headers);
            ResponseEntity<Usuario> creo = restTemplate.postForEntity("http://localhost:8080/api/usuario", requestPost, Usuario.class);

            ResponseEntity<Usuario> creo2 = restTemplate.postForEntity("http://localhost:8080/api/usuario", requestPost, Usuario.class);

            Assertions.assertEquals(HttpStatus.BAD_REQUEST, creo2.getStatusCode());
        }

        @Test
        void obtenerUsuarioTest() {
            Usuario usuario = new Usuario();
            usuario.email = "juanprueba3@gmail.com";
            usuario.usuario = "juanprueba3";
            usuario.rol = "USER";
            usuario.domicilio ="Mi casa";
            usuario.credenciales = "Basic anVhbnBydWViYTM6anVhbnBydWViYTM=";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Usuario> requestPost = new HttpEntity<>(usuario, headers);
            ResponseEntity<Usuario> creo = restTemplate.postForEntity("http://localhost:8080/api/usuario", requestPost, Usuario.class);

            ResponseEntity<Usuario> estoy = restTemplate.exchange(
                    "http://localhost:8080/api/juanprueba3@gmail.com",
                    HttpMethod.GET, HttpEntity.EMPTY, Usuario.class);
            Assertions.assertEquals(HttpStatus.OK, estoy.getStatusCode());
            Assertions.assertEquals(usuario.email, estoy.getBody().email);
        }

        @Test
        void loginUsuarioExistenteTest() {
            Usuario usuario = new Usuario();
            usuario.email = "juanprueba4@gmail.com";
            usuario.usuario = "juanprueba4";
            usuario.rol = "USER";
            usuario.domicilio ="Mi casa";
            usuario.credenciales = "Basic anVhbnBydWViYTQ6anVhbnBydWViYTQ=";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Usuario> requestPost = new HttpEntity<>(usuario, headers);
            ResponseEntity<Usuario> creo = restTemplate.postForEntity("http://localhost:8080/api/usuario", requestPost, Usuario.class);

            headers.set("Authorization", "Basic anVhbnBydWViYTQ6anVhbnBydWViYTQ=");
            HttpEntity<String> request = new HttpEntity<>(headers);
            ResponseEntity<Usuario> response = restTemplate.exchange(
                    "http://localhost:8080/api/usuario/login",
                    HttpMethod.GET,
                    request,
                    Usuario.class
            );
            Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        }
    }
