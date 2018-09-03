package aps.chat.networking;

import static aps.chat.networking.Server.SERVER_ID;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    
    private final String username;
    private final String ip;
    private final int port;
    
    private Screen screen;
    
    private Socket s;
    private ObjectOutputStream out;
    
    public Client(String username, String ip, int port) {
	this.username = username;
	this.ip = ip;
	this.port = port;
    }
    
    public void connect(Screen screen) throws IOException {
	s = new Socket(ip, port);
	out = new ObjectOutputStream(s.getOutputStream());
	this.screen = screen;
	new Thread(new ServerListener(s)).start();
	send(null);
    }
    
    public void disconnect() {
	try {
	    send(null);
	    s.close();
	} catch (IOException ex) {
	     //ERRO: Não foi possível fechar o socket, ou enviar a menssagem.
	}
    }

    public void send(String text) throws IOException {
	Message msg = new Message(username, text);
	if(msg.isMorse()) msg.decode();
	else msg.encode();
	out.writeObject(msg);
    }

    public String getUsername() {
	return username;
    }
    
    private class ServerListener implements Runnable {

	private ObjectInputStream in;
	
	public ServerListener(Socket s){
	    try {
		in = new ObjectInputStream(s.getInputStream());
	    } catch (IOException ex) {
		//ERRO: InputStream não inicializada.
	    }
	}
	
	@Override
	public void run() {
	    Message msg;
	    try {
		while((msg = (Message)in.readObject()) != null) {
		    if(msg.getUser().equals(SERVER_ID)) screen.printInfo(msg);
		    else screen.printMessage(msg);
		}
	    } catch (IOException ex) {
		//ERRO: Não foi possível accessar a input stream do servidor.
	    } catch (ClassNotFoundException ex) {
		//ERRO: Falha ao converter o objeto recebido.
	    }
	}
    }

}
