package com.primerexamen.segundaactividad.segundaactividad.controllers;

import com.primerexamen.segundaactividad.segundaactividad.models.Usuario;
import com.primerexamen.segundaactividad.segundaactividad.services.proveedores.ProveedoresServices;
import com.primerexamen.segundaactividad.segundaactividad.services.usuario.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
            Usuario user = usuarioServicesDAO.getUsuarioByNombre(username);
            System.out.println(user);
            if (user != null && user.getPassword().equals(password)) {
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

}
