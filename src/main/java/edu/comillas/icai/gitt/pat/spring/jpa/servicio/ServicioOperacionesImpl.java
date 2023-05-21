package edu.comillas.icai.gitt.pat.spring.jpa.servicio;

import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Carrito;
import edu.comillas.icai.gitt.pat.spring.jpa.entidad.Operacion;
import edu.comillas.icai.gitt.pat.spring.jpa.repositorio.RepoCarrito;
import edu.comillas.icai.gitt.pat.spring.jpa.repositorio.RepoOperacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class ServicioOperacionesImpl implements ServicioOperaciones{


    @Autowired
    RepoCarrito repoCarrito;
    @Autowired
    RepoOperacion repoOperacion;

    @Override
    public void insertarOperacion(String id_usuario) {
        List<Carrito> carritos = repoCarrito.findByIdusuario(id_usuario);

        if (carritos != null) {
            carritos.forEach(carrito -> {
                Operacion operacion = new Operacion();
                var id_producto = carrito.idproducto;
                operacion.usuarioId = id_usuario;
                operacion.productoId = id_producto;
                operacion.tipo = "COMPRA";
                operacion.fecha = Timestamp.from(Instant.now());
                repoOperacion.save(operacion);
                repoCarrito.deleteById(carrito.id);
            });
        } else {
            throw new IllegalStateException("No se encontraron carritos para el usuario: " + id_usuario);
        }
        }
}
