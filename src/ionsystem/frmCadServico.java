package ionsystem;

import javax.swing.JOptionPane;

public class frmCadServico extends javax.swing.JDialog {
    private boolean press_edit;
    
    public frmCadServico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setLocationRelativeTo(null); 
        
        HabilitarBotoes();
        DesabilitarCampos();
    }
    
    private void LimparCampos(){
        txtCadServCodigo.setText("");
        txtCadServDesc.setText("");
    }
    
    private void HabilitarBotoes(){
        btnCadServInserir.setEnabled(true);
        btnCadServEditar.setEnabled(false);
        btnCadServExcluir.setEnabled(false);
        btnCadServPesquisar.setEnabled(true);
        btnCadServDesfazer.setEnabled(false);
        btnCadServSalvar.setEnabled(false);
        btnCadServSair.setEnabled(true);
    }
    
    public void DesabilitarBotoes(){
        btnCadServInserir.setEnabled(false);
        btnCadServEditar.setEnabled(false);
        btnCadServExcluir.setEnabled(false);
        btnCadServPesquisar.setEnabled(false);
        btnCadServDesfazer.setEnabled(true);
        btnCadServSalvar.setEnabled(true);
        btnCadServSair.setEnabled(false);
    }
        
    private void HabilitarCampos(){
        txtCadServCodigo.setEnabled(true);
        txtCadServDesc.setEnabled(true);
        txtCadServPreco.setEnabled(true);
    }
    
    private void DesabilitarCampos(){
        txtCadServCodigo.setEnabled(false);
        txtCadServDesc.setEnabled(false);
        txtCadServPreco.setEnabled(false);
    }
    
    private Servico getDados(){
        Servico s = new Servico();
        s.setCodigo(Integer.parseInt(txtCadServCodigo.getText()));
        s.setDescricao(txtCadServDesc.getText());
        s.setPreco(Float.parseFloat(txtCadServPreco.getText()));
        return s;
    }
    
    private void setDados(Servico a){
        txtCadServCodigo.setText(String.valueOf(a.getCodigo()));
        txtCadServDesc.setText(a.getDescricao());
        txtCadServPreco.setText(String.valueOf(a.getPreco()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCadServ1 = new javax.swing.JPanel();
        btnCadServExcluir = new javax.swing.JButton();
        btnCadServInserir = new javax.swing.JButton();
        btnCadServEditar = new javax.swing.JButton();
        btnCadServPesquisar = new javax.swing.JButton();
        btnCadServSair = new javax.swing.JButton();
        jspCadServ2 = new javax.swing.JSeparator();
        jspCadServ1 = new javax.swing.JSeparator();
        btnCadServSalvar = new javax.swing.JButton();
        btnCadServDesfazer = new javax.swing.JButton();
        pnlCadServ2 = new javax.swing.JPanel();
        lblCadServCodigo = new javax.swing.JLabel();
        txtCadServCodigo = new javax.swing.JTextField();
        lblCadServDescricao = new javax.swing.JLabel();
        txtCadServDesc = new javax.swing.JTextField();
        lblCadServPreco = new javax.swing.JLabel();
        txtCadServPreco = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlCadServ1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnCadServExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Excluir.png"))); // NOI18N
        btnCadServExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCadServExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadServExcluir.setOpaque(false);
        btnCadServExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadServExcluirActionPerformed(evt);
            }
        });

        btnCadServInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Inserir.png"))); // NOI18N
        btnCadServInserir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCadServInserir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadServInserir.setOpaque(false);
        btnCadServInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadServInserirActionPerformed(evt);
            }
        });

        btnCadServEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Editar.png"))); // NOI18N
        btnCadServEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCadServEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadServEditar.setOpaque(false);
        btnCadServEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadServEditarActionPerformed(evt);
            }
        });

        btnCadServPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Pesquisar.png"))); // NOI18N
        btnCadServPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCadServPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadServPesquisar.setOpaque(false);
        btnCadServPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadServPesquisarActionPerformed(evt);
            }
        });

        btnCadServSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Sair.png"))); // NOI18N
        btnCadServSair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCadServSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadServSair.setOpaque(false);
        btnCadServSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadServSairActionPerformed(evt);
            }
        });

        jspCadServ2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jspCadServ1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnCadServSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Salvar.png"))); // NOI18N
        btnCadServSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCadServSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadServSalvar.setOpaque(false);
        btnCadServSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadServSalvarActionPerformed(evt);
            }
        });

        btnCadServDesfazer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Desfazer.png"))); // NOI18N
        btnCadServDesfazer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCadServDesfazer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadServDesfazer.setOpaque(false);
        btnCadServDesfazer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadServDesfazerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCadServ1Layout = new javax.swing.GroupLayout(pnlCadServ1);
        pnlCadServ1.setLayout(pnlCadServ1Layout);
        pnlCadServ1Layout.setHorizontalGroup(
            pnlCadServ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadServ1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnCadServInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadServEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadServExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadServSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadServDesfazer, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jspCadServ1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadServPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jspCadServ2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadServSair, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        pnlCadServ1Layout.setVerticalGroup(
            pnlCadServ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadServ1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCadServ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jspCadServ2)
                    .addComponent(btnCadServPesquisar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btnCadServExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadServSair, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jspCadServ1)
                    .addComponent(btnCadServSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadServDesfazer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadServEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btnCadServInserir, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlCadServ2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCadServCodigo.setText("Código:");

        txtCadServCodigo.setToolTipText("");

        lblCadServDescricao.setText("Descrição:");

        txtCadServDesc.setToolTipText("");

        lblCadServPreco.setText("Preço:   R$");

        txtCadServPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("####.##"))));

        javax.swing.GroupLayout pnlCadServ2Layout = new javax.swing.GroupLayout(pnlCadServ2);
        pnlCadServ2.setLayout(pnlCadServ2Layout);
        pnlCadServ2Layout.setHorizontalGroup(
            pnlCadServ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadServ2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblCadServCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCadServCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCadServDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCadServDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCadServPreco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCadServPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCadServ2Layout.setVerticalGroup(
            pnlCadServ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadServ2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlCadServ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCadServCodigo)
                    .addComponent(txtCadServCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCadServDescricao)
                    .addComponent(txtCadServDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCadServPreco)
                    .addComponent(txtCadServPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCadServ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlCadServ2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlCadServ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlCadServ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadServSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadServSairActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCadServSairActionPerformed

    private void btnCadServSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadServSalvarActionPerformed
        DAOServico qry = new DAOServico();
        
        if (press_edit == false){ //SALVA
            if(txtCadServCodigo.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Código é obrigatório!!!","Aviso",JOptionPane.WHEN_IN_FOCUSED_WINDOW);
                txtCadServCodigo.requestFocus(true);
            }else if(txtCadServDesc.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Descrição é obrigatório!!!","Aviso",JOptionPane.WHEN_IN_FOCUSED_WINDOW);
                txtCadServDesc.requestFocus();
            }else if(txtCadServPreco.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "O Preço é obrigatório!!!","Aviso",JOptionPane.WHEN_IN_FOCUSED_WINDOW);
                txtCadServPreco.requestFocus();
            }else{
                qry.salvar(this.getDados());
                JOptionPane.showMessageDialog(null, "Serviço inserido com sucesso!!!");
                this.LimparCampos();
                HabilitarBotoes();
                DesabilitarCampos();
            }
        }else{  //EDITA
            qry.editar(this.getDados(), txtCadServCodigo.getText());
            JOptionPane.showMessageDialog(null, "Serviço editado com sucesso!!!");
            press_edit = false;
            this.LimparCampos();
            HabilitarBotoes();
            DesabilitarCampos();
        }
    }//GEN-LAST:event_btnCadServSalvarActionPerformed

    private void btnCadServInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadServInserirActionPerformed
        HabilitarCampos();
        DesabilitarBotoes();
        txtCadServCodigo.requestFocus();
    }//GEN-LAST:event_btnCadServInserirActionPerformed

    private void btnCadServEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadServEditarActionPerformed
        press_edit = true;
        DesabilitarBotoes();
        HabilitarCampos();
        txtCadServCodigo.requestFocus(true);
    }//GEN-LAST:event_btnCadServEditarActionPerformed

    private void btnCadServExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadServExcluirActionPerformed
        DAOServico qry = new DAOServico();
        qry.excluir(txtCadServCodigo.getText());
        this.LimparCampos();
        HabilitarBotoes();
        JOptionPane.showMessageDialog(null, "Serviço Excluído com Sucesso!!!");
    }//GEN-LAST:event_btnCadServExcluirActionPerformed

    private void btnCadServDesfazerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadServDesfazerActionPerformed
        LimparCampos();
        DesabilitarCampos();
        HabilitarBotoes();
        press_edit = false;
    }//GEN-LAST:event_btnCadServDesfazerActionPerformed

    private void btnCadServPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadServPesquisarActionPerformed
        frmPesqServico PesqServico = new frmPesqServico(null, rootPaneCheckingEnabled);
        PesqServico.setVisible(true);
        Servico serv = PesqServico.getServicoSelecionado();
        if(serv != null){
            setDados(serv);
        }
        if(txtCadServCodigo.getText().trim().isEmpty()){
            HabilitarBotoes();
        }else{
            btnCadServInserir.setEnabled(false);
            btnCadServEditar.setEnabled(true);
            btnCadServExcluir.setEnabled(true);
        }
    }//GEN-LAST:event_btnCadServPesquisarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmCadServico dialog = new frmCadServico(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCadServDesfazer;
    private javax.swing.JButton btnCadServEditar;
    private javax.swing.JButton btnCadServExcluir;
    private javax.swing.JButton btnCadServInserir;
    private javax.swing.JButton btnCadServPesquisar;
    private javax.swing.JButton btnCadServSair;
    private javax.swing.JButton btnCadServSalvar;
    private javax.swing.JSeparator jspCadServ1;
    private javax.swing.JSeparator jspCadServ2;
    private javax.swing.JLabel lblCadServCodigo;
    private javax.swing.JLabel lblCadServDescricao;
    private javax.swing.JLabel lblCadServPreco;
    private javax.swing.JPanel pnlCadServ1;
    private javax.swing.JPanel pnlCadServ2;
    private javax.swing.JTextField txtCadServCodigo;
    private javax.swing.JTextField txtCadServDesc;
    private javax.swing.JFormattedTextField txtCadServPreco;
    // End of variables declaration//GEN-END:variables
}
