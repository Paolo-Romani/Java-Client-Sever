/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_server.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paolo
 */
public class Server extends Thread{
    private ServerSocket server;
    private Clients client;
    private int port = 5555;
    
    public Server(){
        try {
            server = new ServerSocket(port);
            client = new Clients();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Server(int port){
        try {
            this.port = port;
            server = new ServerSocket(port);
            client = new Clients();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void run(){
        boolean stato = true;
        while(stato){
            try {
                System.out.println("Server in attesa di un client");
                client.addClient(server.accept());
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
