package com.adrian.beans;

import com.adrian.dto.Entradas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import jdk.nashorn.internal.objects.NativeString;


/**
 * Esta clase se encarga de la conexion con la DB
 * @author Adrian Stan
 */
public class Dao {
    
    public Connection conexion;
    public PreparedStatement ps;
    public Statement st; 
    public ResultSet rs;
    public final static String userDb = "root";
    public final static String passDb = "root";
    
    
    //Conectar a la Base de datos
    public void conectar() throws SQLException,ClassNotFoundException{
         Class.forName("com.mysql.jdbc.Driver");
         conexion = DriverManager.getConnection("jdbc:mysql://localhost:8889/blog_cice",userDb, passDb);
    }
    //Desconectar a la Base de datos
    public void desconectar() throws SQLException, ClassNotFoundException{
        conexion.close();
        ps.close();
    }

    
    //Metodo para consultar si un usuario pertenece a la DB
    public boolean isAcountExists(String nombreUsuario) throws SQLException{
        String sql = "SELECT * FROM usuarios WHERE username='"+nombreUsuario+"'";
        ps = conexion.prepareStatement(sql);
        rs = ps.executeQuery();
        
        return rs.next();
    }
    
    //Metodo para consultar si el email recibido ya esta registrado
    public boolean isEmailRegistered(String email) throws SQLException{
        String sql = "SELECT * FROM usuarios WHERE email='"+email+"'";
        ps = conexion.prepareStatement(sql);
        rs = ps.executeQuery();
 
        return rs.next();
    }
    
    //Metodo para registrar una cuenta
    public void registerUser(String nombre, String apellido, String nombreUsuario, String password, String email) throws SQLException{
        String sql = "INSERT INTO `usuarios`(`name`,`surname`,`username`,`password`,`email` ) VALUES ('"+nombre+"','"+apellido+"','"+nombreUsuario+"','"+password+"','"+email+"')";
        ps = conexion.prepareStatement(sql);
        ps.executeUpdate();
    }
    
    //metodo para verificar login
    public boolean validarUser(String user, String pass) throws SQLException{
        String sql = "SELECT username, password FROM usuarios WHERE username=? and password=?";
        ps = conexion.prepareStatement(sql);
        ps.setString(1, user);
        ps.setString(2, pass);
        rs = ps.executeQuery();
        
        return rs.next();
    }
    
    //metodo para crear entradas
    public void crearEntrada(String titulo, String subtitulo, String cuerpo) throws SQLException{
        String sql = "INSERT INTO entradas (titulo, subtitulo, cuerpo, usuarios_id_usuarios) VALUES (?,?,?,?)";      
        ps = conexion.prepareStatement(sql);
        ps.setString(1, titulo);
        ps.setString(2, subtitulo);
        ps.setString(3, cuerpo);
        ps.setInt(4, 1);
        ps.execute();
    }
    
    //metodo para añadir la fecha y hora de login
    public void lastLogin(String last_login, String username) throws SQLException {
        String sql = "UPDATE usuarios SET last_login = now() WHERE username = '"+username+"' ";
        ps = conexion.prepareStatement(sql);
        ps.executeUpdate();
    }
    
    //metodo para extraer de la base de datos de entradas
    public LinkedList<Entradas> getEntradas() throws SQLException {
        LinkedList<Entradas> listaEntradas = new LinkedList<Entradas>();
        String sql = "SELECT * FROM entradas";
        st = conexion.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {            
            Entradas entrada = new Entradas();
            entrada.setId(rs.getInt("id_entradas"));
            entrada.setTitulo(rs.getString("titulo"));
            entrada.setSubtitulo(rs.getString("subtitulo"));
            entrada.setTexto(rs.getString("cuerpo"));
            entrada.setDate(rs.getString("create_date"));
            listaEntradas.add(entrada);
        }
        rs.close();
        st.close();
        conexion.close(); 
        
        return listaEntradas;
    }
   
}
