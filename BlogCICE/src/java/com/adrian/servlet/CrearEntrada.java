package com.adrian.servlet;

import com.adrian.beans.Dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adrian Stan
 */
public class CrearEntrada extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        PrintWriter out = resp.getWriter();
        String titulo = req.getParameter("titulo");
        String subtitulo = req.getParameter("subtitulo");
        String cuerpo = req.getParameter("cuerpo");
        Dao d = new Dao();
            
        try {            
            d.conectar();
            d.crearEntrada(titulo, subtitulo, cuerpo);
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script>");
            out.println("$(document).ready(function(){");
            out.println("swal(\"Enhorabuena!\", \"Has a&ntilde;adido una entrada!\", \"success\")");
            out.println("});");
            out.println("</script>");
            
            req.getRequestDispatcher("index.jsp").include(req, resp);
            
            d.desconectar();
        } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(CrearEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    
    
}
