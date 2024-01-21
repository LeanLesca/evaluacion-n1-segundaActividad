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
        return "crearProveedor";
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
            System.out.println(user);
            if (user != null && user.getPasswordUsuario().equals(password)) {
                // Autenticación exitosa
                return "redirect:/listadoProveedores";
            } else {
                // Autenticación falla
                model.addAttribute("mensaje_error", "usuario no existe o contraseña incorrectos");
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
        proveedoresServicesDAO.guardar(proveedor);
        return "redirect:/listadoProveedores";
    }

    @GetMapping("/editar/{idProveedor}")
    public String editar(@PathVariable int idProveedor , Model model){
        System.out.println(idProveedor);
        Proveedores proveedor = proveedoresServicesDAO.encontrarProveedorPorID(idProveedor);
        if(proveedor != null){
            model.addAttribute("proveedor", proveedor);
            model.addAttribute("editar", true);
            return "crearProveedor";
        } else {
            return "redirect:/listadoProveedores";
        }
    }

}
