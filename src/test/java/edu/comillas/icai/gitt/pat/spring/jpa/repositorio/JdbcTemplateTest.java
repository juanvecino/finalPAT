package edu.comillas.icai.gitt.pat.spring.jpa.repositorio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
class JdbcTemplateTest {
    @Autowired JdbcTemplate jdbc;
    final String credencialesIntroducidasPorUsuarioMalicioso = "'credenciales incorrectas' OR ID = 1";

    @Test void codigoVulnerableSqlInjectionTest() {
        String sql = "SELECT * FROM USUARIO WHERE CREDENCIALES = " + credencialesIntroducidasPorUsuarioMalicioso;

        Map<String, Object> usuarioAutenticado = jdbc.queryForMap(sql);

        assertNotNull(usuarioAutenticado);
        assertEquals(1L, usuarioAutenticado.get("ID"));
    }

    @Test void codigoProtegidoSqlInjectionTest() {
        String sqlParametrizada = "SELECT * FROM USUARIO WHERE CREDENCIALES = ?";

        EmptyResultDataAccessException errorUsuarioNoEncontrado = null;
        Map<String, Object> usuarioAutenticado = null;
        try {
            usuarioAutenticado = jdbc.queryForMap(sqlParametrizada, credencialesIntroducidasPorUsuarioMalicioso);
        } catch (EmptyResultDataAccessException e) { errorUsuarioNoEncontrado = e; }

        assertNull(usuarioAutenticado);
        assertNotNull(errorUsuarioNoEncontrado);
    }
}