package com.primerexamen.segundaactividad.segundaactividad.services.usuario;

import com.primerexamen.segundaactividad.segundaactividad.persistence.entities.Usuarios;

import java.util.List;

public interface UsuarioServices {
    public List<Usuarios> getUsuarios();

    public Usuarios getUsuarioByNombre(String nombre);
}
