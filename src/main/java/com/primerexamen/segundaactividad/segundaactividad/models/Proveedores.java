package com.primerexamen.segundaactividad.segundaactividad.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Proveedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoProveedor;

    private String nombre;
    private int telefono;
    private String direccion;
    private String email;
    private String sitioWeb;
    private int estado;

    public String manejoEstados(int num) {
        switch (num){
            case 1:
                return "Activo";
            case 2:
                return "Inactivo";
            case 3:
                return "Dado de baja";
            default:
                return null;
        }
    }
}
