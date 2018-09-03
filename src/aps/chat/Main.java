package aps.chat;

import aps.chat.ui.LoginFrame;

public class Main {

    public static void main(String args[]) {

	//<editor-fold defaultstate="collapsed" desc="Look and Feel ">
	try {
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {}
	//</editor-fold>

	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new LoginFrame().setVisible(true);
	    }
	});
    }
}