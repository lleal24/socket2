/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket2;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author user
 */
public class Servidor {
    
    public static void main(String[] args){
        
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        final int PUERTO = 2019;
        
        try{
            
            servidor = new ServerSocket(PUERTO);
            System.out.print("Servidor iniciado\n");
            
            while(true){
                //esperando cliente socket del cliente
                sc = servidor.accept();
                
                //Comunicacion 
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                
                String mensaje = in.readUTF();
                
                System.out.print(mensaje + "\n");
                
                out.writeUTF("Hola desde el server\n");
                
                sc.close();
                System.out.println("CLiente desconectado\n");
                
                                
                
               
            }
            
            
        } catch (IOException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
