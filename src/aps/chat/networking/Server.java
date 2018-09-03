package aps.chat.networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server implements Runnable{

    public static final String SERVER_ID = "SERVER";
    
    private final int port;
    private ServerSocket ss;
    private Socket s;
    private List<ObjectOutputStream> clients;
    
    public Server(int port){
	this.port = port;
	clients = new ArrayList<>();
    }

    @Override
    public void run() {
	try {
	    ss = new ServerSocket(port);  
	    while((s = ss.accept()) != null){
		new Thread(new ClientListener(s)).start();
	    }
	} catch (IOException ex) {
	    //ERRO: ServerSocket não inicializado.
	}
    }
    
    private void send(Message msg) {
	for(ObjectOutputStream out : clients) {
	    try {
		 out.writeObject(msg);
	    } catch (IOException ex) {
		//ERRO: Menssagem não pode ser enviada para algum(ns) clientes.
	    }
	}
    }
    
    private class ClientListener implements Runnable{

	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	public ClientListener(Socket s) {
	    try {
		out = new ObjectOutputStream(s.getOutputStream());
		in = new ObjectInputStream(s.getInputStream());
	    } catch (IOException ex) {
		//ERRO: Input/OutputStream não inicializada(s).
	    }
	}
	
	@Override
	public void run() {
	    Message msg;
	    try {
		while ((msg = (Message)in.readObject()) != null){
		    if(msg.getText() == null) {
			if(!clients.contains(out)){
			    clients.add(out);
			    send(new Message(SERVER_ID, msg.getUser()+" entrou na sala."));
			}else{
			    clients.remove(out);
			    send(new Message(SERVER_ID, msg.getUser()+" saiu da sala."));
			} 
		    }else{
			send(msg);
		    }
		}
	    } catch (IOException ex) {
		//ERRO: Não foi possível accessar a input stream do cliente.
		clients.remove(out);
	    } catch (ClassNotFoundException ex) {
		//ERRO: Falha ao converter o objeto recebido.
	    }
	}
    }
    
}
