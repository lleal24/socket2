/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Cliente {
    
    public static void main(String[] args) throws IOException{
        
        //LOCALHOST
        final String HOST="127.0.0.1";
        final int PUERTO = 2019;
        DataInputStream in;
        DataOutputStream out;
        
        
        
        try{
            
            Socket sc = new Socket(HOST, PUERTO);
            
            //Comunicacion 
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            
            //mandar un mensaje
            out.writeUTF("Hola desde el cliente\n");
            
            String mensaje = in.readUTF();
            System.out.println(mensaje);
            
            sc.close();
            
            
        } catch (IOException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}