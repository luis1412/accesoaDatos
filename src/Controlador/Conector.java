/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.mysql.cj.jdbc.Driver;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import Modelo.Neumatico;
import Modelo.Perfil;

/**
 *
 * @author Usuario
 */
public class Conector {
    private static final String sDriver = "com.mysql.cj.jdbc.Driver";
    private static final String rURL = "jdbc:mysql://";
    private static final String db_host = "localhost";
    private static final String db_name = "neumaticos";
    private static final String db_user = "root";
    private static final String db_pw = "";
    private static final String sURL = rURL + db_host + "/" + db_name;
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement ps = null;
    
    public boolean conectar() {
        boolean conexionValida = false;
        try {
            conn = DriverManager.getConnection(sURL, db_user, db_pw);
            conexionValida = true;
        } catch (SQLException e) {
            e.printStackTrace();
            conexionValida = false;
        }

        return conexionValida;
    }
    
    public void cerrarConexion(){
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    
    //--------------------------------------- CODIGO ---------------------------------------------------------- //
    
    public void consultaParametrosUsuario(String consultaPreparada, String nombre, String contrasena){
        if (conectar()) {
            try {
                ps = conn.prepareStatement(consultaPreparada);
                ps.setString(1, nombre);
                ps.setString(2, contrasena);
                ps.executeUpdate();
            } catch (SQLException e) {
               e.printStackTrace();
            }
        }
        cerrarConexion();
    }
    
    
    public boolean consultarUsuario(String nombre, String contrasena){
        boolean encontrado = false;
        
        ResultSet rs = null;
        if (conectar()) {
            try {
                ps = conn.prepareStatement("SELECT * FROM USUARIOS WHERE nombre=? AND contrasena=?");
                ps.setString(1, nombre);
                ps.setString(2, contrasena);
                rs = ps.executeQuery();
                if (rs.next()) {
                    encontrado = true;
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        cerrarConexion();
        
        
        return encontrado;
    }
    
    
    public void realizarConsultaParametros(String consultaPreparada, Neumatico neumatico){
        if (conectar()) {
            try {
                ps = conn.prepareStatement(consultaPreparada);
                ps.setString(1, neumatico.getCod());
                ps.setString(2, neumatico.getMarca());
                ps.setString(3, neumatico.getModelo());
                ps.setInt(4, neumatico.getAncho());
                ps.setString(5, neumatico.getPerfil().toString());
                ps.setDouble(6, neumatico.getPrecio());
                ps.executeUpdate();
            } catch (SQLException e) {
               e.printStackTrace();
            }
        }
        cerrarConexion();
    }
    
    public ArrayList<Neumatico> realizarConsultaParametrosNeumatico(String consultaPreparada){
        ArrayList<Neumatico> neumaticosBD = new ArrayList<>();


        if (conectar()) {
                ResultSet rs = null;

            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(consultaPreparada);
                
                while (rs.next()) {
                   neumaticosBD.add(new Neumatico(rs.getString("cod"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("ancho"), rs.getString("perfil"), rs.getDouble("precio")));
                }
                
            } catch (SQLException e) {
               e.printStackTrace();
            }
        }
        cerrarConexion();
        
        return neumaticosBD;
    }
    
    
    
   
    /*
    public ArrayList<Usuario> realizarConsultaLista(String consulta){
        ArrayList<Usuario> usuariosBD = new ArrayList<>();
        ResultSet rs = null;
        if (conectar()) {
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(consulta);
                while (rs.next()) {
                   usuariosBD.add(new Usuario(rs.getString("dni"), rs.getString("nombre"),rs.getString("email")));
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        cerrarConexion();
        
        return usuariosBD;
    }
    */
    
    
}
