package com.primerexamen.segundaactividad.segundaactividad.services.proveedores;

import com.primerexamen.segundaactividad.segundaactividad.persistence.entities.Proveedores;

import java.util.List;

public interface ProveedoresServices {
    public List<Proveedores> getProveedores();
    public void guardar(Proveedores proveedor);

    public Proveedores encontrarProveedor(Proveedores proveedor);

    public Proveedores encontrarProveedorPorID(int id);
}
