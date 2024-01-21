package com.primerexamen.segundaactividad.segundaactividad.persistence.repository;

import com.primerexamen.segundaactividad.segundaactividad.persistence.entities.Usuarios;
import org.springframework.data.repository.CrudRepository;

public interface DAOUsuarios extends CrudRepository<Usuarios, Integer> {
    Usuarios findByNombre(String nombre);
}
