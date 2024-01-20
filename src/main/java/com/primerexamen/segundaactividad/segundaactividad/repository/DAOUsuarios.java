package com.primerexamen.segundaactividad.segundaactividad.repository;

import com.primerexamen.segundaactividad.segundaactividad.models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface DAOUsuarios extends CrudRepository<Usuario, Integer> {
    Usuario findByNombre(String nombre);
}
