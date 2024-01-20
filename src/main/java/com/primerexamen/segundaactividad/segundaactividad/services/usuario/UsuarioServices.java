package com.primerexamen.segundaactividad.segundaactividad.services.usuario;

import com.primerexamen.segundaactividad.segundaactividad.models.Usuario;

import java.util.List;

public interface UsuarioServices {
    public List<Usuario> getUsuarios();

    public Usuario getUsuarioByNombre(String nombre);
}
