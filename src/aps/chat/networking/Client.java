package aps.chat.networking;

import static aps.chat.networking.Server.SERVER_ID;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Track;

public class Client {
    
    private final String ip;
    private final int port;
    private final String username;
    private Screen screen;
    private Socket s;
    private ObjectOutputStream out;
    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;
    private volatile boolean running;
    
    public Client(String username, String ip, int port) {
	this.username = username;
	this.ip = ip;
	this.port = port;
    }
    public void connect() throws IOException {
	s = new Socket(ip, port);
	out = new ObjectOutputStream(s.getOutputStream());
	send(null);
    }
    public void run(Screen screen){
	this.screen = screen;
	running = true;
	new Thread(new ServerListener(s)).start();
    } 
    public void disconnect() {
	if(!running) return;
	running = false;
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
    public void startSound() throws MidiUnavailableException, InvalidMidiDataException {
	sequencer = MidiSystem.getSequencer();
	sequencer.open();
	sequence = new Sequence(Sequence.PPQ, 4);
    }   
    public void resetSound() {
	if(sequencer == null) return;
	sequencer.stop();
	sequencer.setTickPosition(0);
	sequencer.setTempoInBPM(240);
	sequence.deleteTrack(track);
	track = sequence.createTrack();
    }   
    public void playSound() throws InvalidMidiDataException {
	if(sequencer == null || sequence == null) return;
	sequencer.setSequence(sequence);
	sequencer.start();
    }   
    public Track getSoundTrack() {
	return track;
    }
    public String getUsername() {
	return username;
    }
    public boolean isRunning() {
	return running;
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
		while(running && (msg = (Message)in.readObject()) != null) {
		    if(screen == null) continue;
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
