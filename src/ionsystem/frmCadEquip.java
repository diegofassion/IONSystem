package ionsystem;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class frmCadEquip extends javax.swing.JDialog {
    private boolean press_edit;
    private ArrayList<TipoEquip> TiposEquip;
    
    public frmCadEquip(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null); 
        
        DAOTipoEquip qry = new DAOTipoEquip();
        TiposEquip= qry.ListarTodosTiposEquip(); //PUXA A LISTA DE ALUNOS
        cbbTipoEquip.addItem("Selecione o Tipo");
        for(TipoEquip a: TiposEquip) //CARREGA OS ITENS NO COMBOBOX
            cbbTipoEquip.addItem(a.getDescricao());
        
        HabilitarBotoes();
        DesabilitarCampos();
    }
    
    private void LimparCampos(){
        txtEquipCodigo.setText("");
        txtEquipMarca.setText("");
        txtEquipModelo.setText("");
        txtEquipSerie.setText("");
        txtEquipDescricao.setText("");
        txtEquipObs.setText("");
        cbbTipoEquip.setSelectedIndex(0);
        txtClienteCodigo.setText("");
        txtClienteNome.setText("");
    }
    
    private void HabilitarBotoes(){
        btnEquipInserir.setEnabled(true);
        btnEquipEditar.setEnabled(false);
        btnEquipExcluir.setEnabled(false);
        btnEquipPesquisar.setEnabled(true);
        btnEquipDesfazer.setEnabled(false);
        btnEquipSalvar.setEnabled(false);
        btnEquipSair.setEnabled(true);
    }
    
    public void DesabilitarBotoes(){
        btnEquipInserir.setEnabled(false);
        btnEquipEditar.setEnabled(false);
        btnEquipExcluir.setEnabled(false);
        btnEquipPesquisar.setEnabled(false);
        btnEquipDesfazer.setEnabled(true);
        btnEquipSalvar.setEnabled(true);
        btnEquipSair.setEnabled(false);
    }
        
    private void HabilitarCampos(){
        txtEquipCodigo.setEnabled(true);
        txtEquipMarca.setEnabled(true);
        txtEquipModelo.setEnabled(true);
        txtEquipSerie.setEnabled(true);
        txtEquipDescricao.setEnabled(true);
        txtEquipObs.setEnabled(true);
        cbbTipoEquip.setEnabled(true);
        btnEquipNvTipo.setEnabled(true);
        btnEquipPesqCli.setEnabled(true);
    }
    
    private void DesabilitarCampos(){
        txtEquipCodigo.setEnabled(false);
        txtEquipMarca.setEnabled(false);
        txtEquipModelo.setEnabled(false);
        txtEquipSerie.setEnabled(false);
        txtEquipDescricao.setEnabled(false);
        txtEquipObs.setEnabled(false);
        cbbTipoEquip.setEnabled(false);
        btnEquipNvTipo.setEnabled(false);
        btnEquipPesqCli.setEnabled(false);
    }
    
    private Equipamento getDados(int cod){
        Equipamento a = new Equipamento();
        a.setCod_Equip(Integer.parseInt(txtEquipCodigo.getText()));
        a.setMarca(txtEquipMarca.getText());
        a.setModelo(txtEquipModelo.getText());
        a.setSerie(txtEquipSerie.getText());
        a.setDescricao(txtEquipDescricao.getText());
        a.setObs(txtEquipObs.getText());
        a.setTipoEquip(cod);
        a.setCod_Cliente(Integer.parseInt(txtClienteCodigo.getText()));
        a.setNome_Cliente(txtClienteNome.getText());
        return a;
    }
    
    private void setDados(Equipamento a){
        txtEquipCodigo.setText(String.valueOf(a.getCod_Equip()));
        txtEquipMarca.setText(a.getMarca());
        txtEquipModelo.setText(a.getModelo());
    }

    private void setDadosCliente(Cliente a){
        txtClienteCodigo.setText(String.valueOf(a.getCod_Cliente()));
        txtClienteNome.setText(a.getNome());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCadEquip1 = new javax.swing.JPanel();
        btnEquipExcluir = new javax.swing.JButton();
        btnEquipInserir = new javax.swing.JButton();
        btnEquipEditar = new javax.swing.JButton();
        btnEquipPesquisar = new javax.swing.JButton();
        btnEquipSair = new javax.swing.JButton();
        jspEquip2 = new javax.swing.JSeparator();
        jspEquip1 = new javax.swing.JSeparator();
        btnEquipSalvar = new javax.swing.JButton();
        btnEquipDesfazer = new javax.swing.JButton();
        pnlCadEquip2 = new javax.swing.JPanel();
        pnlDadosEquip = new javax.swing.JPanel();
        lblEquipCodigo = new javax.swing.JLabel();
        txtEquipCodigo = new javax.swing.JTextField();
        lblEquipMarca = new javax.swing.JLabel();
        txtEquipMarca = new javax.swing.JTextField();
        txtEquipModelo = new javax.swing.JTextField();
        lblEquipModelo = new javax.swing.JLabel();
        lblEquipSerie = new javax.swing.JLabel();
        txtEquipSerie = new javax.swing.JTextField();
        cbbTipoEquip = new javax.swing.JComboBox<>();
        lblEquipTipo = new javax.swing.JLabel();
        btnEquipNvTipo = new javax.swing.JButton();
        lblEquipDescricao = new javax.swing.JLabel();
        txtEquipDescricao = new javax.swing.JTextField();
        lblEquipObservações = new javax.swing.JLabel();
        txtEquipObs = new javax.swing.JTextField();
        pnlDadosCliente = new javax.swing.JPanel();
        lblClienteCodigo = new javax.swing.JLabel();
        txtClienteCodigo = new javax.swing.JTextField();
        lblClienteNome = new javax.swing.JLabel();
        txtClienteNome = new javax.swing.JTextField();
        btnEquipPesqCli = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlCadEquip1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnEquipExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Excluir.png"))); // NOI18N
        btnEquipExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEquipExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEquipExcluir.setOpaque(false);

        btnEquipInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Inserir.png"))); // NOI18N
        btnEquipInserir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEquipInserir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEquipInserir.setOpaque(false);
        btnEquipInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipInserirActionPerformed(evt);
            }
        });

        btnEquipEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Editar.png"))); // NOI18N
        btnEquipEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEquipEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEquipEditar.setOpaque(false);

        btnEquipPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Pesquisar.png"))); // NOI18N
        btnEquipPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEquipPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEquipPesquisar.setOpaque(false);
        btnEquipPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipPesquisarActionPerformed(evt);
            }
        });

        btnEquipSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Sair.png"))); // NOI18N
        btnEquipSair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEquipSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEquipSair.setOpaque(false);
        btnEquipSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipSairActionPerformed(evt);
            }
        });

        jspEquip2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jspEquip1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnEquipSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Salvar.png"))); // NOI18N
        btnEquipSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEquipSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEquipSalvar.setOpaque(false);
        btnEquipSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipSalvarActionPerformed(evt);
            }
        });

        btnEquipDesfazer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Desfazer.png"))); // NOI18N
        btnEquipDesfazer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEquipDesfazer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEquipDesfazer.setOpaque(false);
        btnEquipDesfazer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipDesfazerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCadEquip1Layout = new javax.swing.GroupLayout(pnlCadEquip1);
        pnlCadEquip1.setLayout(pnlCadEquip1Layout);
        pnlCadEquip1Layout.setHorizontalGroup(
            pnlCadEquip1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadEquip1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnEquipInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEquipEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEquipExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEquipSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEquipDesfazer, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jspEquip1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEquipPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jspEquip2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEquipSair, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        pnlCadEquip1Layout.setVerticalGroup(
            pnlCadEquip1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadEquip1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCadEquip1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jspEquip2)
                    .addComponent(btnEquipPesquisar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btnEquipExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEquipSair, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jspEquip1)
                    .addComponent(btnEquipSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEquipDesfazer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEquipEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btnEquipInserir, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlCadEquip2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pnlDadosEquip.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Equipamento"));

        lblEquipCodigo.setText("Código:");

        txtEquipCodigo.setToolTipText("");

        lblEquipMarca.setText("Marca:");

        txtEquipMarca.setToolTipText("");

        txtEquipModelo.setToolTipText("");

        lblEquipModelo.setText("Modelo:");

        lblEquipSerie.setText("Série:");

        txtEquipSerie.setToolTipText("");

        lblEquipTipo.setText("Tipo do Equipamento:");

        btnEquipNvTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/+.png"))); // NOI18N
        btnEquipNvTipo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblEquipDescricao.setText("Descrição:");

        lblEquipObservações.setText("Observações:");

        javax.swing.GroupLayout pnlDadosEquipLayout = new javax.swing.GroupLayout(pnlDadosEquip);
        pnlDadosEquip.setLayout(pnlDadosEquipLayout);
        pnlDadosEquipLayout.setHorizontalGroup(
            pnlDadosEquipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosEquipLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosEquipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlDadosEquipLayout.createSequentialGroup()
                        .addComponent(lblEquipCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEquipCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblEquipMarca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEquipMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblEquipModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEquipModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDadosEquipLayout.createSequentialGroup()
                        .addComponent(lblEquipSerie)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEquipSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(lblEquipTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEquipNvTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbTipoEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosEquipLayout.createSequentialGroup()
                        .addGroup(pnlDadosEquipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEquipObservações)
                            .addComponent(lblEquipDescricao))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDadosEquipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEquipObs)
                            .addComponent(txtEquipDescricao))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDadosEquipLayout.setVerticalGroup(
            pnlDadosEquipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosEquipLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosEquipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEquipCodigo)
                    .addComponent(txtEquipCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEquipMarca)
                    .addComponent(txtEquipMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEquipModelo)
                    .addComponent(txtEquipModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosEquipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbTipoEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEquipNvTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDadosEquipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEquipTipo)
                        .addComponent(lblEquipSerie)
                        .addComponent(txtEquipSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosEquipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEquipDescricao)
                    .addComponent(txtEquipDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(pnlDadosEquipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEquipObservações)
                    .addComponent(txtEquipObs, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlDadosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Cliente"));

        lblClienteCodigo.setText("Código:");

        txtClienteCodigo.setToolTipText("");

        lblClienteNome.setText("Nome:");

        txtClienteNome.setToolTipText("");

        btnEquipPesqCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/LupaPeq.png"))); // NOI18N
        btnEquipPesqCli.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEquipPesqCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipPesqCliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDadosClienteLayout = new javax.swing.GroupLayout(pnlDadosCliente);
        pnlDadosCliente.setLayout(pnlDadosClienteLayout);
        pnlDadosClienteLayout.setHorizontalGroup(
            pnlDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClienteCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClienteCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEquipPesqCli, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblClienteNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtClienteNome)
                .addContainerGap())
        );
        pnlDadosClienteLayout.setVerticalGroup(
            pnlDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEquipPesqCli, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblClienteCodigo)
                        .addComponent(txtClienteCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblClienteNome)
                        .addComponent(txtClienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCadEquip2Layout = new javax.swing.GroupLayout(pnlCadEquip2);
        pnlCadEquip2.setLayout(pnlCadEquip2Layout);
        pnlCadEquip2Layout.setHorizontalGroup(
            pnlCadEquip2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadEquip2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCadEquip2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDadosEquip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDadosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );
        pnlCadEquip2Layout.setVerticalGroup(
            pnlCadEquip2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadEquip2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDadosEquip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDadosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCadEquip1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlCadEquip2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlCadEquip1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCadEquip2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEquipSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipSairActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnEquipSairActionPerformed

    private void btnEquipSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipSalvarActionPerformed
        int cod=0;
        for(TipoEquip a: TiposEquip){
            if(a.getDescricao().equals(cbbTipoEquip.getSelectedItem().toString()))
                cod = a.getCodigo();
        }
        
        DAOEquipamento qry = new DAOEquipamento();
        if (press_edit == false){ //SALVA
            if(txtEquipCodigo.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Código é obrigatório!!!","Aviso",JOptionPane.WHEN_IN_FOCUSED_WINDOW);
                txtEquipCodigo.requestFocus();
            }else if(txtEquipMarca.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Marca é obrigatório!!!","Aviso",JOptionPane.WHEN_IN_FOCUSED_WINDOW);
                txtEquipMarca.requestFocus();
            }else if(txtEquipModelo.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Modelo é obrigatório!!!","Aviso",JOptionPane.WHEN_IN_FOCUSED_WINDOW);
                txtEquipModelo.requestFocus();
            }else if(txtClienteCodigo.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Código do Cliente é obrigatório!!!","Aviso",JOptionPane.WHEN_IN_FOCUSED_WINDOW);
                txtClienteCodigo.requestFocus();
            }else{
                qry.salvar(this.getDados(cod));
                JOptionPane.showMessageDialog(null, "Equipamento inserido com sucesso!!!");
                this.LimparCampos();
                HabilitarBotoes();
                DesabilitarCampos();
            }
        }else{  //EDITA
            qry.editar(this.getDados(cod), txtEquipCodigo.getText());
            JOptionPane.showMessageDialog(null, "Equipamento editado com sucesso!!!");
            press_edit = false;
            this.LimparCampos();
            HabilitarBotoes();
            DesabilitarCampos();
        }
    }//GEN-LAST:event_btnEquipSalvarActionPerformed

    private void btnEquipInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipInserirActionPerformed
        HabilitarCampos();
        DesabilitarBotoes();
        txtEquipCodigo.requestFocus();
    }//GEN-LAST:event_btnEquipInserirActionPerformed

    private void btnEquipDesfazerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipDesfazerActionPerformed
        LimparCampos();
        DesabilitarCampos();
        HabilitarBotoes();
        press_edit = false;
    }//GEN-LAST:event_btnEquipDesfazerActionPerformed

    private void btnEquipPesqCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipPesqCliActionPerformed
        frmPesqCliente pesqCliente = new frmPesqCliente(null, rootPaneCheckingEnabled);
        pesqCliente.setVisible(true);
        Cliente cliente = pesqCliente.getClienteSelecionado();
        if(cliente != null){
            setDadosCliente(cliente);
        }
    }//GEN-LAST:event_btnEquipPesqCliActionPerformed

    private void btnEquipPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipPesquisarActionPerformed
        frmPesqEquip pesqEquip = new frmPesqEquip(null, rootPaneCheckingEnabled);
        pesqEquip.setVisible(true);
        Equipamento equip = pesqEquip.getEquipamentoSelecionado();
        if(equip != null){
            setDados(equip);
        }
        if(txtEquipCodigo.getText().trim().isEmpty()){
            HabilitarBotoes();
        }else{
            btnEquipInserir.setEnabled(false);
            btnEquipEditar.setEnabled(true);
            btnEquipExcluir.setEnabled(true);
        }
    }//GEN-LAST:event_btnEquipPesquisarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmCadEquip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCadEquip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCadEquip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCadEquip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEquipDesfazer;
    private javax.swing.JButton btnEquipEditar;
    private javax.swing.JButton btnEquipExcluir;
    private javax.swing.JButton btnEquipInserir;
    private javax.swing.JButton btnEquipNvTipo;
    private javax.swing.JButton btnEquipPesqCli;
    private javax.swing.JButton btnEquipPesquisar;
    private javax.swing.JButton btnEquipSair;
    private javax.swing.JButton btnEquipSalvar;
    private javax.swing.JComboBox<String> cbbTipoEquip;
    private javax.swing.JSeparator jspEquip1;
    private javax.swing.JSeparator jspEquip2;
    private javax.swing.JLabel lblClienteCodigo;
    private javax.swing.JLabel lblClienteNome;
    private javax.swing.JLabel lblEquipCodigo;
    private javax.swing.JLabel lblEquipDescricao;
    private javax.swing.JLabel lblEquipMarca;
    private javax.swing.JLabel lblEquipModelo;
    private javax.swing.JLabel lblEquipObservações;
    private javax.swing.JLabel lblEquipSerie;
    private javax.swing.JLabel lblEquipTipo;
    private javax.swing.JPanel pnlCadEquip1;
    private javax.swing.JPanel pnlCadEquip2;
    private javax.swing.JPanel pnlDadosCliente;
    private javax.swing.JPanel pnlDadosEquip;
    private javax.swing.JTextField txtClienteCodigo;
    private javax.swing.JTextField txtClienteNome;
    private javax.swing.JTextField txtEquipCodigo;
    private javax.swing.JTextField txtEquipDescricao;
    private javax.swing.JTextField txtEquipMarca;
    private javax.swing.JTextField txtEquipModelo;
    private javax.swing.JTextField txtEquipObs;
    private javax.swing.JTextField txtEquipSerie;
    // End of variables declaration//GEN-END:variables
}
