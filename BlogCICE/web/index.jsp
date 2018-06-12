<%-- 
    Document   : index
    Created on : 12-jun-2018, 13:49:09
    Author     : Adrian Stan
--%>
<!-- Los import -->
<%@page import="com.adrian.dto.Entradas" %>
<%@page import="com.adrian.beans.Dao" %>
<%@page import="java.util.LinkedList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina WEB de Adrian</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="img/favicon.png">
        
        
    </head>
    
    <body>
        
        
        <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Blog CICE</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            
            <form class="navbar-form navbar-right" action="Login" method="POST">
            <div class="form-group">
                <input type="text" name="user" placeholder="Username" class="form-control">
            </div>
            <div class="form-group">
                <input type="password" name="pass" placeholder="Password" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">Login</button>
            <a href="registro.jsp" class="btn btn-default">Create account</a>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>Bienvenido al blog de CICE </h1>
        <p>This is a template for a simple marketing or informational website. 
            It includes a large callout called a jumbotron and three supporting pieces of content. 
            Use it as a starting point to create something more unique.</p>
      </div>
    </div>

    <div class="container">
        <h4><small>RECENT POSTS</small></h4>
        <hr>
        
        <h2>I Love Food</h2>
        <h5><span class="glyphicon glyphicon-star"></span> Post by Jane Dane, Sep 27, 2015.</h5>
        <h5><span class="label label-danger">Food</span> <span class="label label-primary">Ipsum</span></h5><br>
        <p>Food is my passion. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
        <br><br>
        
        
        
        
        <%  
            Dao d = new Dao();
            d.conectar();
            LinkedList<Entradas> lista = d.getEntradas();
            for (int i = lista.size()-1; i > 0; i--) {
                
                out.println("<h2>" + lista.get(i).getTitulo()+ "</h2>");
                out.println("<h5>"+"Entrada agregada en: "+lista.get(i).getDate()+"</h5>");
                out.println("<h4>" + lista.get(i).getSubtitulo()+ "</h4>");
                out.println("<p>" + lista.get(i).getTexto()+ "</p>");
                out.println("<hr><br><br>");
                                
                
            }
        %>
        
        
    </div>  
    
    
    </body>
</html>
