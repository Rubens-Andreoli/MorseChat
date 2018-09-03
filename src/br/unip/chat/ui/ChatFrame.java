package br.unip.chat.ui;

import br.unip.chat.networking.Client;
import br.unip.chat.networking.Message;
import br.unip.chat.networking.Screen;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

public class ChatFrame extends javax.swing.JFrame implements Screen{
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMsg = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        txaHistory = new javax.swing.JTextArea();
        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        mnuRoom = new javax.swing.JMenu();
        mntSound = new javax.swing.JCheckBoxMenuItem();
        javax.swing.JPopupMenu.Separator jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mntClose = new javax.swing.JMenuItem();
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

        mntSound.setSelected(true);
        mntSound.setText("Sound");
        mnuRoom.add(mntSound);
        mnuRoom.add(jSeparator1);

        mntClose.setText("Disconnect");
        mntClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mntCloseActionPerformed(evt);
            }
        });
        mnuRoom.add(mntClose);

        mntExit.setText("Exit");
        mntExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mntExitActionPerformed(evt);
            }
        });
        mnuRoom.add(mntExit);

        jMenuBar1.add(mnuRoom);

        mnuHelp.setText("Help");

        mntMorse.setText("Morse");
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mntMorseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mntMorseActionPerformed
        if(!morseDialog.isVisible()){ morseDialog.setVisible(true);
	}else morseDialog.requestFocus();
    }//GEN-LAST:event_mntMorseActionPerformed

    private void mntAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mntAboutActionPerformed
        aboutDialog.setVisible(true);
    }//GEN-LAST:event_mntAboutActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
	send();
    }//GEN-LAST:event_btnSendActionPerformed

    private void txtMsgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMsgKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) send();
    }//GEN-LAST:event_txtMsgKeyReleased

    private void mntExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mntExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mntExitActionPerformed

    private void mntCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mntCloseActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_mntCloseActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JMenuItem mntAbout;
    private javax.swing.JMenuItem mntClose;
    private javax.swing.JMenuItem mntExit;
    private javax.swing.JMenuItem mntMorse;
    private javax.swing.JCheckBoxMenuItem mntSound;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenu mnuRoom;
    private javax.swing.JTextArea txaHistory;
    private javax.swing.JTextField txtMsg;
    // End of variables declaration//GEN-END:variables
    
    private final Client client;
    private MorseDialog morseDialog;
    private AboutDialog aboutDialog;

    public ChatFrame(Frame parent, Client client){
	this.client = client;
	initComponents();
	config(parent);
    }

    private void config(Frame parent) {
	this.setLocationRelativeTo(parent);
	this.setTitle("Morse Code Chat - ["+client.getUsername()+"]");
	morseDialog = new MorseDialog(this);
	aboutDialog = new AboutDialog(this);
	
	this.addWindowListener(new WindowAdapter() {
	    @Override
	    public void windowClosing(WindowEvent e) {
		parent.setVisible(true);
	    }
	});
	
	this.setVisible(true);
	txtMsg.requestFocus();

	client.run(this);
	try {
	    client.startSound();
	} catch (MidiUnavailableException | InvalidMidiDataException ex) {
	    mntSound.setSelected(false);
	    mntSound.setEnabled(false);
	}
    }

    private void send() {
        if(!txtMsg.getText().isEmpty()){
	    try {
		client.send(txtMsg.getText().toLowerCase().trim());
	    } catch (IOException ex) {
		txaHistory.append("Erro ao enviar a menssagem.\n");
	    }
	    txtMsg.setText("");
	}
    }

    @Override
    public void printInfo(Message msg) {
	txaHistory.append(msg.getText()+"\n");
    }

    @Override
    public void printMessage(Message msg) {
	txaHistory.append(msg.getHour()+" - "+msg.getUser()+": "+msg.getText()+"\n");
	if(msg.isMorse() && mntSound.isSelected()){
	    client.resetSound();
	    msg.createSound(client.getSoundTrack());
	    try {
		client.playSound();
	    } catch (InvalidMidiDataException ex) {
		//ERRO: Som não pode ser reproduzido.
	    }
	}
    }
}
