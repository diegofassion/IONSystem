package ionsystem;

import javax.swing.JOptionPane;

public class frmCadPeca extends javax.swing.JDialog {
    private boolean press_edit;
    
    public frmCadPeca(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setLocationRelativeTo(null); 
        
        HabilitarBotoes();
        DesabilitarCampos();
    }
    
    private void LimparCampos(){
        txtCadPecaCodigo.setText("");
        txtCadPecaDesc.setText("");
        txtCadPecaPreco.setText("");
    }
    
    private void HabilitarBotoes(){
        btnCadPecaInserir.setEnabled(true);
        btnCadPecaEditar.setEnabled(false);
        btnCadPecaExcluir.setEnabled(false);
        btnCadPecaPesquisar.setEnabled(true);
        btnCadPecaDesfazer.setEnabled(false);
        btnCadPecaSalvar.setEnabled(false);
        btnCadPecaSair.setEnabled(true);
    }
    
    public void DesabilitarBotoes(){
        btnCadPecaInserir.setEnabled(false);
        btnCadPecaEditar.setEnabled(false);
        btnCadPecaExcluir.setEnabled(false);
        btnCadPecaPesquisar.setEnabled(false);
        btnCadPecaDesfazer.setEnabled(true);
        btnCadPecaSalvar.setEnabled(true);
        btnCadPecaSair.setEnabled(false);
    }
        
    private void HabilitarCampos(){
        txtCadPecaCodigo.setEnabled(true);
        txtCadPecaDesc.setEnabled(true);
        txtCadPecaPreco.setEnabled(true);
    }
    
    private void DesabilitarCampos(){
        txtCadPecaCodigo.setEnabled(false);
        txtCadPecaDesc.setEnabled(false);
        txtCadPecaPreco.setEnabled(false);
    }
    
    private Peca getDados(){
        Peca s = new Peca();
        s.setCod_Peca(Integer.parseInt(txtCadPecaCodigo.getText()));
        s.setDescricao(txtCadPecaDesc.getText());
        s.setPreco(Float.parseFloat(txtCadPecaPreco.getText()));
        return s;
    }

    private void setDados(Peca a){
        txtCadPecaCodigo.setText(String.valueOf(a.getCod_Peca()));
        txtCadPecaDesc.setText(a.getDescricao());
        txtCadPecaPreco.setText(String.valueOf(a.getPreco()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCadPeca1 = new javax.swing.JPanel();
        btnCadPecaExcluir = new javax.swing.JButton();
        btnCadPecaInserir = new javax.swing.JButton();
        btnCadPecaEditar = new javax.swing.JButton();
        btnCadPecaPesquisar = new javax.swing.JButton();
        btnCadPecaSair = new javax.swing.JButton();
        jspCadPeca2 = new javax.swing.JSeparator();
        jspCadPeca1 = new javax.swing.JSeparator();
        btnCadPecaSalvar = new javax.swing.JButton();
        btnCadPecaDesfazer = new javax.swing.JButton();
        pnlCadPeca2 = new javax.swing.JPanel();
        lblCadPecaCodigo = new javax.swing.JLabel();
        txtCadPecaCodigo = new javax.swing.JTextField();
        lblCadPecaDescricao = new javax.swing.JLabel();
        txtCadPecaDesc = new javax.swing.JTextField();
        lblCadPecaPreco = new javax.swing.JLabel();
        txtCadPecaPreco = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlCadPeca1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnCadPecaExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Excluir.png"))); // NOI18N
        btnCadPecaExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCadPecaExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadPecaExcluir.setOpaque(false);
        btnCadPecaExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadPecaExcluirActionPerformed(evt);
            }
        });

        btnCadPecaInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Inserir.png"))); // NOI18N
        btnCadPecaInserir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCadPecaInserir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadPecaInserir.setOpaque(false);
        btnCadPecaInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadPecaInserirActionPerformed(evt);
            }
        });

        btnCadPecaEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Editar.png"))); // NOI18N
        btnCadPecaEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCadPecaEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadPecaEditar.setOpaque(false);
        btnCadPecaEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadPecaEditarActionPerformed(evt);
            }
        });

        btnCadPecaPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Pesquisar.png"))); // NOI18N
        btnCadPecaPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCadPecaPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadPecaPesquisar.setOpaque(false);
        btnCadPecaPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadPecaPesquisarActionPerformed(evt);
            }
        });

        btnCadPecaSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Sair.png"))); // NOI18N
        btnCadPecaSair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCadPecaSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadPecaSair.setOpaque(false);
        btnCadPecaSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadPecaSairActionPerformed(evt);
            }
        });

        jspCadPeca2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jspCadPeca1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnCadPecaSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Salvar.png"))); // NOI18N
        btnCadPecaSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCadPecaSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadPecaSalvar.setOpaque(false);
        btnCadPecaSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadPecaSalvarActionPerformed(evt);
            }
        });

        btnCadPecaDesfazer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Desfazer.png"))); // NOI18N
        btnCadPecaDesfazer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCadPecaDesfazer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadPecaDesfazer.setOpaque(false);
        btnCadPecaDesfazer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadPecaDesfazerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCadPeca1Layout = new javax.swing.GroupLayout(pnlCadPeca1);
        pnlCadPeca1.setLayout(pnlCadPeca1Layout);
        pnlCadPeca1Layout.setHorizontalGroup(
            pnlCadPeca1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadPeca1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnCadPecaInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadPecaEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadPecaExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadPecaSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadPecaDesfazer, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jspCadPeca1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadPecaPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jspCadPeca2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadPecaSair, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCadPeca1Layout.setVerticalGroup(
            pnlCadPeca1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadPeca1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCadPeca1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jspCadPeca2)
                    .addComponent(btnCadPecaPesquisar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btnCadPecaExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadPecaSair, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jspCadPeca1)
                    .addComponent(btnCadPecaSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadPecaDesfazer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadPecaEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btnCadPecaInserir, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlCadPeca2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCadPecaCodigo.setText("Código:");

        txtCadPecaCodigo.setToolTipText("");

        lblCadPecaDescricao.setText("Descrição:");

        txtCadPecaDesc.setToolTipText("");

        lblCadPecaPreco.setText("Preço:");

        txtCadPecaPreco.setToolTipText("");

        javax.swing.GroupLayout pnlCadPeca2Layout = new javax.swing.GroupLayout(pnlCadPeca2);
        pnlCadPeca2.setLayout(pnlCadPeca2Layout);
        pnlCadPeca2Layout.setHorizontalGroup(
            pnlCadPeca2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadPeca2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblCadPecaCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCadPecaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCadPecaDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCadPecaDesc)
                .addGap(18, 18, 18)
                .addComponent(lblCadPecaPreco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCadPecaPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        pnlCadPeca2Layout.setVerticalGroup(
            pnlCadPeca2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadPeca2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlCadPeca2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCadPecaCodigo)
                    .addComponent(txtCadPecaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCadPecaDescricao)
                    .addComponent(txtCadPecaDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCadPecaPreco)
                    .addComponent(txtCadPecaPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCadPeca1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlCadPeca2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlCadPeca1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlCadPeca2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadPecaSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadPecaSairActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCadPecaSairActionPerformed

    private void btnCadPecaPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadPecaPesquisarActionPerformed
        frmPesqPeca PesqPeca = new frmPesqPeca(null, rootPaneCheckingEnabled);
        PesqPeca.setVisible(true);
        Peca pç = PesqPeca.getPecaSelecionada();
        if(pç != null){
            setDados(pç);
        }
        if(txtCadPecaCodigo.getText().trim().isEmpty()){
            HabilitarBotoes();
        }else{
            btnCadPecaInserir.setEnabled(false);
            btnCadPecaEditar.setEnabled(true);
            btnCadPecaExcluir.setEnabled(true);
        }
    }//GEN-LAST:event_btnCadPecaPesquisarActionPerformed

    private void btnCadPecaInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadPecaInserirActionPerformed
        HabilitarCampos();
        DesabilitarBotoes();
        txtCadPecaCodigo.requestFocus();
    }//GEN-LAST:event_btnCadPecaInserirActionPerformed

    private void btnCadPecaEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadPecaEditarActionPerformed
        press_edit = true;
        DesabilitarBotoes();
        HabilitarCampos();
        txtCadPecaCodigo.requestFocus(true);
    }//GEN-LAST:event_btnCadPecaEditarActionPerformed

    private void btnCadPecaExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadPecaExcluirActionPerformed
        DAOPeca qry = new DAOPeca();
        qry.excluir(txtCadPecaCodigo.getText());
        this.LimparCampos();
        HabilitarBotoes();
        JOptionPane.showMessageDialog(null, "Peça Excluído com Sucesso!!!");
    }//GEN-LAST:event_btnCadPecaExcluirActionPerformed

    private void btnCadPecaSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadPecaSalvarActionPerformed
        DAOPeca qry = new DAOPeca();
        
        if (press_edit == false){ //SALVA
            if(txtCadPecaCodigo.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Código é obrigatório!!!","Aviso",JOptionPane.WHEN_IN_FOCUSED_WINDOW);
                txtCadPecaCodigo.requestFocus(true);
            }else if(txtCadPecaDesc.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Descrição é obrigatório!!!","Aviso",JOptionPane.WHEN_IN_FOCUSED_WINDOW);
                txtCadPecaDesc.requestFocus();
            }else if(txtCadPecaPreco.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "O Preço é obrigatório!!!","Aviso",JOptionPane.WHEN_IN_FOCUSED_WINDOW);
                txtCadPecaPreco.requestFocus();
            }else{
                qry.salvar(this.getDados());
                JOptionPane.showMessageDialog(null, "Peca inserida com sucesso!!!");
                this.LimparCampos();
                HabilitarBotoes();
                DesabilitarCampos();
            }
        }else{  //EDITA
            qry.editar(this.getDados(), txtCadPecaCodigo.getText());
            JOptionPane.showMessageDialog(null, "Peça editada com sucesso!!!");
            press_edit = false;
            this.LimparCampos();
            HabilitarBotoes();
            DesabilitarCampos();
        }
    }//GEN-LAST:event_btnCadPecaSalvarActionPerformed

    private void btnCadPecaDesfazerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadPecaDesfazerActionPerformed
        LimparCampos();
        DesabilitarCampos();
        HabilitarBotoes();
        press_edit = false;
    }//GEN-LAST:event_btnCadPecaDesfazerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmCadPeca dialog = new frmCadPeca(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadPecaDesfazer;
    private javax.swing.JButton btnCadPecaEditar;
    private javax.swing.JButton btnCadPecaExcluir;
    private javax.swing.JButton btnCadPecaInserir;
    private javax.swing.JButton btnCadPecaPesquisar;
    private javax.swing.JButton btnCadPecaSair;
    private javax.swing.JButton btnCadPecaSalvar;
    private javax.swing.JSeparator jspCadPeca1;
    private javax.swing.JSeparator jspCadPeca2;
    private javax.swing.JLabel lblCadPecaCodigo;
    private javax.swing.JLabel lblCadPecaDescricao;
    private javax.swing.JLabel lblCadPecaPreco;
    private javax.swing.JPanel pnlCadPeca1;
    private javax.swing.JPanel pnlCadPeca2;
    private javax.swing.JTextField txtCadPecaCodigo;
    private javax.swing.JTextField txtCadPecaDesc;
    private javax.swing.JTextField txtCadPecaPreco;
    // End of variables declaration//GEN-END:variables
}
