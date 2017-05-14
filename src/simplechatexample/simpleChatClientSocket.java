/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplechatexample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import static simplechatexample.simpleChatexample.end;
import sun.net.www.content.text.plain;

/**
 *
 * @author anwar
 */
public class simpleChatClientSocket extends Thread {
    PrintStream  outt;
    BufferedReader in;
     Socket client=null;
     String ip=null;
     int port=0;
     public simpleChatClientSocket(String ip,int port) {
         this.ip=ip;
         this.port=port;
         
     }

    @Override
    public void run() {
         try {
             while(client==null){
                 try{
                     client=new Socket(this.ip,this.port);
                 }
                 catch(Exception e){
                     
                 }
             }
              outt = new PrintStream(client.getOutputStream());
             in=new BufferedReader(new InputStreamReader(System.in));
             String input;
             while(true){
                 input=in.readLine();
                 outt.println(input);
                 System.out.println("ChatClient1 :"+input);
                  if(input.equalsIgnoreCase("exit")|| end.equalsIgnoreCase("exit") )
                 {
                     end="exit";
                     break;
                 }
             } 
             client.close();
             outt.close();
             in.close();
             System.out.println("close");
         } catch (IOException ex) {
             Logger.getLogger(simpleChatClientSocket.class.getName()).log(Level.SEVERE, null, ex);
         }  
    }
     
}
