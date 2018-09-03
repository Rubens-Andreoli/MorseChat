package br.unip.chat.ui;

import java.awt.Frame;

public class AboutDialog extends javax.swing.JDialog {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        javax.swing.JTextArea jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About");
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unip/chat/ui/img/logo_small.png"))); // NOI18N

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("SOFTWARE PROJETADO PARA A DISCIPLINA APS (ATIVIDADES PRATICAS SUPERVISIONADAS)\n\nCURSO: CIENCIA DA COMPUTACAO\nTURMA: CC2P18 / CC2Q18 UNIP CAMPUS VARGAS\nGUILHERME\tC59386-9\nRAPHAEL         C39FCE-7 \nRUBENS\t\tT49128-2\n \nESTE APLICATIVO FOI DESENVOLVIDO EM LINGUAGEM DE PROGRAMACAO ORIENTADA A OBJETO (\"JAVA\") E TEM COMO OBJETIVO CODIFICAR E DECODIFICAR MENSAGENS ENVIADAS PARA UMA REDE DE COMPUTADORES POR MEIO DE UM CHAT.");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private final Frame parent;
    
    public AboutDialog(Frame parent) {
	super(parent);
	this.parent = parent;
	initComponents();
    }

    @Override
    public void setVisible(boolean b) {
	this.setLocationRelativeTo(parent);
	super.setVisible(b);
    }
 
}
