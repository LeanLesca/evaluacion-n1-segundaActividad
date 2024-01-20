package com.primerexamen.segundaactividad.segundaactividad.services.usuario;

import com.primerexamen.segundaactividad.segundaactividad.models.Usuario;
import com.primerexamen.segundaactividad.segundaactividad.repository.DAOUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServicesImpl implements UsuarioServices{

    @Autowired
    public DAOUsuarios interfazDatoUsuarios;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios() {
        return (List<Usuario>) interfazDatoUsuarios.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioByNombre(String nombre) {
        return interfazDatoUsuarios.findByNombre(nombre);
    }
}
