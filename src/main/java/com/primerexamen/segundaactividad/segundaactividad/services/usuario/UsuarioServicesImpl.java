package com.primerexamen.segundaactividad.segundaactividad.services.usuario;

import com.primerexamen.segundaactividad.segundaactividad.persistence.entities.Usuarios;
import com.primerexamen.segundaactividad.segundaactividad.persistence.repository.DAOUsuarios;
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
    public List<Usuarios> getUsuarios() {
        return (List<Usuarios>) interfazDatoUsuarios.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios getUsuarioByNombre(String nombre) {
        return interfazDatoUsuarios.findByNombre(nombre);
    }
}
