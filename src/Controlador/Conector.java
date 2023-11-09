/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Factura;
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
   
    
    public void realizarConsultaParametros(String consultaPreparada, Neumatico neumatico, int[] posicionElementos ){
        if (conectar()) {
            try {
                ps = conn.prepareStatement(consultaPreparada);
                ps.setString(posicionElementos[0], neumatico.getCod());
                ps.setString(posicionElementos[1], neumatico.getMarca());
                ps.setString(posicionElementos[2], neumatico.getModelo());
                ps.setInt(posicionElementos[3], neumatico.getAncho());
                ps.setString(posicionElementos[4], neumatico.getPerfil().toString());
                ps.setDouble(posicionElementos[5], neumatico.getPrecio());
                ps.executeUpdate();
            } catch (SQLException e) {
               e.printStackTrace();
            }
        }
        cerrarConexion();
    }
    
    
    public <T>ArrayList<T> realizarConsultaParametrosNeumatico(String consultaPreparada, T objeto){
        ArrayList<T> listaMostrar = new ArrayList<>();


        if (conectar()) {
                ResultSet rs = null;

            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(consultaPreparada);
                
                while (rs.next()) {
                    if (objeto instanceof Neumatico) {
                        listaMostrar.add((T) new Neumatico(rs.getString("cod"), rs.getString("marca"), rs.getString("modelo"), rs.getInt("ancho"), rs.getString("perfil"), rs.getDouble("precio")));
                    }
                    else if (objeto instanceof Factura) {
                        listaMostrar.add((T) new Factura(rs.getInt("numlinea"), rs.getInt("numfactura"), rs.getInt("codneumatico"), rs.getString("concepto"), rs.getInt("numneumaticos"), rs.getDouble("precio")));
                    }
                }
                
            } catch (SQLException e) {
               e.printStackTrace();
            }
        }
        cerrarConexion();
        
        return listaMostrar;
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
