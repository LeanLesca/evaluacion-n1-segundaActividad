package com.primerexamen.segundaactividad.segundaactividad.services.proveedores;

import com.primerexamen.segundaactividad.segundaactividad.models.Proveedores;
import com.primerexamen.segundaactividad.segundaactividad.models.Usuario;
import com.primerexamen.segundaactividad.segundaactividad.repository.DAOProveedores;
import com.primerexamen.segundaactividad.segundaactividad.repository.DAOUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProveedoresServicesImpl implements ProveedoresServices {

    @Autowired
    public DAOProveedores interfazDatoProveedores;

    @Override
    @Transactional(readOnly = true)
    public List<Proveedores> getProveedores() {
        return (List<Proveedores>) interfazDatoProveedores.findAll();
    }

}
