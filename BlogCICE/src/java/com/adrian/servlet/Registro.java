/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrian.servlet;

import com.adrian.beans.Dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Adrian Stan
 */
public class Registro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        PrintWriter out = resp.getWriter();
        
        //declaramos las variables
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");        
        String nombreUsuario = req.getParameter("nombreUsuario");        
        String password = req.getParameter("password");
        String repeatPass = req.getParameter("repeatPassword");
        String email = req.getParameter("correo");      
        
        
        Dao d = new Dao();
        
        //comprobamos si las contraseñas coinciden
        if(password.equals(repeatPass)){
            try {
                
                d.conectar();
                //comprobamos si el nombre de usuario esta registrado
                if (d.isAcountExists(nombreUsuario)) {
                    //si el usuario existe se pinta un sweetAlert con js
                    out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                    out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                    out.println("<script>");
                    out.println("$(document).ready(function(){");
                    out.println("swal ( \"Oops\" ,  \"El usuario ya existe!\" ,  \"error\" )");
                    out.println("});");
                    out.println("</script>");
                    
                    req.getRequestDispatcher("registro.jsp").include(req, resp);                                     
                    
                }else{
                    //si el usuario no esta existe en la bd lo creamos
                    //encriptamos la pass aqui para que no la encripte sino coinciden
                    String passSHA = DigestUtils.sha256Hex(password);
                    
                    d.registerUser(nombre, apellido, nombreUsuario, passSHA, email);                    
                    out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                    out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                    out.println("<script>");
                    out.println("$(document).ready(function(){");
                    out.println("swal(\"Enhorabuena!\", \"Te has registrado correctamente!\", \"success\")");
                    out.println("});");
                    out.println("</script>");
                                        
                    req.getRequestDispatcher("index.jsp").include(req, resp);
                    
                    d.desconectar();                    
                }
            } catch (SQLException e) {
                out.println("Ocurrio el siguiente error: " + e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else {            
                //si las contraseñas no coinciden se pinta un sweetAlert con js
                out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal ( \"Oops\" ,  \"Las contrase&ntilde;as no coinciden!\" ,  \"error\" )");
                out.println("});");
                out.println("</script>");
                
                req.getRequestDispatcher("registro.jsp").include(req, resp);
                
        }

    }
        
}