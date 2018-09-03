package aps.chat.ui;

import aps.chat.networking.Client;
import aps.chat.networking.Message;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatFrame extends javax.swing.JFrame{
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMsg = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        txaHistory = new javax.swing.JTextArea();
        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        mnuRoom = new javax.swing.JMenu();
        mntMorseLatin = new javax.swing.JCheckBoxMenuItem();
        javax.swing.JPopupMenu.Separator jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mntExit = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();
        mntMorse = new javax.swing.JMenuItem();
        mntAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Morse Code Chat");

        txtMsg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMsgKeyReleased(evt);
            }
        });

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        txaHistory.setEditable(false);
        txaHistory.setColumns(20);
        txaHistory.setLineWrap(true);
        txaHistory.setRows(5);
        txaHistory.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane2.setViewportView(txaHistory);

        mnuRoom.setText("Room");

        mntMorseLatin.setText("Encode/Decode");
        mnuRoom.add(mntMorseLatin);
        mnuRoom.add(jSeparator1);

        mntExit.setText("Exit");
        mnuRoom.add(mntExit);

        jMenuBar1.add(mnuRoom);

        mnuHelp.setText("Help");

        mntMorse.setText("Morse Guide");
        mntMorse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mntMorseActionPerformed(evt);
            }
        });
        mnuHelp.add(mntMorse);

        mntAbout.setText("About");
        mntAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mntAboutActionPerformed(evt);
            }
        });
        mnuHelp.add(mntAbout);

        jMenuBar1.add(mnuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMsg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
	client.send(new Message(username, txtMsg.getText()));
    }//GEN-LAST:event_btnSendActionPerformed

    private void txtMsgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMsgKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) client.send(new Message(username, txtMsg.getText()));
    }//GEN-LAST:event_txtMsgKeyReleased

    private boolean isMorseOpen = false;
    private void mntMorseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mntMorseActionPerformed
        if(!isMorseOpen){
	    new MorseDialog(this).setVisible(true);
	    isMorseOpen = true;
	}
    }//GEN-LAST:event_mntMorseActionPerformed

    private void mntAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mntAboutActionPerformed
        new AboutDialog(this).setVisible(true);
    }//GEN-LAST:event_mntAboutActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JMenuItem mntAbout;
    private javax.swing.JMenuItem mntExit;
    private javax.swing.JMenuItem mntMorse;
    private javax.swing.JCheckBoxMenuItem mntMorseLatin;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenu mnuRoom;
    private javax.swing.JTextArea txaHistory;
    private javax.swing.JTextField txtMsg;
    // End of variables declaration//GEN-END:variables
    
    private String username;
    private Socket s;
    private Client client;
    
    public ChatFrame(Frame parent, Client client, String username){
	initComponents();
	config(parent);
	
	this.username = username;
	this.client = client;
	
	s = client.connect();
	new Thread(new ServerListener(s)).start();
	client.send(new Message(username, null));
    }

    private void config(Frame parent) {
	this.setLocationRelativeTo(parent);
	txtMsg.requestFocus();
	this.setVisible(true);
	WindowListener exitListener = new WindowAdapter() {
	    @Override
	    public void windowClosing(WindowEvent e) {
		parent.setVisible(true);
		client.send(new Message(username, null));
		try {
		    s.close(); //disconnect
		} catch (IOException ex) {
		    Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
		}
	    }
	};
	this.addWindowListener(exitListener);
    }
    
    public void setMorseGuide(boolean isOpen) {
	this.isMorseOpen = false;
    }
    
    private class ServerListener implements Runnable {

	private ObjectInputStream in;
	
	public ServerListener(Socket s){
	    try {
		in = new ObjectInputStream(s.getInputStream());
	    } catch (IOException ex) {
		Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	@Override
	public void run() {
	    Message msg = null;
	    try {
		while((msg = (Message)in.readObject()) != null) {
		    if(msg.getText() != null){
			receive(msg);
		    }
		}
	    } catch (IOException ex) {
		//
	    } catch (ClassNotFoundException ex) {
		Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }

    private void receive(Message msg) {
	txaHistory.append(msg.getHour()+" - "+msg.getUser()+": "+msg.getText()+"\n");
    }

}
