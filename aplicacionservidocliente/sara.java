/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionservidocliente;

import sara.Servidor;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author FP Mañana A
 */
public class sara extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox v = new VBox(10);
        Label de=new Label("De: ");
        TextField tfde = new TextField("");
        Label mensaje1=new Label("Mensaje: ");
        TextField tfmensaje = new TextField("");
        tfmensaje.setPadding(new Insets(1,1,1,1));
        tfmensaje.setPrefSize(50, 50);
        tfmensaje.setMaxHeight(100);
        Button enviar=new Button("ENVIAR");
        Label label = new Label("");
        
        enviar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                ServerSocket servidor = null;
            Socket sc = null;
            DataInputStream in;
            DataOutputStream out;
        final int PUERTO = 5000;
        try {
            
            
            //puerto de nuestro servidor
            
            
            
            //Creamos el socket del servidor
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");
 
            //Siempre estara escuchando peticiones
            while (true) {
 
                //Espero a que un cliente se conecte
                sc = servidor.accept();
 
                System.out.println("Cliente conectado");
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
 
                //Leo el mensaje que me envia
                String mensaje = in.readUTF();
 
                System.out.println(mensaje);
 
                //Le envio un mensaje
                out.writeUTF("¡Hola mundo desde el servidor!");
 
                //Cierro el socket
                sc.close();
                System.out.println("Cliente desconectado");
 
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
        });
        
        v.getChildren().addAll(de,tfde,mensaje1,tfmensaje,enviar,label);
        Scene sc=new Scene(v,300,300);
        stage.setScene(sc);
        stage.show();
    }
    
}
