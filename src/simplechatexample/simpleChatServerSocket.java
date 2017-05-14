/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplechatexample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static simplechatexample.simpleChatexample.end;

/**
 *
 * @author anwar
 */
public class simpleChatServerSocket extends Thread{
    Socket client=null;
    ServerSocket server=null;
    
    public simpleChatServerSocket(int port){
        try { 
             
            server=new ServerSocket(port);
           
        } catch (IOException ex) {
            Logger.getLogger(simpleChatServerSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    @Override
    public void run() {
        
       
        try {
             client=server.accept();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            client.getInputStream()));
            String input;
         // new ChatClientSocket("192.168.0.104",2000).start();
            while(true){
                input=in.readLine();
                System. out.println("chatServer1 : "+input);
                 if(input.equalsIgnoreCase("exit") || end.equalsIgnoreCase("exit"))
                 {
                     
                     end="exit";
                     break;
                 }
            }
            in.close();
            client.close();
            server.close();
              System.out.println("close");
        } catch (IOException ex) {
            Logger.getLogger(simpleChatServerSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
}
