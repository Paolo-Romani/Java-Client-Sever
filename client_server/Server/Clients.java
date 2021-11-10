/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_server.Server;

import java.net.Socket;
import java.util.Vector;

/**
 *
 * @author Paolo
 */
public class Clients{
    private Socket client;
    private Vector<Client> listaClient;
    
    public Clients(){
        listaClient = new Vector<Client>();
    }
    
    public boolean addClient(Socket client) {
        return listaClient.add(new Client(client));
    }

    public Vector<Client> getListaClient() {
        return listaClient;
    }

    public boolean delClient(Socket client){
        return listaClient.removeElement(client);
    }

}
