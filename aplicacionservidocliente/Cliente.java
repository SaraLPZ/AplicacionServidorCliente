/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionservidocliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.Socket;



/**
 *
 * @author FP Mañana A
 */
public class Cliente {
    public static void main(String[] args) {
        
            final String HOST = "192.168.56.1";
            final int PUERTO = 5000;
            DataInputStream in;
            DataOutputStream out;
        try {
            //Creo el socket para conectarme con el cliente
            Socket sc = new Socket(HOST, PUERTO);
 
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
 
            out.writeUTF("¡Hola mundo servidor como estas");
 
            String mensaje = in.readUTF();
 
            System.out.println(mensaje);
 
            sc.close();
            
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 
        
 
    }
}
