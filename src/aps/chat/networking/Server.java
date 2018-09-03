package aps.chat.networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server implements Runnable{

    public static final String SERVER_ID = "S.E.R.V.E.R";
    
    private int port;
    private ServerSocket ss;
    private Socket s;
    private List<ObjectOutputStream> clients;
    private boolean running;
    
    public Server(int port){
	clients = new ArrayList<>();
	this.port = port;
    }
    
    public void connect() throws IOException {
	ss = new ServerSocket(port);
    }

    @Override
    public void run() {
	running = true;
	try {
	    while(running && (s = ss.accept()) != null){
		new Thread(new ClientListener(s)).start();
	    }
	} catch (IOException ex) {
	    //ERRO: Não foi possível aceitar conexão do cliente.
	}
    }
    
    public void stop() {
	if(!running) return;
	running = false;
	try {
	    send(new Message(SERVER_ID, "Servidor desconectado."));
	    ss.close();
	    clients.clear();
	} catch (IOException ex) {
	    //ERRO: ServerSocket não pode ser fechado.
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

    public boolean isRunning() {
	return running;
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
		    }else send(msg);
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
