/*
 * El cliente se conecta con el servidor envia peticion y recibe respuesta
 * a esta peticion;
 */
package socket2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Cliente {
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
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
            //out.writeUTF("Hola desde el cliente\n");
            System.out.print("\n Opciones de ingreso: suma|resta|divide|multiplica numero1 numero2\n Ejm:  multiplica 1 2\n");
            System.out.print("\n Ingrese su operacion:");
            String enviar = entrada.readLine();
            out.writeUTF(enviar);
            
            
            //Guardar mensaje del cliente e imprimirlo
            String mensaje = in.readUTF();
            System.out.println(mensaje);
            
            sc.close();
            
            
        } catch (IOException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
