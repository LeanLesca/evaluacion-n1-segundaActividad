package com.primerexamen.segundaactividad.segundaactividad.controllers;

import com.primerexamen.segundaactividad.segundaactividad.persistence.entities.Proveedores;
import com.primerexamen.segundaactividad.segundaactividad.persistence.entities.Usuarios;
import com.primerexamen.segundaactividad.segundaactividad.services.proveedores.ProveedoresServices;
import com.primerexamen.segundaactividad.segundaactividad.services.usuario.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador {

    @Autowired
    ProveedoresServices proveedoresServicesDAO;

    @Autowired
    UsuarioServices usuarioServicesDAO;

    @Value("${tituloTabla}")
    private String tituloTabla;

    @GetMapping("/login")
    public String login() {
        return "index";
    }

    @GetMapping("/guardar")
    public String crearProveedor(Model model) {
        model.addAttribute("proveedor", new Proveedores());
        return "crearEditarProveedor";
    }

    @GetMapping("/listadoProveedores")
    public String listadoProveedores(Model model) {
        var listaProveedores = proveedoresServicesDAO.getProveedores();
        model.addAttribute("tituloTabla", tituloTabla);
        model.addAttribute("listaProveedores",
                listaProveedores);
        return "listadoProveedores";
    }
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password, Model model){
        try{
            Usuarios user = usuarioServicesDAO.getUsuarioByNombre(username);
            if (user != null && user.getPasswordUsuario().equals(password)) {
                // Autenticación exitosa
                return "redirect:/listadoProveedores";
            } else {
                // Autenticación falla
                model.addAttribute("mensaje_error", "usuario no existe o contraseña incorrectos, intente nuevamente");
                return "index";
            }
        } catch (DataAccessException e){
            model.addAttribute("mensaje_error", "Error al acceder a los datos");
            e.printStackTrace();
            return "index";
        }
    }

    @PostMapping("/guardar")
    public String guardar(Proveedores proveedor){
        System.out.println("id : " + proveedor.getIdProveedor());
        proveedoresServicesDAO.guardar(proveedor);
        return "redirect:/listadoProveedores";
    }

    @GetMapping("/editar/{idProveedor}")
    public String editar(@PathVariable int idProveedor , Model model){
        Proveedores proveedor = proveedoresServicesDAO.encontrarProveedorPorID(idProveedor);
        if(proveedor != null){
            model.addAttribute("proveedor", proveedor);
            model.addAttribute("editar", true);
            return "crearEditarProveedor";
        } else {
            return "redirect:/listadoProveedores";
        }
    }

    @GetMapping("/eliminar/{idProveedor}")
    public String eliminarProveedor(Proveedores proveedor) {
        Proveedores proveedorEliminar = proveedoresServicesDAO.encontrarProveedorPorID(proveedor.getIdProveedor());
        proveedoresServicesDAO.eliminaProveedor(proveedorEliminar);

        return "redirect:/listadoProveedores";
    }
}
