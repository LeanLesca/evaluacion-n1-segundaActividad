package com.primerexamen.segundaactividad.segundaactividad.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProveedor;

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
