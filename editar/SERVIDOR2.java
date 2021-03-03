/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editar;

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
public class SERVIDOR2 extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox v=new VBox(20);
        Label titulo=new Label();
        TextField texto=new TextField();
        Button btn=new Button("Enviar");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                String texto_obtenido=texto.getText();
                ServerSocket servidor = null;
            Socket sc = null;
            DataInputStream in;
            DataOutputStream out;
        final int PUERTO = 5000;
        try {
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
                out.writeUTF(texto_obtenido);
 
                //Cierro el socket
                sc.close();
                System.out.println("Cliente desconectado");
 
            }
        } catch (IOException ex) {
            Logger.getLogger(SERVIDOR2.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
        });
        v.getChildren().addAll(titulo,texto,btn);
        Scene sc=new Scene(v,300,300);
        stage.setScene(sc);
        stage.show();
    }
    
    
}
