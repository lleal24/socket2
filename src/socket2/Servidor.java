/*
 *El lado del cliente inicia esperando una conexion del cliente
 *Espera conexion y mensaje del cliente para enviar una respuesta.
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
        float resultado = 0;
        float numero1 = 0;
        float numero2 = 0;
        
        try{
            
            servidor = new ServerSocket(PUERTO);
            System.out.print("Servidor iniciado\n");
            
            while(true){
                //esperando una conexion con el cliente cliente socket del cliente
                sc = servidor.accept();
                
                //Comunicacion datos de entrada y salida
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                
                //mensaje = cadena que envia el cliente con operacion
                String mensaje = in.readUTF();
                
                //se crea un array con la variable mensaje y se divide por espacio
                // la posicion[0]=operacion
                //    posicion[1]=numero1
                //    posicion[2]=numero2
                String linea [] = mensaje.split(" ");            
                numero1 = Float.valueOf(linea[1]);
                numero2 = Float.valueOf(linea[2]);
                
                //switch case que opera segun el caso
                switch (linea[0]){
                    case "suma":
                        resultado = numero1 + numero2;
                        break;
                    case "resta":
                        resultado = numero1 - numero2;
                        break;
                    case "multiplica":
                        resultado = numero1 * numero2;
                        break;
                    case "divide":
                        resultado = numero1 / numero2;
                        break;
                }
                
                
                //se imprime el mensaje enviado para el cliente
                System.out.print("Operacion envidada por el cliente: "+mensaje + "\n");
                
                
                // se envia mensaje al cliente con el resultado
                out.writeUTF("Respuesta del server a operacion: " +resultado);
                
                sc.close();
                System.out.println("Cliente desconectado\n");
                
                                              
            }
            
            
        } catch (IOException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
