/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_server.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paolo
 */
public class Client extends Thread{
    private Socket server = null;
    private BufferedReader in = null;
    private PrintStream out = null;
    private static String ip = "localhost";
    private static int port = 5555;
    
    
    public Client(Socket server){
        this.server = server;
        try{
            in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            out = new PrintStream(server.getOutputStream(), true);
        }catch(Exception e1){
            try { server.close(); 
            }catch(Exception e) { System.out.println(e.getMessage());}
        }
    }
    
    public void run(){
        boolean stato = true;
        Scanner sc = new Scanner(System.in);
        String sms;
        do{
            try {
                System.out.println("Messaggio da inviare");
                sms = sc.next();
                out.println(sms);
                out.flush();
                if(sms.equalsIgnoreCase("exit")){
                    stato = false;
                }else
                    System.out.println("Server: "+in.readLine());
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while(stato);
        try {
            out.close();
            in.close();
            server.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args){
        try {
            Client client = new Client(new Socket(ip,port));
            System.out.println("Connesso al sever "+client);
            client.start();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
