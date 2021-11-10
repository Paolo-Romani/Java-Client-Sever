/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_server;

import client_server.Server.Server;

/**
 *
 * @author Paolo
 */
public class Client_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Server s = new Server();
        s.start();
    }
    
}
