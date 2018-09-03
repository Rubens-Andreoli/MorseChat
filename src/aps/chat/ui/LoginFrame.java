package aps.chat.ui;

import aps.chat.networking.Client;
import aps.chat.networking.Server;

public class LoginFrame extends javax.swing.JFrame {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        chbIsServer = new javax.swing.JCheckBox();
        lblIP = new javax.swing.JLabel();
        txtIP = new javax.swing.JTextField();
        lblPort = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        lblIPEx = new javax.swing.JLabel();
        lblPortEx = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        lblName.setText("Username:");

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });

        chbIsServer.setText("Server");
        chbIsServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbIsServerActionPerformed(evt);
            }
        });

        lblIP.setText("Hostname:");

        txtIP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIPKeyReleased(evt);
            }
        });

        lblPort.setText("Port:");

        txtPort.setToolTipText("1000 to 65535");
        txtPort.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPortKeyReleased(evt);
            }
        });

        lblIPEx.setText("ex.: 127.0.0.1");

        lblPortEx.setText("ex.: 1500");

        btnStart.setText("Login");
        btnStart.setEnabled(false);
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aps/chat/ui/img/logo_small.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPort)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(lblIPEx)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(chbIsServer))
                                        .addComponent(txtIP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(74, 74, 74)
                                    .addComponent(lblName))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(80, 80, 80)
                                    .addComponent(btnStart))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(74, 74, 74)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(lblPort)
                                        .addComponent(lblIP))))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblPortEx)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblIP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIPEx)
                    .addComponent(chbIsServer))
                .addGap(11, 11, 11)
                .addComponent(lblPort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPortEx)
                .addGap(7, 7, 7)
                .addComponent(btnStart)
                .addGap(10, 10, 10))
        );

        txtPort.getAccessibleContext().setAccessibleDescription("between 1000 and 65535");
        lblPortEx.getAccessibleContext().setAccessibleName("ex.: 1510");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chbIsServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbIsServerActionPerformed
        txtIP.setEnabled(!chbIsServer.isSelected());
	ValidateFields();
    }//GEN-LAST:event_chbIsServerActionPerformed

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        ValidateFields();
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtIPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIPKeyReleased
        ValidateFields();
    }//GEN-LAST:event_txtIPKeyReleased

    private void txtPortKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPortKeyReleased
        ValidateFields();
    }//GEN-LAST:event_txtPortKeyReleased

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        if(chbIsServer.isSelected()){
	    new Thread(new Server(Integer.parseInt(txtPort.getText()))).start();
	    new ChatFrame(this, new Client(
		    "localhost", 
		    Integer.parseInt(txtPort.getText())),
		    txtName.getText()
	    );
	}else{
	    new ChatFrame(this, new Client(
		    txtIP.getText(), 
		    Integer.parseInt(txtPort.getText())),
		    txtName.getText()
	    );
	}
	this.dispose();
    }//GEN-LAST:event_btnStartActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JCheckBox chbIsServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblIP;
    private javax.swing.JLabel lblIPEx;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPort;
    private javax.swing.JLabel lblPortEx;
    private javax.swing.JTextField txtIP;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables

    private static final String IP4_REGEX = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
					    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
					    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
					    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    
    public LoginFrame() {
	initComponents();
	config();
    }
    
    private void config() {
	this.setLocationRelativeTo(null);
    }
    
    private void ValidateFields() {
	btnStart.setEnabled(validateName() && validatePort() &&
		(!chbIsServer.isSelected()? validateIP() : true));
    }
    
    private boolean validateName() {
	return txtName.getText().length() >= 3;
    }
    
    private boolean validatePort() {
	if(txtPort.getText().isEmpty()) return false;
	try{
	    int port = Integer.parseInt(txtPort.getText());
	    return port >= 1000 && port <= 65535;
	}catch(Exception e){
	    return false;
	}
    }
    
    private boolean validateIP() {
	if(txtIP.getText().isEmpty()) return false;
	return txtIP.getText().matches(IP4_REGEX);
    }
}
