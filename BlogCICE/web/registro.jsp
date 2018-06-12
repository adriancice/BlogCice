<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <script src="js/funciones.js" type="text/javascript"></script>

    <title>Registrate</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
    <link rel="icon" href="img/favicon.png">


  </head>

  <body>
      <div class="container">
      <h2>Introduce tus datos</h2>
      <br><br>
      <form class="form-horizontal" action="Registro" method="post">
          <div class="form-group">              
              <label for="exampleInputName2" class="col-sm-2 control-label">Nombre</label>
              <div class="col-sm-4">
                  <input type="text" class="form-control" name="nombre" placeholder="Batman">
              </div>
          </div>
          <div class="form-group">              
              <label for="exampleInputName2" class="col-sm-2 control-label">Apellido</label>
              <div class="col-sm-4">
                  <input type="text" class="form-control" name="apellido" placeholder="Robin">
              </div>
          </div>   
          <div class="form-group">              
              <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
              <div class="col-sm-4">
                  <input type="email" class="form-control" name="correo" placeholder="batman.robin@gmail.com">
              </div>
          </div> 
          <div class="form-group">              
              <label for="exampleInputName2" class="col-sm-2 control-label">Nombre de usuario</label>
              <div class="col-sm-4">
                  <input type="text" class="form-control" name="nombreUsuario" placeholder="batman" required maxlength="30">
              </div>
          </div>
          <div class="form-group">
              <label for="inputPassword3" class="col-sm-2 control-label">Contrase&ntildea </label>
              <div class="col-sm-4">
                  <input type="password" class="form-control" name="password" placeholder="Password" required>
              </div>
          </div>
          <div class="form-group">
              <label for="inputPassword3" class="col-sm-2 control-label">Repite contrase&ntildea </label>
              <div class="col-sm-4">
                  <input type="password" class="form-control" name="repeatPassword" placeholder="Repeat password" required>
              </div>
          </div>
          <div class="form-group">
              <div class="col-sm-offset-3 col-sm-10">
                  <button  class="btn btn-default" type="submit">Create account</button>
              </div>
          </div>
      </form>
      
      
      <a href="index.jsp" class="btn btn-warning" role="button">Go home</a>

</div>
  </body>
</html>
