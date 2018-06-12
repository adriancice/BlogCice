/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrian.servlet;

import com.adrian.beans.Dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Adrian Stan
 */
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("user");
        String pass = req.getParameter("pass"); 
        
        //la fecha y hora para last_login
        Date date = new Date();
        DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String last_login = fechaHora.format(date);
        
        Dao d = new Dao();
        //encriptamos la pass aqui
        String passSHA = DigestUtils.sha256Hex(pass);
            
            try {            
            //conectamos con la base de datos
            d.conectar();            
            if (d.validarUser(username, passSHA)) {
                
                //si el user y pass son correctas, logueamos; ademas pintamos un sweetAlert 
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script>");
            out.println("$(document).ready(function(){");
            out.println("swal(\"Enhorabuena!\", \"Has iniciado sesion correctamente!\", \"success\")");
            out.println("});");
            out.println("</script>");

            //no creo que hace falta poner un "if" porque si llegamos a este punto el usuario y el pass son correctos
            //en setAttribute he puesto yo un String
            HttpSession sesion = req.getSession();
            sesion.setAttribute("user", "passSHA-512");
            //resp.sendRedirect("backOffice.jsp");
                        
            //guardamos la fecha de login
            d.lastLogin(last_login, username);            
            
            req.getRequestDispatcher("backOffice.jsp").include(req, resp);
                        
            
            d.desconectar();
            }else {
            //si el user y pass no son correctas pintamos un mensaje con sweetAlert
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script>");
            out.println("$(document).ready(function(){");
            out.println("swal ( \"Oops\" ,  \"El usuario o la contrase&ntilde;a no son correctas!\" ,  \"error\" )");
            out.println("});");
            out.println("</script>");
            req.getRequestDispatcher("index.jsp").include(req, resp);
            
            }
            } catch (Exception e) {
            }
            
        
        
    }

}
