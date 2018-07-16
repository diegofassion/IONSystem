package ionsystem;
import java.awt.FlowLayout;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frmCadOs extends javax.swing.JDialog {
    private boolean press_edit;
    private ArrayList<Funcionario> Funcionarios;
    private ArrayList<Equipamento> Equipamentos;
    private float valor_serv = 0;
    private float valor_peca = 0;
    private Connection con;
    private PreparedStatement qry;
    
    Object[] coluna = new Object[]{"Cod. OS","Cod. Serv/Prod","Descrição","Preço"};
    DefaultTableModel model = new DefaultTableModel(coluna, 0);
    DefaultTableModel model2 = new DefaultTableModel(coluna, 0);
    
    DAOOs dao = new DAOOs();
    
    public frmCadOs(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setLocationRelativeTo(null); 
        
        DAOFuncionario qry = new DAOFuncionario();
        Funcionarios= qry.ListarTodosFuncionarios(); //PUXA A LISTA DE FUNCIONÁRIOS
        cbbFuncionario.addItem("Selecione o Funcionários");
        for(Funcionario a: Funcionarios) //CARREGA OS ITENS NO COMBOBOX
            cbbFuncionario.addItem(a.getNome());
        
        HabilitarBotoes();
        DesabilitarCampos();
        
        txtValorOutros.setEnabled(false);
        txtValorOutros.setText(String.valueOf("0.0"));
        txtValorPecas.setEnabled(false);
        txtValorPecas.setText(String.valueOf("0.0"));
        txtValorServ.setEnabled(false);
        txtValorServ.setText(String.valueOf("0.0"));
        txtValorTotal.setEnabled(false);
        txtValorTotal.setText(String.valueOf("0.0"));
        
        tblServicos.setModel(model);
        tblServicos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblServicos.getColumnModel().getColumn(0).setPreferredWidth(58);
        tblServicos.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblServicos.getColumnModel().getColumn(2).setPreferredWidth(260);
        tblServicos.getColumnModel().getColumn(3).setPreferredWidth(100);
        
        tblPecas.setModel(model2);
        tblPecas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblPecas.getColumnModel().getColumn(0).setPreferredWidth(58);
        tblPecas.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblPecas.getColumnModel().getColumn(2).setPreferredWidth(260);
        tblPecas.getColumnModel().getColumn(3).setPreferredWidth(100);
    }
    
    private void LimparCampos(){
        txtCodigo.setText("");
        cbbFuncionario.setSelectedIndex(0);
        txtDataEnt.setValue(null);
        txtDataSaida.setValue(null);
        txtEquipCod.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtClienteCodigo.setText("");
        txtClienteNome.setText("");
        txtValorOutros.setText(String.valueOf("0.0"));
        txtValorPecas.setText(String.valueOf("0.0"));
        txtValorServ.setText(String.valueOf("0.0"));
        txtValorTotal.setText(String.valueOf("0.0"));
        while (tblServicos.getRowCount() > 0) {
            model.removeRow(0);
        }
        while (tblPecas.getRowCount() > 0) {
            model2.removeRow(0);
        }
    }
    
    private void HabilitarBotoes(){
        btnInserirOs.setEnabled(true);
        btnEditarOs.setEnabled(false);
        btnExcluirOs.setEnabled(false);
        btnPesquisarOs.setEnabled(true);
        btnDesfazerOs.setEnabled(false);
        btnSalvarOs.setEnabled(false);
        btnSairOs.setEnabled(true);
        btnAdServ.setEnabled(false);
        btnAdPeca.setEnabled(false);
        btnExServ.setEnabled(false);
        btnExPeca.setEnabled(false);
    }
    
    public void DesabilitarBotoes(){
        btnInserirOs.setEnabled(false);
        btnEditarOs.setEnabled(false);
        btnExcluirOs.setEnabled(false);
        btnPesquisarOs.setEnabled(false);
        btnDesfazerOs.setEnabled(true);
        btnSalvarOs.setEnabled(true);
        btnSairOs.setEnabled(false);
        btnAdServ.setEnabled(true);
        btnAdPeca.setEnabled(true);
        btnExServ.setEnabled(true);
        btnExPeca.setEnabled(true);
    }
        
    private void HabilitarCampos(){
        cbbSituacao.setEnabled(true);
        cbbFuncionario.setEnabled(true);
        txtDataEnt.setEnabled(true);
        txtDataSaida.setEnabled(true);
        btnPesqEquip.setEnabled(true);
        btnPesqCliente.setEnabled(true);
        txtValorOutros.setEnabled(true);
    }
    
    private void DesabilitarCampos(){
        txtCodigo.setEnabled(false);
        cbbSituacao.setEnabled(false);
        cbbFuncionario.setEnabled(false);
        txtDataEnt.setEnabled(false);
        txtDataSaida.setEnabled(false);
        txtEquipCod.setEnabled(false);
        txtMarca.setEnabled(false);
        txtModelo.setEnabled(false);
        txtClienteCodigo.setEnabled(false);
        txtClienteNome.setEnabled(false);
        txtValorOutros.setEnabled(false);
        btnPesqEquip.setEnabled(false);
        btnPesqCliente.setEnabled(false);
    }
    
    private Os getDados(int func){
        Os a = new Os();
        a.setCodigo(Integer.parseInt(txtCodigo.getText()));
        a.setSituacao(cbbSituacao.getSelectedItem().toString());
        a.setCod_Funcionario(func);
        a.setCod_Equip(Integer.parseInt(txtEquipCod.getText()));
        
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        try {
            data.parse(txtDataEnt.getText());
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(frmCadOs.class.getName()).log(Level.SEVERE, null, ex);
        }
            a.setDataEnt(data.getCalendar());
        try {
            if(txtDataSaida.getText().equals("  /  /    "))
                data.parse("01/01/1900");
            else{
                data.parse(txtDataSaida.getText());
            }
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(frmCadOs.class.getName()).log(Level.SEVERE, null, ex);
        }
            a.setDataSaida(data.getCalendar());
        a.setMarca(txtMarca.getText());
        a.setModelo(txtModelo.getText());
        a.setCod_Cliente(Integer.parseInt(txtClienteCodigo.getText()));
        a.setNome_Cli(txtClienteNome.getText());
        a.setValor_Serv(Float.parseFloat(txtValorServ.getText()));
        a.setValor_Pecas(Float.parseFloat(txtValorPecas.getText()));
        a.setValor_Outros(Float.parseFloat(txtValorOutros.getText()));
        a.setValor_Total(Float.parseFloat(txtValorTotal.getText()));
        return a;
    }
    
    private ArrayList<ItemOsServ> getDadosItServ(){
        ArrayList<ItemOsServ> ItemOsServs = new ArrayList<ItemOsServ>();
        ItemOsServ a = new ItemOsServ();
        for(int i = 1; i < tblServicos.getRowCount(); i++){
            a.setCod_OS_Serv(Integer.parseInt((String)tblServicos.getValueAt(i,0)));
            a.setCod_Serv((int)tblServicos.getValueAt(i, 1));
            a.setDescricao((String)tblServicos.getValueAt(i, 2));
            a.setPreco((float)tblServicos.getValueAt(i, 3)); 
            ItemOsServs.add(a);
        }
        return ItemOsServs;
    }
    
    private ArrayList<ItemOsPeca> getDadosItPeca(){
        ArrayList<ItemOsPeca> itemOsPecas = new ArrayList<ItemOsPeca>();
        ItemOsPeca a = new ItemOsPeca();
        for(int i = 1; i < tblPecas.getRowCount(); i++){
            a.setCod_OS1(Integer.parseInt((String)tblPecas.getValueAt(i, 0)));
            a.setCod_Peca((int)tblPecas.getValueAt(i, 1));
            a.setDescricao((String)tblPecas.getValueAt(i, 2));
            a.setPreco((float)tblPecas.getValueAt(i, 3));
            itemOsPecas.add(a);
        }
        return itemOsPecas;
    }
    
    private void setDados(Os a){
        txtCodigo.setText(String.valueOf(a.getCodigo()));
        txtClienteNome.setText(a.getNome_Cli());
        txtMarca.setText(a.getMarca());
        txtModelo.setText(a.getModelo());
    }
    
    private void setDadosEquip(Equipamento a){
        txtEquipCod.setText(String.valueOf(a.getCod_Equip()));
        txtMarca.setText(String.valueOf(a.getMarca()));
        txtModelo.setText(a.getModelo());
    }
    
    private void setDadosCliente(Cliente a){
        txtClienteCodigo.setText(String.valueOf(a.getCod_Cliente()));
        txtClienteNome.setText(a.getNome());
    }
    
    private void Calcular(){
        float total = Float.parseFloat(txtValorPecas.getText())+ Float.parseFloat(txtValorServ.getText()) + Float.parseFloat(txtValorOutros.getText());
        txtValorTotal.setText(String.valueOf(total));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        pnlOs1 = new javax.swing.JPanel();
        btnExcluirOs = new javax.swing.JButton();
        btnInserirOs = new javax.swing.JButton();
        btnEditarOs = new javax.swing.JButton();
        btnPesquisarOs = new javax.swing.JButton();
        btnSairOs = new javax.swing.JButton();
        jspCliente2 = new javax.swing.JSeparator();
        jspCliente1 = new javax.swing.JSeparator();
        btnSalvarOs = new javax.swing.JButton();
        btnDesfazerOs = new javax.swing.JButton();
        pnlOs2 = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        pnlDadosCliente = new javax.swing.JPanel();
        lblClienteNome = new javax.swing.JLabel();
        txtClienteNome = new javax.swing.JTextField();
        btnPesqCliente = new javax.swing.JButton();
        txtClienteCodigo = new javax.swing.JTextField();
        lblClienteCodigo = new javax.swing.JLabel();
        pnlDadosEquip = new javax.swing.JPanel();
        lblClienteNome1 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        btnPesqEquip = new javax.swing.JButton();
        lblClienteCodigo1 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        lblEquipCodigo = new javax.swing.JLabel();
        txtEquipCod = new javax.swing.JTextField();
        lblSituacao = new javax.swing.JLabel();
        cbbSituacao = new javax.swing.JComboBox<>();
        pnlData = new javax.swing.JPanel();
        lblClienteCodigo2 = new javax.swing.JLabel();
        lblClienteCodigo3 = new javax.swing.JLabel();
        txtDataEnt = new javax.swing.JFormattedTextField();
        txtDataSaida = new javax.swing.JFormattedTextField();
        pnlValores = new javax.swing.JPanel();
        lblClienteCodigo4 = new javax.swing.JLabel();
        txtValorServ = new javax.swing.JTextField();
        txtValorPecas = new javax.swing.JTextField();
        lblClienteCodigo5 = new javax.swing.JLabel();
        txtValorOutros = new javax.swing.JTextField();
        lblClienteCodigo6 = new javax.swing.JLabel();
        lblClienteCodigo7 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        pngServPeca = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblServicos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServicos = new javax.swing.JTable();
        btnAdServ = new javax.swing.JButton();
        btnExServ = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblServicos1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPecas = new javax.swing.JTable();
        btnAdPeca = new javax.swing.JButton();
        btnExPeca = new javax.swing.JButton();
        lblFuncionario = new javax.swing.JLabel();
        cbbFuncionario = new javax.swing.JComboBox<>();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlOs1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnExcluirOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Excluir.png"))); // NOI18N
        btnExcluirOs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExcluirOs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluirOs.setOpaque(false);
        btnExcluirOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirOsActionPerformed(evt);
            }
        });

        btnInserirOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Inserir.png"))); // NOI18N
        btnInserirOs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnInserirOs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInserirOs.setOpaque(false);
        btnInserirOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirOsActionPerformed(evt);
            }
        });

        btnEditarOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Editar.png"))); // NOI18N
        btnEditarOs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditarOs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditarOs.setOpaque(false);
        btnEditarOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarOsActionPerformed(evt);
            }
        });

        btnPesquisarOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Pesquisar.png"))); // NOI18N
        btnPesquisarOs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPesquisarOs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPesquisarOs.setOpaque(false);
        btnPesquisarOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarOsActionPerformed(evt);
            }
        });

        btnSairOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Sair.png"))); // NOI18N
        btnSairOs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSairOs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSairOs.setOpaque(false);
        btnSairOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairOsActionPerformed(evt);
            }
        });

        jspCliente2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jspCliente1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnSalvarOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Salvar.png"))); // NOI18N
        btnSalvarOs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalvarOs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvarOs.setOpaque(false);
        btnSalvarOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarOsActionPerformed(evt);
            }
        });

        btnDesfazerOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Desfazer.png"))); // NOI18N
        btnDesfazerOs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesfazerOs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDesfazerOs.setOpaque(false);
        btnDesfazerOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesfazerOsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOs1Layout = new javax.swing.GroupLayout(pnlOs1);
        pnlOs1.setLayout(pnlOs1Layout);
        pnlOs1Layout.setHorizontalGroup(
            pnlOs1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOs1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInserirOs, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditarOs, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExcluirOs, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalvarOs, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDesfazerOs, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jspCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisarOs, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jspCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSairOs, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        pnlOs1Layout.setVerticalGroup(
            pnlOs1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOs1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOs1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jspCliente2)
                    .addComponent(btnPesquisarOs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btnExcluirOs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSairOs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jspCliente1)
                    .addComponent(btnSalvarOs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDesfazerOs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditarOs, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btnInserirOs, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlOs2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCodigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCodigo.setText("O.S. nº :");

        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCodigo.setToolTipText("");

        pnlDadosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lblClienteNome.setText("Nome:");

        txtClienteNome.setToolTipText("");

        btnPesqCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/LupaPeq.png"))); // NOI18N
        btnPesqCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPesqCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqClienteActionPerformed(evt);
            }
        });

        txtClienteCodigo.setToolTipText("");

        lblClienteCodigo.setText("Código:");

        javax.swing.GroupLayout pnlDadosClienteLayout = new javax.swing.GroupLayout(pnlDadosCliente);
        pnlDadosCliente.setLayout(pnlDadosClienteLayout);
        pnlDadosClienteLayout.setHorizontalGroup(
            pnlDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPesqCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblClienteCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClienteCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblClienteNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtClienteNome)
                .addContainerGap())
        );
        pnlDadosClienteLayout.setVerticalGroup(
            pnlDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosClienteLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPesqCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblClienteCodigo)
                        .addComponent(txtClienteCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblClienteNome))
                    .addComponent(txtClienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDadosEquip.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Equipamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lblClienteNome1.setText("Mod.:");

        txtModelo.setToolTipText("");

        btnPesqEquip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/LupaPeq.png"))); // NOI18N
        btnPesqEquip.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPesqEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqEquipActionPerformed(evt);
            }
        });

        lblClienteCodigo1.setText("Marca :");

        txtMarca.setToolTipText("");

        lblEquipCodigo.setText("Cod:");

        txtEquipCod.setToolTipText("");

        javax.swing.GroupLayout pnlDadosEquipLayout = new javax.swing.GroupLayout(pnlDadosEquip);
        pnlDadosEquip.setLayout(pnlDadosEquipLayout);
        pnlDadosEquipLayout.setHorizontalGroup(
            pnlDadosEquipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosEquipLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPesqEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEquipCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEquipCod, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblClienteCodigo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblClienteNome1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDadosEquipLayout.setVerticalGroup(
            pnlDadosEquipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosEquipLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosEquipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPesqEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDadosEquipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblClienteNome1)
                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblClienteCodigo1)
                        .addComponent(lblEquipCodigo)
                        .addComponent(txtEquipCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        lblSituacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSituacao.setText("Situação :");

        cbbSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aguardando Autorização do Orçamento", "Aguardando Avalização do Técnico", "Autorizado, Aguardando Peça", "Autorizado, Reparo em Andamento", "Pronto, Avisar Cliente", "Pronto, Cliente Avisado" }));

        pnlData.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lblClienteCodigo2.setText("Entrada :");

        lblClienteCodigo3.setText("Saída :");

        try {
            txtDataEnt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDataSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataSaida.setToolTipText("");

        javax.swing.GroupLayout pnlDataLayout = new javax.swing.GroupLayout(pnlData);
        pnlData.setLayout(pnlDataLayout);
        pnlDataLayout.setHorizontalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtDataEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblClienteCodigo2)
                    .addComponent(lblClienteCodigo3)
                    .addComponent(txtDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDataLayout.setVerticalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClienteCodigo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDataEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblClienteCodigo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pnlValores.setBackground(new java.awt.Color(204, 204, 204));
        pnlValores.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblClienteCodigo4.setText("Serviços   R$");

        txtValorServ.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtValorServ.setToolTipText("");
        txtValorServ.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorServFocusLost(evt);
            }
        });

        txtValorPecas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtValorPecas.setToolTipText("");
        txtValorPecas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorPecasFocusLost(evt);
            }
        });

        lblClienteCodigo5.setText("Peças       R$");

        txtValorOutros.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtValorOutros.setToolTipText("");
        txtValorOutros.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorOutrosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorOutrosFocusLost(evt);
            }
        });
        txtValorOutros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorOutrosActionPerformed(evt);
            }
        });

        lblClienteCodigo6.setText("Outros     R$");

        lblClienteCodigo7.setText("TOTAL     R$");

        txtValorTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtValorTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtValorTotal.setToolTipText("");

        javax.swing.GroupLayout pnlValoresLayout = new javax.swing.GroupLayout(pnlValores);
        pnlValores.setLayout(pnlValoresLayout);
        pnlValoresLayout.setHorizontalGroup(
            pnlValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblClienteCodigo4)
                    .addComponent(lblClienteCodigo6)
                    .addComponent(lblClienteCodigo5)
                    .addComponent(lblClienteCodigo7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtValorServ, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorPecas, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorOutros, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnlValoresLayout.setVerticalGroup(
            pnlValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClienteCodigo4)
                    .addComponent(txtValorServ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClienteCodigo5)
                    .addComponent(txtValorPecas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClienteCodigo6)
                    .addComponent(txtValorOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClienteCodigo7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pngServPeca.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        pngServPeca.setInheritsPopupMenu(true);
        pngServPeca.setName(""); // NOI18N

        lblServicos.setText("Lista de Serviços executados nesta O.S.:");

        tblServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblServicos);

        btnAdServ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Adicionar.png"))); // NOI18N
        btnAdServ.setText("jButton1");
        btnAdServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdServActionPerformed(evt);
            }
        });

        btnExServ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Remover.png"))); // NOI18N
        btnExServ.setText("jButton1");
        btnExServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExServActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblServicos)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdServ, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExServ, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblServicos)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnAdServ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExServ)
                        .addContainerGap(37, Short.MAX_VALUE))))
        );

        pngServPeca.addTab("Serviços / Mão de Obra", jPanel1);

        lblServicos1.setText("Lista de Peças utilizadas nesta O.S.:");

        tblPecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblPecas);

        btnAdPeca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Adicionar.png"))); // NOI18N
        btnAdPeca.setText("jButton1");
        btnAdPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdPecaActionPerformed(evt);
            }
        });

        btnExPeca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Remover.png"))); // NOI18N
        btnExPeca.setText("jButton1");
        btnExPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExPecaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblServicos1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblServicos1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnAdPeca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExPeca)
                        .addContainerGap(37, Short.MAX_VALUE))))
        );

        pngServPeca.addTab("Peças Utlizadas", jPanel2);

        lblFuncionario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFuncionario.setText("Técnico :");

        javax.swing.GroupLayout pnlOs2Layout = new javax.swing.GroupLayout(pnlOs2);
        pnlOs2.setLayout(pnlOs2Layout);
        pnlOs2Layout.setHorizontalGroup(
            pnlOs2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOs2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlOs2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pngServPeca)
                    .addGroup(pnlOs2Layout.createSequentialGroup()
                        .addGroup(pnlOs2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlOs2Layout.createSequentialGroup()
                                .addComponent(lblCodigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlData, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlOs2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlOs2Layout.createSequentialGroup()
                                .addComponent(lblSituacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbSituacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(lblFuncionario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlOs2Layout.createSequentialGroup()
                                .addGroup(pnlOs2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pnlDadosEquip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pnlDadosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pnlValores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlOs2Layout.setVerticalGroup(
            pnlOs2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOs2Layout.createSequentialGroup()
                .addGroup(pnlOs2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOs2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(pnlOs2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlOs2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblSituacao)
                                .addComponent(cbbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlOs2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCodigo)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOs2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlOs2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFuncionario)
                            .addComponent(cbbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(pnlOs2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlOs2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnlOs2Layout.createSequentialGroup()
                            .addComponent(pnlDadosEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlDadosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(pnlData, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlValores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(pngServPeca)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlOs1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlOs2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlOs1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlOs2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirOsActionPerformed
        DAOOs qry = new DAOOs();
        qry.excluir(txtCodigo.getText());
        this.LimparCampos();
        HabilitarBotoes();
        JOptionPane.showMessageDialog(null, "Ordem de Serviço Excluída com Sucesso!!!");
    }//GEN-LAST:event_btnExcluirOsActionPerformed

    private void btnInserirOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirOsActionPerformed
        HabilitarCampos();
        DesabilitarBotoes();
        txtCodigo.setText(String.valueOf(dao.CodMax()));
    }//GEN-LAST:event_btnInserirOsActionPerformed

    private void btnEditarOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarOsActionPerformed
        press_edit = true;
        DesabilitarBotoes();
        HabilitarCampos();
        txtCodigo.requestFocus(true);
    }//GEN-LAST:event_btnEditarOsActionPerformed

    private void btnPesquisarOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarOsActionPerformed
        
    }//GEN-LAST:event_btnPesquisarOsActionPerformed

    private void btnSairOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairOsActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnSairOsActionPerformed

    private void btnSalvarOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarOsActionPerformed
        int codFunc=0;// codEquip=0;
        for(Funcionario a: Funcionarios){
            if(a.getNome().equals(cbbFuncionario.getSelectedItem().toString()))
                codFunc = a.getCod_Funcionario();
        }
        
        DAOOs qry = new DAOOs();
        if (press_edit == false){ //SALVA
            if(txtCodigo.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Código é obrigatório!!!","Aviso",JOptionPane.WHEN_IN_FOCUSED_WINDOW);
                txtCodigo.requestFocus();
            }else if(txtDataEnt.getText().equals("  /  /    ")){
                JOptionPane.showMessageDialog(null, "Data de Entrada é campo obrigatório!!!","Aviso",JOptionPane.WHEN_IN_FOCUSED_WINDOW);
                txtDataEnt.requestFocus();
            }else if(txtMarca.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "A marca é campo obrigatório!!!","Aviso",JOptionPane.WHEN_IN_FOCUSED_WINDOW);
                txtMarca.requestFocus();
            }else if(txtModelo.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Modelo é um campo obrigatório!", "Aviso", JOptionPane.WARNING_MESSAGE);
                txtModelo.requestFocus();
            }else if(cbbFuncionario.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null, "Selecione um funcionário!!!","Aviso",JOptionPane.WHEN_IN_FOCUSED_WINDOW);
                cbbFuncionario.requestFocus();
            }else if(txtClienteCodigo.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "O Cliente é obrigatório!", "Aviso", JOptionPane.WARNING_MESSAGE);
                txtClienteCodigo.requestFocus();
            }else if(txtClienteNome.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "O nome do cliente é um campo obrigatório!", "Aviso", JOptionPane.WARNING_MESSAGE);
                txtClienteNome.requestFocus();
            }else if(txtValorTotal.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Ordem de Serviço está ZERADA, insira valores!!!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }else{
                qry.salvarOS(this.getDados(codFunc));
                
                ArrayList<ItemOsServ> itemOsServs = this.getDadosItServ();
                for(int i = 0; i < itemOsServs.size(); i++){
                    qry.salvarItemServ(itemOsServs.get(i));
                }
                
                ArrayList<ItemOsPeca> itemOsPecas = this.getDadosItPeca();
                for(int i = 0; i < itemOsPecas.size(); i++){
                    qry.salvarItemPeca(itemOsPecas.get(i));
                }
                
                JOptionPane.showMessageDialog(null, "O.S. inserida com sucesso!!!");
                this.LimparCampos();
                HabilitarBotoes();
                DesabilitarCampos();
            }
        }else{  //EDITA
            qry.editar(this.getDados(codFunc), txtCodigo.getText());
            JOptionPane.showMessageDialog(null, "O.S. editada com sucesso!!!");
            press_edit = false;
            this.LimparCampos();
            HabilitarBotoes();
            DesabilitarCampos();
        }
    }//GEN-LAST:event_btnSalvarOsActionPerformed

    private void btnDesfazerOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesfazerOsActionPerformed
        LimparCampos();
        DesabilitarCampos();
        HabilitarBotoes();
        press_edit = false;
    }//GEN-LAST:event_btnDesfazerOsActionPerformed

    private void btnPesqClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqClienteActionPerformed
        frmPesqCliente PesqCliente = new frmPesqCliente(null, rootPaneCheckingEnabled);
        PesqCliente.setVisible(true);
        Cliente Cli = PesqCliente.getClienteSelecOS();
        if(Cli != null){
            setDadosCliente(Cli);
        }else{
            btnInserirOs.setEnabled(false);
            btnEditarOs.setEnabled(true);
            btnExcluirOs.setEnabled(true);
        }
    }//GEN-LAST:event_btnPesqClienteActionPerformed

    private void btnPesqEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqEquipActionPerformed
        frmPesqEquip PesqEquip = new frmPesqEquip(null, rootPaneCheckingEnabled);
        PesqEquip.setVisible(true);
        Equipamento Equip = PesqEquip.getEquipSelecOS();
        if(Equip != null){
            setDadosEquip(Equip);
        }else{
            btnInserirOs.setEnabled(false);
            btnEditarOs.setEnabled(true);
            btnExcluirOs.setEnabled(true);
        }
    }//GEN-LAST:event_btnPesqEquipActionPerformed

    private void txtValorOutrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorOutrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorOutrosActionPerformed

    private void txtValorOutrosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorOutrosFocusLost
        Calcular();
       
    }//GEN-LAST:event_txtValorOutrosFocusLost

    private void txtValorOutrosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorOutrosFocusGained
        //Calcular();
    }//GEN-LAST:event_txtValorOutrosFocusGained

    private void txtValorServFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorServFocusLost
        Calcular();
    }//GEN-LAST:event_txtValorServFocusLost

    private void txtValorPecasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorPecasFocusLost
        Calcular();
    }//GEN-LAST:event_txtValorPecasFocusLost

    private void btnAdServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdServActionPerformed
        frmPesqServico PesqServico = new frmPesqServico(null, rootPaneCheckingEnabled);
        PesqServico.setVisible(true);
        Servico OSserv = PesqServico.getServicoSelecionado();
        valor_serv = Float.parseFloat(txtValorServ.getText());
        if(OSserv != null){
            model.addRow(new Object[]{txtCodigo.getText(),OSserv.getCodigo(),OSserv.getDescricao(),OSserv.getPreco()});
            txtValorServ.setText(String.valueOf(valor_serv + OSserv.getPreco()));
            Calcular();
        }
    }//GEN-LAST:event_btnAdServActionPerformed

    private void btnExServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExServActionPerformed
        if(tblServicos.getSelectedRow() != -1){
            valor_serv = Float.parseFloat(txtValorServ.getText());
            txtValorServ.setText(String.valueOf(valor_serv - ((float)tblServicos.getValueAt(tblServicos.getSelectedRow(), 3))));
            model.removeRow(tblServicos.getSelectedRow());
            Calcular();
        }
    }//GEN-LAST:event_btnExServActionPerformed

    private void btnAdPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdPecaActionPerformed
        frmPesqPeca PesqPeca = new frmPesqPeca(null, rootPaneCheckingEnabled);
        PesqPeca.setVisible(true);
        Peca OSpeca = PesqPeca.getPecaSelecionada();
        valor_peca = Float.parseFloat(txtValorPecas.getText());
        if(OSpeca != null){
            model2.addRow(new Object[]{txtCodigo.getText(),OSpeca.getCod_Peca(),OSpeca.getDescricao(),OSpeca.getPreco()});
            txtValorPecas.setText(String.valueOf(valor_peca + OSpeca.getPreco()));
            Calcular();
        }
    }//GEN-LAST:event_btnAdPecaActionPerformed

    private void btnExPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExPecaActionPerformed
        if(tblPecas.getSelectedRow() != -1){
            valor_peca = Float.parseFloat(txtValorPecas.getText());
            txtValorPecas.setText(String.valueOf(valor_peca - ((float)tblPecas.getValueAt(tblPecas.getSelectedRow(), 3))));
            model2.removeRow(tblPecas.getSelectedRow());
            Calcular();
        }
    }//GEN-LAST:event_btnExPecaActionPerformed

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
            java.util.logging.Logger.getLogger(frmCadOs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCadOs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCadOs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCadOs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmCadOs dialog = new frmCadOs(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAdPeca;
    private javax.swing.JButton btnAdServ;
    private javax.swing.JButton btnDesfazerOs;
    private javax.swing.JButton btnEditarOs;
    private javax.swing.JButton btnExPeca;
    private javax.swing.JButton btnExServ;
    private javax.swing.JButton btnExcluirOs;
    private javax.swing.JButton btnInserirOs;
    private javax.swing.JButton btnPesqCliente;
    private javax.swing.JButton btnPesqEquip;
    private javax.swing.JButton btnPesquisarOs;
    private javax.swing.JButton btnSairOs;
    private javax.swing.JButton btnSalvarOs;
    private javax.swing.JComboBox<String> cbbFuncionario;
    private javax.swing.JComboBox<String> cbbSituacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jspCliente1;
    private javax.swing.JSeparator jspCliente2;
    private javax.swing.JLabel lblClienteCodigo;
    private javax.swing.JLabel lblClienteCodigo1;
    private javax.swing.JLabel lblClienteCodigo2;
    private javax.swing.JLabel lblClienteCodigo3;
    private javax.swing.JLabel lblClienteCodigo4;
    private javax.swing.JLabel lblClienteCodigo5;
    private javax.swing.JLabel lblClienteCodigo6;
    private javax.swing.JLabel lblClienteCodigo7;
    private javax.swing.JLabel lblClienteNome;
    private javax.swing.JLabel lblClienteNome1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblEquipCodigo;
    private javax.swing.JLabel lblFuncionario;
    private javax.swing.JLabel lblServicos;
    private javax.swing.JLabel lblServicos1;
    private javax.swing.JLabel lblSituacao;
    private javax.swing.JTabbedPane pngServPeca;
    private javax.swing.JPanel pnlDadosCliente;
    private javax.swing.JPanel pnlDadosEquip;
    private javax.swing.JPanel pnlData;
    private javax.swing.JPanel pnlOs1;
    private javax.swing.JPanel pnlOs2;
    private javax.swing.JPanel pnlValores;
    private javax.swing.JTable tblPecas;
    private javax.swing.JTable tblServicos;
    private javax.swing.JTextField txtClienteCodigo;
    private javax.swing.JTextField txtClienteNome;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtDataEnt;
    private javax.swing.JFormattedTextField txtDataSaida;
    private javax.swing.JTextField txtEquipCod;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtValorOutros;
    private javax.swing.JTextField txtValorPecas;
    private javax.swing.JTextField txtValorServ;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}
