/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplechatexample;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author anwar
 */
public class simpleChatexample {
    public static String end="noting";
    public static void main(String[] args){
        
      simpleChatServerSocket t1=new  simpleChatServerSocket(2000); 
     simpleChatClientSocket t2= new simpleChatClientSocket("192.168.0.106",2001);
      t1.start();
       t2.start();
        
    }
}
