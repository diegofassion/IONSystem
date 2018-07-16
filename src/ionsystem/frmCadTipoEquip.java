package ionsystem;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class frmCadTipoEquip extends javax.swing.JDialog {
    private boolean press_edit;

    public frmCadTipoEquip(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setLocationRelativeTo(null); 
        
        HabilitarBotoes();
        DesabilitarCampos();
    }
    
    private void LimparCampos(){
        txtCodigo.setText("");
        txtDescricao.setText("");
    }
    
    private void HabilitarBotoes(){
        btnTipoEquipInserir.setEnabled(true);
        btnTipoEquipEditar.setEnabled(false);
        btnTipoEquipExcluir.setEnabled(false);
        btnTipoEquipPesquisar.setEnabled(true);
        btnTipoEquipDesfazer.setEnabled(false);
        btnTipoEquipSalvar.setEnabled(false);
        btnTipoEquipSair.setEnabled(true);
    }
    
    public void DesabilitarBotoes(){
        btnTipoEquipInserir.setEnabled(false);
        btnTipoEquipEditar.setEnabled(false);
        btnTipoEquipExcluir.setEnabled(false);
        btnTipoEquipPesquisar.setEnabled(false);
        btnTipoEquipDesfazer.setEnabled(true);
        btnTipoEquipSalvar.setEnabled(true);
        btnTipoEquipSair.setEnabled(false);
    }
        
    private void HabilitarCampos(){
        txtCodigo.setEnabled(true);
        txtDescricao.setEnabled(true);
    }
    
    private void DesabilitarCampos(){
        txtCodigo.setEnabled(false);
        txtDescricao.setEnabled(false);
    }
    
    private TipoEquip getDados(){
        TipoEquip a = new TipoEquip();
        a.setCodigo(Integer.parseInt(txtCodigo.getText()));
        a.setDescricao(txtDescricao.getText());
        return a;
    }
    
    private void setDados(TipoEquip a){
        txtCodigo.setText(String.valueOf(a.getCodigo()));
        txtDescricao.setText(a.getDescricao());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCadFunc1 = new javax.swing.JPanel();
        btnTipoEquipExcluir = new javax.swing.JButton();
        btnTipoEquipInserir = new javax.swing.JButton();
        btnTipoEquipEditar = new javax.swing.JButton();
        btnTipoEquipPesquisar = new javax.swing.JButton();
        btnTipoEquipSair = new javax.swing.JButton();
        jspTipoEquip2 = new javax.swing.JSeparator();
        jspTipoEquip1 = new javax.swing.JSeparator();
        btnTipoEquipSalvar = new javax.swing.JButton();
        btnTipoEquipDesfazer = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblDescricao = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnlCadFunc1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnTipoEquipExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Excluir.png"))); // NOI18N
        btnTipoEquipExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnTipoEquipExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTipoEquipExcluir.setOpaque(false);
        btnTipoEquipExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoEquipExcluirActionPerformed(evt);
            }
        });

        btnTipoEquipInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Inserir.png"))); // NOI18N
        btnTipoEquipInserir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnTipoEquipInserir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTipoEquipInserir.setOpaque(false);
        btnTipoEquipInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoEquipInserirActionPerformed(evt);
            }
        });

        btnTipoEquipEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Editar.png"))); // NOI18N
        btnTipoEquipEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnTipoEquipEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTipoEquipEditar.setOpaque(false);
        btnTipoEquipEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoEquipEditarActionPerformed(evt);
            }
        });

        btnTipoEquipPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Pesquisar.png"))); // NOI18N
        btnTipoEquipPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnTipoEquipPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTipoEquipPesquisar.setOpaque(false);
        btnTipoEquipPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoEquipPesquisarActionPerformed(evt);
            }
        });

        btnTipoEquipSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Sair.png"))); // NOI18N
        btnTipoEquipSair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnTipoEquipSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTipoEquipSair.setOpaque(false);
        btnTipoEquipSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoEquipSairActionPerformed(evt);
            }
        });

        jspTipoEquip2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jspTipoEquip1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnTipoEquipSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Salvar.png"))); // NOI18N
        btnTipoEquipSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnTipoEquipSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTipoEquipSalvar.setOpaque(false);
        btnTipoEquipSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoEquipSalvarActionPerformed(evt);
            }
        });

        btnTipoEquipDesfazer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Desfazer.png"))); // NOI18N
        btnTipoEquipDesfazer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnTipoEquipDesfazer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTipoEquipDesfazer.setOpaque(false);
        btnTipoEquipDesfazer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoEquipDesfazerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCadFunc1Layout = new javax.swing.GroupLayout(pnlCadFunc1);
        pnlCadFunc1.setLayout(pnlCadFunc1Layout);
        pnlCadFunc1Layout.setHorizontalGroup(
            pnlCadFunc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadFunc1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnTipoEquipInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTipoEquipEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTipoEquipExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTipoEquipSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTipoEquipDesfazer, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jspTipoEquip1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTipoEquipPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jspTipoEquip2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTipoEquipSair, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnlCadFunc1Layout.setVerticalGroup(
            pnlCadFunc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadFunc1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCadFunc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jspTipoEquip2)
                    .addComponent(btnTipoEquipPesquisar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btnTipoEquipExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTipoEquipSair, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jspTipoEquip1)
                    .addComponent(btnTipoEquipSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTipoEquipDesfazer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTipoEquipEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btnTipoEquipInserir, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCodigo.setText("Código:");

        txtCodigo.setToolTipText("");

        lblDescricao.setText("Descrição:");

        txtDescricao.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescricao)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCadFunc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlCadFunc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTipoEquipSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoEquipSairActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnTipoEquipSairActionPerformed

    private void btnTipoEquipSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoEquipSalvarActionPerformed
        DAOTipoEquip qry = new DAOTipoEquip();
        
        if (press_edit == false){ //SALVA
            if(txtCodigo.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Código é obrigatório!!!","Aviso",JOptionPane.WHEN_IN_FOCUSED_WINDOW);
                txtCodigo.requestFocus(true);
            }else if(txtDescricao.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Descrição é obrigatório!!!","Aviso",JOptionPane.WHEN_IN_FOCUSED_WINDOW);
                txtDescricao.requestFocus();
            }else{
                qry.salvar(this.getDados());
                JOptionPane.showMessageDialog(null, "Tipo de Equipamento inserido com sucesso!!!");
                this.LimparCampos();
                HabilitarBotoes();
                DesabilitarCampos();
            }
        }else{  //EDITA
            qry.editar(this.getDados(), txtCodigo.getText());
            JOptionPane.showMessageDialog(null, "Tipo de Equipamento editado com sucesso!!!");
            press_edit = false;
            this.LimparCampos();
            HabilitarBotoes();
            DesabilitarCampos();
        }
    }//GEN-LAST:event_btnTipoEquipSalvarActionPerformed

    private void btnTipoEquipInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoEquipInserirActionPerformed
        HabilitarCampos();
        DesabilitarBotoes();
        txtCodigo.requestFocus();
    }//GEN-LAST:event_btnTipoEquipInserirActionPerformed

    private void btnTipoEquipEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoEquipEditarActionPerformed
        press_edit = true;
        DesabilitarBotoes();
        HabilitarCampos();
        txtCodigo.requestFocus(true);
    }//GEN-LAST:event_btnTipoEquipEditarActionPerformed

    private void btnTipoEquipExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoEquipExcluirActionPerformed
        DAOTipoEquip qry = new DAOTipoEquip();
        qry.excluir(txtCodigo.getText());
        this.LimparCampos();
        HabilitarBotoes();
        JOptionPane.showMessageDialog(null, "Tipo de Equipamento Excluído com Sucesso!!!");
    }//GEN-LAST:event_btnTipoEquipExcluirActionPerformed

    private void btnTipoEquipDesfazerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoEquipDesfazerActionPerformed
        LimparCampos();
        DesabilitarCampos();
        HabilitarBotoes();
        press_edit = false;
    }//GEN-LAST:event_btnTipoEquipDesfazerActionPerformed

    private void btnTipoEquipPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoEquipPesquisarActionPerformed
        frmPesqTipoEquip PesqTipoEquip = new frmPesqTipoEquip(null, rootPaneCheckingEnabled);
        PesqTipoEquip.setVisible(true);
        TipoEquip tipo = PesqTipoEquip.getTipoSelecionado();
        if(tipo != null){
            setDados(tipo);
        }
        if(txtCodigo.getText().trim().isEmpty()){
            HabilitarBotoes();
        }else{
            btnTipoEquipInserir.setEnabled(false);
            btnTipoEquipEditar.setEnabled(true);
            btnTipoEquipExcluir.setEnabled(true);
        }
    }//GEN-LAST:event_btnTipoEquipPesquisarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmCadTipoEquip dialog = new frmCadTipoEquip(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnTipoEquipDesfazer;
    private javax.swing.JButton btnTipoEquipEditar;
    private javax.swing.JButton btnTipoEquipExcluir;
    private javax.swing.JButton btnTipoEquipInserir;
    private javax.swing.JButton btnTipoEquipPesquisar;
    private javax.swing.JButton btnTipoEquipSair;
    private javax.swing.JButton btnTipoEquipSalvar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jspTipoEquip1;
    private javax.swing.JSeparator jspTipoEquip2;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JPanel pnlCadFunc1;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescricao;
    // End of variables declaration//GEN-END:variables
}
