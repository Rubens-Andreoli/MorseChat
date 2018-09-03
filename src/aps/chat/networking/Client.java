package aps.chat.networking;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    
    private String ip;
    private int port;
    
    private Socket s;
    private ObjectOutputStream out;
    
    public Client(String ip, int port) {
	this.ip = ip;
	this.port = port;
    }
    
    public Socket connect() {
	try {
	    s = new Socket(ip, port);
	    out = new ObjectOutputStream(s.getOutputStream());
	} catch (IOException ex) {
	    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
	}
	return s;
    }
    
    public void send(Message msg) {
	try {
	    out.writeObject(msg);
	} catch (IOException ex) {
	    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    
}
