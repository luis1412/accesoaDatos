/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.naming.Context;

/**
 *
 * @author Usuario
 */
public class ComprobacionesGenerales {

    public static String comprobarCamposVacios(String codigo, String marca, String modelo, String ancho, String perfil, String precio) {
        String mensaje = "";
        if (codigo.isEmpty()) {
            mensaje = "El codigo no puede estar vacio";
        } else if (marca.isEmpty()) {
            mensaje = "La marca no puede estar vacia";
        } else if (modelo.isEmpty()) {
            mensaje = "El modelo no puede estar vacio";
        } else if (mensaje.equals("")) {
            try {
                Double.parseDouble(precio);
                Integer.parseInt(ancho);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                mensaje = "tienes que introducir numero validos no puedes introducir letras solo numeros";
            }
        } else {
            mensaje = "";
        }

        return mensaje;
    }

}
