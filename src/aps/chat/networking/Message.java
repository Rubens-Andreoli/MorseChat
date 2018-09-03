package aps.chat.networking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Message implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private static final ArrayList<String> LATIN = new ArrayList<>(
	Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", 
	"n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7",
	"8", "9", "0")
    );

    private static final ArrayList<String> MORSE = new ArrayList<>(
	Arrays.asList(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
	".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--",
	"-..-", "-.--", "--..", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", 
	"----.", "-----")
    );

    private final String hour;
    private final String user;
    private String text;
    private boolean isMorse;
    
    public Message(String user, String text) {
	this.user = user;
	this.text = text;
	
	if(text == null || text.contains("|")) isMorse = true;
	
	Calendar cal = Calendar.getInstance();
	cal.setTime(new Date());  
	hour = cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND);
    }

    public String getHour() {
	return hour;
    }

    public String getUser() {
	return user;
    }

    public String getText() {
	return text;
    }

    public void encode() {
	if(isMorse) return;
	StringBuilder encoded = new StringBuilder("");
	for(int i=0; i<text.length(); i++){
	    int pos = LATIN.indexOf(text.charAt(i)+"");
	    if(pos >= 0) encoded.append(MORSE.get(pos)).append(" ");
	    if(pos == -1 && text.charAt(i) == ' '){
		encoded.deleteCharAt(encoded.length()-1);
		encoded.append("|");
	    }
	}
	text = encoded.toString();
	isMorse = true;
    }
    
    public void decode() {
	if(!isMorse) return;
	StringBuilder decoded = new StringBuilder("");
	String[] words = text.split("(\\|)");
	for(int i=0; i<words.length; i++){
	    String[] letters = words[i].split(" ");
	    for(int j=0; j<letters.length; j++){
		int pos = MORSE.indexOf(letters[j]);
		if(pos >=0) decoded.append(LATIN.get(pos));
	    }
	    decoded.append(" ");
	}
	text = decoded.toString();
	isMorse = false;
    }
    
    public void play() {
	if(!isMorse) return;
	//TODO: morse sound.
    }
}
