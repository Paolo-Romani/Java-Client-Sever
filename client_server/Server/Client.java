/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_server.Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Paolo
 */
public class Client extends Thread{
    private Socket client = null;
    private BufferedReader in = null;
    private PrintStream out = null;
    private String messaggio;
    
    public Client(){}
    public Client(Socket clientSocket){
        client = clientSocket;
        try{
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintStream(client.getOutputStream(), true);
            this.start();
        }catch(Exception e1){
            try { client.close(); 
            }catch(Exception e) { System.out.println(e.getMessage());}
        }
        
    }
    
    public void run(){   
        try{
            System.out.println("Client connessio: "+client);
            do{
                messaggio = in.readLine();
                out.println("ok");
                out.flush();
                if(messaggio.equalsIgnoreCase("esci")){
                    System.out.println("Discossione client "+client.getLocalAddress());
                    out.println("chiudo comunicazione");
                    break;
                }else{
                    System.out.println("Messaggio dal client "+client.getLocalAddress()+" - "+ messaggio);
                } 
            }while(true);
            // chiude gli stream e la connessioni
            out.close();
            in.close();
            client.close();
        }catch(Exception e) {}
    }    
}
