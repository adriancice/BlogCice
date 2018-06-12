<%@page import="sun.security.x509.RDN"%>
<%
String idUsuario = (String)session.getAttribute("user");
if(idUsuario == null){
    response.sendRedirect("registro.jsp");
}
session.removeAttribute("user");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <script src="js/funciones.js" type="text/javascript"></script>

    <title>Blog CICE con Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
    <link rel="icon" href="img/favicon.png">
    </head>
    <body>
        
        <div class="container">
            <h2>Introduce los datos de la entrada</h2>
            <br><br>
            <form class="form-horizontal" action="CrearEntrada" method="post">
          <div class="form-group">              
              <label for="exampleInputName2" class="col-sm-2 control-label">Titulo</label>
              <div class="col-sm-4">
                  <input type="text" class="form-control" name="titulo" placeholder="introduce el titulo" maxlength="120">
              </div>
          </div>
          <div class="form-group">              
              <label for="exampleInputName2" class="col-sm-2 control-label">Subtitulo</label>
              <div class="col-sm-4">
                  <input type="text" class="form-control" name="subtitulo" placeholder="introduce el subtitulo" maxlength="120">
              </div>
          </div>   
          <div class="form-group">              
              <label for="inputEmail3" class="col-sm-2 control-label">Texto</label>
              <div class="col-sm-4">
                  <textarea class="form-control" name="cuerpo" rows="4" placeholder="introduce algo de texto"></textarea>
              </div>
          </div> 
          <div class="form-group">
              <div class="col-sm-offset-3 col-sm-10">
                  <button  class="btn btn-default" type="submit">Enviar</button>
              </div>
              <a href="index.jsp" class="btn btn-warning" role="button">Go home</a>
          </div>
      </form>
        </div>
        
        
    </body>
</html>
