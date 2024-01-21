package com.primerexamen.segundaactividad.segundaactividad.services.proveedores;

import com.primerexamen.segundaactividad.segundaactividad.persistence.entities.Proveedores;
import com.primerexamen.segundaactividad.segundaactividad.persistence.repository.DAOProveedores;
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

    @Override
    @Transactional
    public void guardar(Proveedores proveedor) {
        interfazDatoProveedores.save(proveedor);
    }

    @Override
    @Transactional(readOnly = true)
    public Proveedores encontrarProveedor(Proveedores proveedor) {
        return interfazDatoProveedores.findById(proveedor.getIdProveedor()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Proveedores encontrarProveedorPorID(int id) {
        return interfazDatoProveedores.findById(id).orElse(null);
    }

    @Override
    public void eliminaProveedor(Proveedores proveedor) {
        interfazDatoProveedores.delete(proveedor);
    }
}
